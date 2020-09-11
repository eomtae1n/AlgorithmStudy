/* 2020-09-11
https://programmers.co.kr/learn/courses/30/lessons/42888    <---------------  링크추가
 <[2019 카카오블라인드 1차] - 오픈 채팅방> - 해쉬 맵, 문자열
 
 Test Case 1
 	- input : 	record = 	["Enter uid1234 Muzi",
 	 						"Enter uid4567 Prodo",
 	 						"Leave uid1234",
 	 						"Enter uid1234 Prodo",
 	 						"Change uid4567 Ryan"]
 	- return : ["Prodo님이 들어왔습니다.", 
 				"Ryan님이 들어왔습니다.", 
 				"Prodo님이 나갔습니다.", 
 				"Prodo님이 들어왔습니다."]
 */

import java.util.HashMap;

public class OpenChats {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] record = {"Enter uid1234 Muzi", 
		                   "Enter uid4567 Prodo",
		                   "Leave uid1234",
		                   "Enter uid1234 Prodo",
		                   "Change uid4567 Ryan"};
		
		String[] answer = solution(record);
		
		for(String s : answer) System.out.println(s);
	}

	public static String[] solution(String[] record) {
        HashMap<String, String> hm = new HashMap<>();
        int change=0;
        
        // uid와 username을 map에 저장
        for(String str : record) {
        	String[] st = str.split(" ");
        	//Enter
        	if(st[0].equals("Enter")) {
        		hm.put(st[1], st[2]);
        	}
        	//Change
        	else if(st[0].equals("Change")) {
        		hm.put(st[1], st[2]);
        		change++;
        	}
        	//Leave
        }
        
        String[] answer = new String[record.length - change];	// 이름 변경은 기록되지 않기에 크기에서 뺌
        int size=0;
        
        for(String str : record) {
        	String[] st = str.split(" ");
        	//Enter
        	if(st[0].equals("Enter")) {
        		answer[size++] = hm.get(st[1]) + "님이 들어왔습니다.";
        	}
        	//Change
        	//Leave
        	else if(st[0].equals("Leave")) {
        		answer[size++] = hm.get(st[1]) + "님이 나갔습니다.";
        	}
        }
        
        return answer;
    }
}
