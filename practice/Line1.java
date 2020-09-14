package test2;
import java.util.HashMap;
import java.util.Map;

public class Line1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] boxes = {{1, 2}, 
		                 {2, 1}, 
		                 {3, 3}, 
		                 {4, 5}, 
		                 {5, 6}, 
		                 {7, 8}};
		System.out.println(solution(boxes));
	}

	public static int solution(int[][] boxes) {
        int answer = -1;
        
        Map<Integer, Integer> hm = new HashMap<>();
        
        for(int i=0; i<boxes.length; i++) {
        	for(int j=0; j<2; j++) {
        		if(hm.containsKey(boxes[i][j])) {
        			hm.put(boxes[i][j], hm.get(boxes[i][j]) + 1);
        		}
        		else hm.put(boxes[i][j], 1);
        	}
        }
        
        int pair = 0;
        for(int key : hm.keySet()) {
        	int value = hm.get(key);
        	
        	pair += value/2;
        }
        
        answer = boxes.length - pair;
        
        return answer;
    }
}
