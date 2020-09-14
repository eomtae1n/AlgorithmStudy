package test2;

import java.util.ArrayList;
import java.util.LinkedList;

public class Line2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ball = {1, 2, 3, 4, 5, 6};
		int[] order = {6, 2, 5, 1, 4, 3};
		
		int[] answer = solution(ball, order);
		for(int i : answer) System.out.print(i + " ");
	}

	public static int[] solution(int[] ball, int[] order) {
        int[] answer = new int[order.length];
        int idx = 0;
        
        // 링크리스트로 추가
        LinkedList<Integer> list = new LinkedList<>();
        for(int b : ball) list.add(b);
        
        ArrayList<Integer> hold = new ArrayList<>();
        // 오더 순서대로
        for(int o : order) {
        	// 보류 상태인 공이 양쪽끝인지 먼저 확인
        	while(hold.contains(list.getFirst()) || hold.contains(list.getLast())) {
        		for(int i=0; i<hold.size(); i++) {
        			// 오더된 공이 양쪽 끝이면 지운다
                	if(list.getFirst() == hold.get(i)) {
                		answer[idx++] = list.getFirst();
                		list.removeFirst();
                		hold.remove(i);
                		break;
                	}
                	else if(list.getLast() == hold.get(i)) {
                		answer[idx++] = list.getLast();
                		list.removeLast();
                		hold.remove(i);
                		break;
                	}
        		}
        	}
        	// 오더된 공이 양쪽 끝이면 지운다
        	if(list.getFirst() == o) {
        		answer[idx++] = list.getFirst();
        		list.removeFirst();
        	}
        	else if(list.getLast() == o) {
        		answer[idx++] = list.getLast();
        		list.removeLast();
        	}
        	// 양쪽 끝에 없다면 보류 상태
        	else hold.add(o);
        }
        
        return answer;
    }
}
