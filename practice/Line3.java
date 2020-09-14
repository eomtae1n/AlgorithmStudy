package test2;

import java.util.HashMap;

public class Line3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 9;
		
		int[] answer = solution(n);
		
		System.out.println("최소횟수 : " + answer[0] + " 한 자릿수 : " + answer[1]);
	}

	static HashMap<Integer, Integer> hm = new HashMap<>();
	
	public static int[] solution(int n) {
        int[] answer = new int[2];
        
        find(n, 0, answer);						// 재귀함수
        
        int min = (int)(Math.log10(n)+1);		// 최소 횟수는 항상 자릿수보다 같거나 작다
        
        for(int key : hm.keySet())
        	if(key < min)
        		min = key;
        
        answer[0] = min;
        answer[1] = hm.get(min);
        
        return answer;
    }
	
	public static void find(int n, int count, int[] answer) {
		// 한 자릿수라면 종료
		if(n < 10) {
			hm.put(count, n);
			return;
		}
		int length = (int)(Math.log10(n)+1);	// 자릿수
		
		for(int i=1; i<length; i++) {
			// 첫자리가 0이면 안됨
			int num = n % (int)Math.pow(10, length-i);
			if(num < (int)Math.pow(10, length-i-1)) continue;
			
			int a = n / (int)Math.pow(10, length-i);
			int b = n % (int)Math.pow(10, length-i);
			
			find(a+b, count+1, answer);
		}
	}
}
