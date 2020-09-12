/*
 * 카카오TV에서 유명한 크리에이터로 활동 중인 죠르디는 환경 단체로부터 자신의 가장 인기있는 동영상에 지구온난화의 심각성을 알리기 위한 공익광고를 넣어 달라는 요청을 받았습니다. 평소에 환경 문제에 관심을 가지고 있던 죠르디는 요청을 받아들였고 광고효과를 높이기 위해 시청자들이 가장 많이 보는 구간에 공익광고를 넣으려고 합니다. 죠르디는 시청자들이 해당 동영상의 어떤 구간을 재생했는 지 알 수 있는 재생구간 기록을 구했고, 해당 기록을 바탕으로 공익광고가 삽입될 최적의 위치를 고를 수 있었습니다.
참고로 광고는 재생 중인 동영상의 오른쪽 아래에서 원래 영상과 동시에 재생되는 PIP(Picture in Picture) 형태로 제공됩니다.

2021_kakao_cf_01.png

다음은 죠르디가 공익광고가 삽입될 최적의 위치를 고르는 과정을 그림으로 설명한 것입니다.
2021_kakao_cf_02.png

그림의 파란색 선은 광고를 검토 중인 죠르디 동영상의 전체 재생 구간을 나타냅니다.
위 그림에서, 죠르디 동영상의 총 재생시간은 02시간 03분 55초 입니다.
그림의 검은색 선들은 각 시청자들이 죠르디의 동영상을 재생한 구간의 위치를 표시하고 있습니다.
검은색 선의 가운데 숫자는 각 재생 기록을 구분하는 ID를 나타냅니다.
검은색 선에 표기된 왼쪽 끝 숫자와 오른쪽 끝 숫자는 시청자들이 재생한 동영상 구간의 시작 시각과 종료 시각을 나타냅니다.
위 그림에서, 3번 재생 기록은 00시 25분 50초 부터 00시 48분 29초 까지 총 00시간 22분 39초 동안 죠르디의 동영상을 재생했습니다. 1
위 그림에서, 1번 재생 기록은 01시 20분 15초 부터 01시 45분 14초 까지 총 00시간 24분 59초 동안 죠르디의 동영상을 재생했습니다.
그림의 빨간색 선은 죠르디가 선택한 최적의 공익광고 위치를 나타냅니다.
만약 공익광고의 재생시간이 00시간 14분 15초라면, 위의 그림처럼 01시 30분 59초 부터 01시 45분 14초 까지 공익광고를 삽입하는 것이 가장 좋습니다. 이 구간을 시청한 시청자들의 누적 재생시간이 가장 크기 때문입니다.
01시 30분 59초 부터 01시 45분 14초 까지의 누적 재생시간은 다음과 같이 계산됩니다.
01시 30분 59초 부터 01시 37분 44초 까지 : 4번, 1번 재생 기록이 두차례 있으므로 재생시간의 합은 00시간 06분 45초 X 2 = 00시간 13분 30초
01시 37분 44초 부터 01시 45분 14초 까지 : 4번, 1번, 5번 재생 기록이 세차례 있으므로 재생시간의 합은 00시간 07분 30초 X 3 = 00시간 22분 30초
따라서, 이 구간 시청자들의 누적 재생시간은 00시간 13분 30초 + 00시간 22분 30초 = 00시간 36분 00초입니다.
[문제]
죠르디의 동영상 재생시간 길이 play_time, 공익광고의 재생시간 길이 adv_time, 시청자들이 해당 동영상을 재생했던 구간 정보 logs가 매개변수로 주어질 때, 시청자들의 누적 재생시간이 가장 많이 나오는 곳에 공익광고를 삽입하려고 합니다. 이때, 공익광고가 들어갈 시작 시각을 구해서 return 하도록 solution 함수를 완성해주세요. 만약, 시청자들의 누적 재생시간이 가장 많은 곳이 여러 곳이라면, 그 중에서 가장 빠른 시작 시각을 return 하도록 합니다.

[제한사항]
play_time, adv_time은 길이 8로 고정된 문자열입니다.
play_time, adv_time은 HH:MM:SS 형식이며, 00:00:01 이상 99:59:59 이하입니다.
즉, 동영상 재생시간과 공익광고 재생시간은 00시간 00분 1초 이상 99시간 59분 59초 이하입니다.
공익광고 재생시간은 동영상 재생시간보다 짧거나 같게 주어집니다.
logs는 크기가 1 이상 300,000 이하인 문자열 배열입니다.

logs 배열의 각 원소는 시청자의 재생 구간을 나타냅니다.
logs 배열의 각 원소는 길이가 17로 고정된 문자열입니다.
logs 배열의 각 원소는 H1:M1:S1-H2:M2:S2 형식입니다.
H1:M1:S1은 동영상이 시작된 시각, H2:M2:S2는 동영상이 종료된 시각을 나타냅니다.
H1:M1:S1는 H2:M2:S2보다 1초 이상 이전 시각으로 주어집니다.
H1:M1:S1와 H2:M2:S2는 play_time 이내의 시각입니다.
시간을 나타내는 HH, H1, H2의 범위는 00~99, 분을 나타내는 MM, M1, M2의 범위는 00~59, 초를 나타내는 SS, S1, S2의 범위는 00~59까지 사용됩니다. 잘못된 시각은 입력으로 주어지지 않습니다. (예: 04:60:24, 11:12:78, 123:12:45 등)

return 값의 형식

공익광고를 삽입할 시각을 HH:MM:SS 형식의 8자리 문자열로 반환합니다.
[입출력 예]
play_time	adv_time	logs	result
"02:03:55"	"00:14:15"	["01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"]	"01:30:59"
"99:59:59"	"25:00:00"	["69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"]	"01:00:00"
"50:00:00"	"50:00:00"	["15:36:51-38:21:49", "10:14:18-15:36:51", "38:21:49-42:51:45"]	"00:00:00"
입출력 예에 대한 설명
입출력 예 #1
문제 예시와 같습니다.

입출력 예 #2
2021_kakao_cf_03.png

01:00:00에 공익광고를 삽입하면 26:00:00까지 재생되며, 이곳이 가장 좋은 위치입니다. 이 구간의 시청자 누적 재생시간은 다음과 같습니다.

01:00:00-11:00:00 : 해당 구간이 1회(2번 기록) 재생되었으므로 누적 재생시간은 10시간 00분 00초 입니다.
11:00:00-21:00:00 : 해당 구간이 2회(2번, 4번 기록) 재생되었으므로 누적 재생시간은 20시간 00분 00초 입니다.
21:00:00-26:00:00 : 해당 구간이 1회(4번 기록) 재생되었으므로 누적 재생시간은 05시간 00분 00초 입니다.
따라서, 이 구간의 시청자 누적 재생시간은 10시간 00분 00초 + 20시간 00분 00초 + 05시간 00분 00초 = 35시간 00분 00초 입니다.
초록색으로 표시된 구간(69:59:59-94:59:59)에 광고를 삽입해도 동일한 결과를 얻을 수 있으나, 01:00:00이 69:59:59 보다 빠른 시각이므로, "01:00:00"을 return 합니다.
입출력 예 #3
2021_kakao_cf_04.png

동영상 재생시간과 공익광고 재생시간이 같으므로, 삽입할 수 있는 위치는 맨 처음(00:00:00)이 유일합니다.

동영상 재생시간 = 재생이 종료된 시각 - 재생이 시작된 시각(예를 들어, 00시 00분 01초부터 00시 00분 10초까지 동영상이 재생되었다면, 동영상 재생시간은 9초 입니다.
 */



