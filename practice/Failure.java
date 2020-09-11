/* 2020-09-11
https://programmers.co.kr/learn/courses/30/lessons/42889    <---------------  링크추가
 <[2019 카카오블라인드 1차] - 실패율> - 배열, 정렬
 
 Test Case 1
 	- input : 	N = 5
 				stages = [2, 1, 2, 6, 2, 4, 3, 3]
 	- return : [3,4,2,1,5]
 	
 Test Case 2
 	- input : 	N = 4
 				stages = [4,4,4,4,4]
 	- return : [4,1,2,3]
 */

public class Failure {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 5;
		int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
		
		int[] answer = solution(N, stages);
		
		for(int i : answer) System.out.println(i);
	}
	
	public static int[] solution(int N, int[] stages) {
		int[] answer = new int[N];
        double[] failure = new double[N];
        
        for(int i=0; i<N; i++) answer[i] = i+1;		// 스테이지 번호 저장
        
        // 실패율을 저장
        for(int s=1; s<N+1; s++) {
        	int all = 0;
        	int success = 0;
        	for(int i : stages) {
        		if(i > s) {
        			success++;
        			all++;
        		}
        		else if(i == s) all++;
        	}
        	failure[s-1] = (double)(all-success) / (double)all;
        }
        
        // 실패율과 스테이지 번호 규칙에 맞춰 정렬
        for(int i=0; i<N-1; i++) {
        	for(int j=i+1; j<N; j++) {
        		if(failure[i] < failure[j]) {
        			int temp = answer[i];
        			answer[i] = answer[j];
        			answer[j] = temp;
        			double t = failure[i];
        			failure[i] = failure[j];
        			failure[j] = t;
        		}
        		if(failure[i] == failure[j] && answer[i] > answer[j]) {
        			int temp = answer[i];
        			answer[i] = answer[j];
        			answer[j] = temp;
        			double t = failure[i];
        			failure[i] = failure[j];
        			failure[j] = t;
        		}
        	}
        }
        
        return answer;
    }

}
