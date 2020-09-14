package test2;

import java.util.HashMap;

public class Line6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] companies = {"A fabdec 2", "B cebdfa 2", "C ecfadb 2"};
		String[] applicants = {"a BAC 1", "b BAC 3", "c BCA 2", "d ABC 3", "e BCA 3", "f ABC 2"};
		
		String[] answer = solution(companies, applicants);
		for(String s : answer) System.out.println(s);
	}

	public static String[] solution(String[] companies, String[] applicants) {
        String[] answer = {};
        
        String[][] company = new String[companies.length][3];
        String[][] appli = new String[applicants.length][3];
        
        for(int i=0; i<companies.length; i++) {
        	String[] split = companies[i].split(" ");
        	company[i][0] = split[0];
        	company[i][1] = split[1];
        	company[i][2] = split[2];
        }
        for(int i=0; i<applicants.length; i++) {
        	String[] split = applicants[i].split(" ");
        	appli[i][0] = split[0];
        	appli[i][1] = split[1];
        	appli[i][2] = split[2];
        }
        	
//        1단계. 지원자는 거절당하지 않았던 기업 중에서 자신의 선호도가 가장 높은 기업 한 곳에 지원합니다. 입사 희망 기업으로부터 모두 거절당하면 지원을 중단합니다.
        
//        2단계. 기업은 채용 인원수를 넘지 않는 한도 내에서 선호도가 높은 순서대로 지원자를 잠정 선택합니다. 선택하지 않은 지원자들은 거절합니다.

//        3단계. 거절당한 지원자들 중에서 다른 기업에 지원할 지원자가 있다면 1단계부터 반복하고, 없다면 현재의 잠정 선택을 최종 매칭으로 결정합니다.
        
        
        
        return answer;
    }
}
