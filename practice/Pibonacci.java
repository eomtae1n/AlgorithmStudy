/* 2020-09-27
 <피보나치 수> - dp
 
 Test Case 1
 	- input : 	1
 	- return : 1
 Test Case 2
 	- input : 	2
 	- return : 2
 Test Case 3
 	- input : 	3
 	- return : 3
 Test Case 4
 	- input : 	4
 	- return : 5
 */

public class Pibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 4;
		System.out.println(solution(N));
	}

	public static int solution(int N) {
        if(N == 1) return 1;
        else if(N == 2) return 2;
		
		int answer = 0;
        
        int[] pibonacci = new int[N];
        pibonacci[0] = 1;
        pibonacci[1] = 2;
        
        for(int i=2; i<N; i++) {
        	pibonacci[i] = pibonacci[i-2] + pibonacci[i-1];
        }
        
        answer = pibonacci[N-1];
        
        return answer;
    }
}
