/* 2020-08-15
https://programmers.co.kr/learn/courses/30/lessons/42839
 <소수 찾기> - 완전탐색
 
 Test Case 1
 	- input : numbers = "17"
 	- return : 3
 
 Test Case 2
 	- input : numbers = "011"
 	- return : 2
 	
 	*** 순열 생성하는 함수 저장해놓고 알고리즘 외우기!! ***
 */

import java.util.ArrayList;
import java.util.HashSet;

public class FindPrimeNum { 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String numbers = "17";
		
		System.out.println(solution(numbers));
	}
	
	static HashSet<Integer> numSet = new HashSet<Integer>();	// 11, 011을 구분하기 위해 HashSet객체 사용
	static int answer = 0;

	public static int solution(String numbers) {
        int n = numbers.length();
    	ArrayList<Integer> picked = new ArrayList<Integer>();
        boolean[] check = new boolean[n+1];
        
        pick(n, picked, check, numbers);
        
        return answer;
    }
	
	public static void pick(int n, ArrayList<Integer> picked, boolean[] check, String numbers) {	// 순열 생성하는 함수
        if(picked.size() > 0 && picked.size() < n) {
        	String s = "";
            for(int i : picked) s += numbers.charAt(i-1);
            int p = Integer.parseInt(s);
            if(!numSet.contains(p)) {
            	numSet.add(p);
            	if(isPrime(p)) answer++;		// 소수면 답+1
            }
    	}
    	else if(picked.size() == n) {
            String s = "";
            for(int i : picked) s += numbers.charAt(i-1);
            int p = Integer.parseInt(s);
            if(!numSet.contains(p)) {
            	numSet.add(p);
            	if(isPrime(p)) answer++;		// 소수면 답+1
            }
            return;
        }
        for(int i = 1; i <= n; i++) {
            if(check[i])
                continue;
            check[i] = true;
            picked.add(i);
            pick(n, picked, check, numbers);
            picked.remove(picked.size()-1);
            check[i] = false;
        }
    }
	
	public static boolean isPrime(int p) {
    	if(p == 1 || p == 0) return false;			// 0, 1은 소수 X
    	int div = 0;
    	for(int i=2; i<p; i++) if(p % i == 0) div++;
    	if(div == 0) return true;			// 소수
    	else return false;					// 소수 X
    }
	
}
