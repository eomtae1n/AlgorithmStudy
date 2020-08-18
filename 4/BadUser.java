/* 2020-08-18
https://programmers.co.kr/learn/courses/30/lessons/64064    <---------------  링크추가
 <[카카오 인턴] 불량 사용자> - 중복제거(해시), 문자열, 완전탐색(순열)
 
 Test Case 1
 	- input : user_id =  ["frodo", "fradi", "crodo", "abc123", "frodoc"]
 			  banned_id = ["fr*d*", "abc1**"]
 	- return : 2
 	
 Test Case 2
 	- input : user_id =  ["frodo", "fradi", "crodo", "abc123", "frodoc"]
 			  banned_id = ["*rodo", "*rodo", "******"]
 	- return : 2
 	
 Test Case 3
 	- input : user_id =  ["frodo", "fradi", "crodo", "abc123", "frodoc"]
 			  banned_id = ["fr*d*", "*rodo", "******", "******"]
 	- return : 3
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BadUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] banned_id = {"fr*d*", "abc1**"};
		
		System.out.println(solution(user_id, banned_id));
	}

	public static int solution(String[] user_id, String[] banned_id) {
        ArrayList<Integer> picked = new ArrayList<Integer>();
        int n = user_id.length;
        boolean[] check = new boolean[n+1];

        pick(n, picked, check, user_id, banned_id);
        
        int answer = answerList.size();
        
        return answer;
    }
	
	static ArrayList<Set<String>> answerList = new ArrayList<>();
	
	public static void pick(int n, ArrayList<Integer> picked, boolean[] check, String[] user_id, String[] banned_id) {
        if(picked.size() == n) {
        	Set<String> badUserSet = new HashSet<>();
            
            String[] tmp = new String[n];
            for(int i=0; i<n; i++) {
            	tmp[i] = user_id[picked.get(i)-1];		// 정렬된 순서로 user_id 아이템들을 tmp에 저장
            }
            for(String banned : banned_id) {
            	for(String user : tmp) {
            		if(banned.length() != user.length() || badUserSet.contains(user))
            			continue;							// 길이가 다르거나 이미 불량사용자에 추가했으면 비교 x
            		
            		String[] b = banned.split("");
            		String[] u = user.split("");
            		
            		int cnt = 0;		// 같은 문자 수를 카운트하는 cnt
            		for(int i=0; i<banned.length(); i++) {
            			if(b[i].equals("*") || b[i].equals(u[i]))
            				cnt++;
            		}
            		
            		if(cnt == banned.length()) { // 사용자가 불량사용자이면
            			badUserSet.add(user);
            			break;
            		}
            	}
            }
            if(!answerList.contains(badUserSet) && badUserSet.size() == banned_id.length) answerList.add(badUserSet);	// 답 리스트에 같은 Set이 없으면 추가
            
            return;
        }
        for(int i = 1; i <= n; i++) {	
            if(check[i])
                continue;
            check[i] = true;
            picked.add(i);
            pick(n, picked, check, user_id, banned_id);
            picked.remove(picked.size()-1);
            check[i] = false;
        }
    }
    public static void printAnswer(ArrayList<Integer> picked) {
        for(int i = 0; i < picked.size(); i ++) {
            System.out.print(picked.get(i) + " ");
        }
        System.out.println();
    }
	
}
