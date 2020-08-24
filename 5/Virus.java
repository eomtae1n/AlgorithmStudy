/* 2020-08-24
https://www.acmicpc.net/problem/2606    <---------------  링크추가
 <백준 2606번 - 바이러스> - BFS
 
 Test Case 1
 	- input : 	7			<---- 컴퓨터 갯수
 				6			<---- 컴퓨터 쌍의 수
 				1 2			<---- 컴퓨터 쌍 1, 2가 연결됨
 				2 3
 				1 5
 				5 2
 				5 6
 				4 7
 				
 	- return : 4			<---- 1번 컴퓨터와 연결되어 바이러스걸리게 되는 컴퓨터 수
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Virus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int computers = 0;
		int connects = 0;
		Scanner scan = new Scanner(System.in);
		
		computers = scan.nextInt();									// 입력
		connects = scan.nextInt();
		HashMap<Integer, HashSet<Integer>> network = new HashMap<>();	// 컴퓨터들이 연결된 것을 나타내는 hashmap
																		// key는 컴퓨터의 번호, value는 연결된 컴퓨터들 set
		for(int i=0; i<connects; i++) {
			int c1 = scan.nextInt();
			int c2 = scan.nextInt();
			
			if(!network.keySet().contains(c1)) {
				HashSet<Integer> set = new HashSet<>();
				set.add(c2);
				network.put(c1, set);
			}
			else
				network.get(c1).add(c2);
			
			if(!network.keySet().contains(c2)) {
				HashSet<Integer> set = new HashSet<>();
				set.add(c1);
				network.put(c2, set);
			}
			else
				network.get(c2).add(c1);
		}															// 입력
		
		boolean[] virus = new boolean[computers+1];					// virus에 걸렸는지 나타내는 배열
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		virus[1] = true;
		int answer = 0;
		
		while(!q.isEmpty()) {					// BFS 탐색
			int size = q.size();
			for(int i=0; i<size; i++) {
				int com = q.poll();
				for(int next : network.get(com))
					if(!virus[next]) {
						q.add(next);
						virus[next] = true;
						answer++;				// 바이러스에 걸리면 answer+1
					}
			}
		}
		
		System.out.println(answer);
	}

}
