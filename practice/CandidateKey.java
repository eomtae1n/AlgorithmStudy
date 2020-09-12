/* 2020-09-11
https://programmers.co.kr/learn/courses/30/lessons/42890    <---------------  링크추가
 <[2019 카카오블라인드 1차] - 후보키> - 순열, 조합, 문자열
 
 Test Case 1
 	- input : 	relation = {
								{"100","ryan","music","2"},
								{"200","apeach","math","2"},
								{"300","tube","computer","3"},
								{"400","con","computer","4"},
								{"500","muzi","music","3"},
								{"600","apeach","music","2"}
							}
 	- return : 2
 	
 	
 	------- 테스트 케이스는 통과. 하지만 10점...------
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CandidateKey {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] relation = {
								{"100","ryan","music","2"},
								{"200","apeach","math","2"},
								{"300","tube","computer","3"},
								{"400","con","computer","4"},
								{"500","muzi","music","3"},
								{"600","apeach","music","2"}
							};
		System.out.println(solution(relation));
	}
	
	static int answer = 0;
	static Set<HashSet<Integer>> keySet = new HashSet<>();
	
	public static int solution(String[][] relation) {
        int n = relation[0].length;
        
        HashSet<Integer> picked = new HashSet<Integer>();
        boolean[] check = new boolean[n+1];

        pick(n, picked, check, relation);
        
        System.out.println(keySet);
        
        return keySet.size();
    }
	
	 public static void pick(int n, HashSet<Integer> picked, boolean[] check, String[][] relation) {
	        if(picked.size() == n) {
	            return;
	        }
	        
	        if(picked.size() > 0 && !keySet.contains(picked)) {
	        	Set<String> set = new HashSet<>();
	        
	        	for(int t = 0; t < relation.length; t++) {
	        		String key = "";
	        	
	        		for(int p : picked) {
	        			key += relation[t][p-1];
	        		}
	        	
	        		if(set.contains(key)) break;
	        	
	        		set.add(key);
	        	}
	        	
	        	if(set.size() == relation.length) {
	        		ArrayList<String> list = new ArrayList<>(set);
	        		System.out.println(list.get(0) + " " + picked);
	        		answer++;
	        		HashSet<Integer> tmp = new HashSet<>();
	        		for(int i : picked) tmp.add(i);
	        		keySet.add(tmp);
	        		for(HashSet<Integer> hs : keySet) {
	        			if(hs.equals(tmp))
	        				continue;
	        			
		        		int count = 0;
		        		for(int i : hs) {
		        			if(picked.contains(i)) count++;
		        		}
		        		if(count == hs.size()) {
		        			System.out.println(tmp);
		        			keySet.remove(tmp);
		        			break;
		        		}
		        	}
	        		return;
	        	}
	        }
	        
	        for(int i = 1; i <= n; i++) {	
	            if(check[i])
	                continue;
	            check[i] = true;
	            picked.add(i);
	            pick(n, picked, check, relation);
	            picked.remove(picked.size()-1);
	            check[i] = false;
	        }
	  }

}