import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Kakao5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String play_time = "99:59:59";
		String adv_time = "25:00:00";
		String[] logs = {"69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"};
		System.out.println(solution(play_time, adv_time, logs));
	}

	public static String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        
        LocalDateTime playTime = LocalDateTime.parse(play_time);
        LocalDateTime advTime = LocalDateTime.parse(adv_time);
        
        LocalDateTime[][] logArray = new LocalDateTime[logs.length][2];
        for(int i=0; i<logs.length; i++) {
        	String[] split = logs[i].split("-");
        	logArray[i][0] = LocalDateTime.parse(split[0]);
        	logArray[i][1] = LocalDateTime.parse(split[1]);		// 시청자들의 시작 시간 ~ 끝 시간이 저장되어있는 logArray
        }
        
        LocalDateTime longestTime = LocalDateTime.parse("00:00:00");
        LocalDateTime answerTime = LocalDateTime.parse("00:00:00");
        
        for(int i=0; i<logArray.length; i++) {
        	LocalDateTime advStart = logArray[i][0];
        	LocalDateTime advEnd = advStart;
        	advEnd = advEnd.plusHours(advTime.getHour());
        	advEnd = advEnd.plusMinutes(advTime.getMinute());
        	advEnd = advEnd.plusSeconds(advTime.getSecond());
        	//System.out.println(advStart + " ~ " + advEnd);
        	if(advEnd.isAfter(playTime)) continue;			// 총 재생시간보다 광고시간이 길어지면 X
        	
        	LocalDateTime allTime = LocalDateTime.parse("00:00:00");
        	
        	for(int j=0; j<logArray.length; j++) {
        		LocalDateTime start = logArray[j][0];
        		LocalDateTime end = logArray[j][1];
        		
        		if( ( advStart.isAfter(start) || advStart.equals(start) ) && ( advEnd.isBefore(end) || advEnd.equals(end) ) ) {
        			// 광고가 시청시간 안에 있는 경우
        			Duration duration = Duration.between(advStart, advEnd);
        			allTime = allTime.plusSeconds(duration.getSeconds());
        		}
        		else if( ( advStart.isBefore(start) || advStart.equals(start) ) && ( advEnd.isAfter(start) || advEnd.equals(start) ) && ( advEnd.isBefore(end) || advEnd.equals(end) ) ) {
        			// 광고 시작이 시청시간 전인 경우
        			Duration duration = Duration.between(start, advEnd);
        			allTime = allTime.plusSeconds(duration.getSeconds());
        		}
        		else if( ( advEnd.isAfter(end) || advEnd.equals(end) ) && ( advStart.isBefore(end) || advStart.equals(end) ) && ( advStart.isAfter(start) || advStart.equals(start) ) ) {
        			// 광고 시작이 시청마감시간 전인 경우
        			Duration duration = Duration.between(advStart, end);
        			allTime = allTime.plusSeconds(duration.getSeconds());
        		}
        		else if( ( advStart.isBefore(start) || advStart.equals(start) )&& ( advEnd.isAfter(end) || advEnd.equals(end) )) {
        			Duration duration = Duration.between(start, end);
        			allTime = allTime.plusSeconds(duration.getSeconds());
        		}
        	}
        	
        	if(allTime.isAfter(longestTime)) {
        		longestTime = allTime;
        		answerTime = advStart;
        	}
        	else if(allTime.equals(longestTime) && answerTime.isAfter(advStart)) {
        		answerTime = advStart;
        	}
        }
        
        answer = answerTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        
        return answer;
    }
}
