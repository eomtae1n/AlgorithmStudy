/* 2020-08-28
https://programmers.co.kr/learn/courses/30/lessons/17676    <---------------  링크추가
 <[2018 카카오블라인드 1차] - 추석 트래픽> - 날짜계산 (LocalDateTime 클래스)
 
 Test Case 1
 	- input : 	lines = ["2016-09-15 00:00:00.000 3s"]
 	- return : 1
 	
 Test Case 2
 	- input : 	lines = ["2016-09-15 23:59:59.999 0.001s"]
 	- return : 1
 	
 Test Case 3
 	- input : 	lines = ["2016-09-15 01:00:04.001 2.0s", 
 						"2016-09-15 01:00:07.000 2s"]
 	- return : 1
 	
 Test Case 4
 	- input : 	lines = ["2016-09-15 01:00:04.002 2.0s", 
 						"2016-09-15 01:00:07.000 2s"]
 	- return : 2
 	
 Test Case 5
 	- input : 	lines = ["2016-09-15 20:59:57.421 0.351s", 
 						"2016-09-15 20:59:58.233 1.181s", 
 						"2016-09-15 20:59:58.299 0.8s", 
 						"2016-09-15 20:59:58.688 1.041s", 
 						"2016-09-15 20:59:59.591 1.412s", 
 						"2016-09-15 21:00:00.464 1.466s", 
 						"2016-09-15 21:00:00.741 1.581s", 
 						"2016-09-15 21:00:00.748 2.31s", 
 						"2016-09-15 21:00:00.966 0.381s", 
 						"2016-09-15 21:00:02.066 2.62s"]
 	- return : 7
 	
 Test Case 6
 	- input : 	lines = ["2016-09-15 00:00:00.000 2.3s", "2016-09-15 23:59:59.999 0.1s"]
 	- return : 1
 	
 	
 	
--------- LocalDateTime 클래스 복습!!! ------------
1. LocalDateTime targetDateTime = LocalDateTime.of(int year, int month, int day, int hour, int minute, int second, int nano);

2. targetDateTime.plus(years, months, days, times, hours ...)

3. targetDateTime.minus(years, months, days, times, hours ...)

4. aTime.isBefore(bTime)
		--> aTime이 bTime보다 앞에 있는지 맞으면 true 틀리면 false
		
5. aTime.isAfter(bTime)
		--> aTime이 bTime보다 뒤에 있는지 맞으면 true 틀리면 false
		
6. aTime.isEqual(bTime)
		--> aTime이 bTime과 같은 시간인지 맞으면 true 틀리면 false
		
7. 참고할 사이트 주소
	https://java119.tistory.com/52
	https://jekalmin.tistory.com/entry/%EC%9E%90%EB%B0%94-18-%EB%82%A0%EC%A7%9C-%EC%A0%95%EB%A6%AC
 */

import java.time.LocalDateTime;

public class Traffic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] lines = {
							"2016-09-15 20:59:57.421 0.351s",
							"2016-09-15 20:59:58.233 1.181s",
							"2016-09-15 20:59:58.299 0.8s",
							"2016-09-15 20:59:58.688 1.041s",
							"2016-09-15 20:59:59.591 1.412s",
							"2016-09-15 21:00:00.464 1.466s",
							"2016-09-15 21:00:00.741 1.581s",
							"2016-09-15 21:00:00.748 2.31s",
							"2016-09-15 21:00:00.966 0.381s",
							"2016-09-15 21:00:02.066 2.62s"
						};
		
		System.out.println(solution(lines));
	}

	public static int solution(String[] lines) {
        int answer = 0;
        LocalDateTime[][] times = new LocalDateTime[lines.length][2];		// 응답 완료 시각과 응답 시작 시각을 저장한 배열
        
        for(int i=0; i<lines.length; i++) {
        	String[] split = lines[i].split(" ");
        	
        	LocalDateTime finishedTime = LocalDateTime.parse(split[0] + "T" + split[1]);		// 응답 완료 시각
        	
        	long T = (long)(Float.parseFloat(split[2].substring(0, split[2].length()-1)) * (float)1000000000) - 1000000;
        	T = T / 1000000;
        	T = T * 1000000;		// 처리 시간 T를 nanoSecond로 표현
        	
        	LocalDateTime startedTime = finishedTime.minusNanos(T);								// 응답 시작 시각 = 응답 완료 시각 - 처리시간
        	
        	//System.out.println(startedTime + " ~ " + finishedTime);
        	
        	times[i][0] = startedTime;
        	times[i][1] = finishedTime;
        }
        
        //System.out.println();
        for(int i=0; i<times.length; i++) {
        	LocalDateTime l1 = times[i][0];									// 응답 시작 시각
        	LocalDateTime l2 = l1.plusSeconds(1).minusNanos(1000000);		// 응답 시작 시각 + 1초
        	
        	//System.out.println(l1 + " ~ " + l2);
        	
        	int cnt1 = 0;
        	for(int j=0; j<times.length; j++) {								// 1초 내에 몇 개의 처리량이 있는지
        		if( (l1.isAfter(times[j][0]) || l1.isEqual(times[j][0])) && (l1.isBefore(times[j][1]) || l1.isEqual(times[j][1])) )
        				cnt1++;
        		else if( (l1.isBefore(times[j][0]) || l1.isEqual(times[j][0])) && (l2.isAfter(times[j][1]) || l2.isEqual(times[j][1])) )
        				cnt1++;
        		else if( (l2.isAfter(times[j][0]) || l2.isEqual(times[j][0])) && (l2.isBefore(times[j][1]) || l2.isEqual(times[j][1])) )
        				cnt1++;
        	}
        	
        	l1 = times[i][1];												// 응답 완료 시각
        	l2 = l1.plusSeconds(1).minusNanos(1000000);						// 응답 완료 시각 + 1초
        	
        	int cnt2 = 0;
        	for(int j=0; j<times.length; j++) {								// 1초 내에 몇 개의 처리량이 있는지
        		if( (l1.isAfter(times[j][0]) || l1.isEqual(times[j][0])) && (l1.isBefore(times[j][1]) || l1.isEqual(times[j][1])) )
        				cnt2++;
        		else if( (l1.isBefore(times[j][0]) || l1.isEqual(times[j][0])) && (l2.isAfter(times[j][1]) || l2.isEqual(times[j][1])) )
        				cnt2++;
        		else if( (l2.isAfter(times[j][0]) || l2.isEqual(times[j][0])) && (l2.isBefore(times[j][1]) || l2.isEqual(times[j][1])) )
        				cnt2++;
        	}
        	
        	if(answer < Math.max(cnt1, cnt2))
        		answer = Math.max(cnt1, cnt2);			// answer 갱신
        }
        
        return answer;
    }
	
}
