/* 2020-08-24
https://www.acmicpc.net/problem/1389    <---------------  링크추가
 <백준 1389번 - 케빈 베이컨의 6단계 법칙> - BFS
 
 Test Case 1
 	- input : 	5 5 <---------- 유저의 수와 친구 관계의 수 입력
 				1 3 <---------- 친구 관계의 수만큼 입력 1, 3은 친구
 				1 4
 				4 5
 				4 3
 				3 2
 	- return : 3
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class KevinBacon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 0, M = 0;
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();		// 유저의 수
		M = scan.nextInt();		// 친구 관계의 수
		
		HashMap<Integer, Set<Integer>> friends = new HashMap<>();	// 친구 관계
		
		for(int i=0; i<M; i++) {		// 친구관계를 hashmap으로 정의 key는 유저네임, value는 유저와 친구인 유저들의 set
			int f1 = scan.nextInt();
			int f2 = scan.nextInt();
			
			if(!friends.keySet().contains(f1)) {		// f1에 대해서 친구 추가
				Set<Integer> hs = new HashSet<>();
				hs.add(f2);
				friends.put(f1, hs);
			}
			else
				friends.get(f1).add(f2);
			
			if(!friends.keySet().contains(f2)) {		// f2에 대해서도 친구 추가
				Set<Integer> hs = new HashSet<>();
				hs.add(f1);
				friends.put(f2, hs);
			}
			else
				friends.get(f2).add(f1);
		}
		
		int kb = N*N;		// 케빈 베이컨의 수 최대치로 설정
		int answer = 0;		// 케빈 베이컨의 수가 가장 적은 유저(출력할 답)
		
		for(int i=1; i<N+1; i++) {
			int cnt = 0;		// 몇번 건너 친구인지 확인하는 변수 cnt
			int kbkb = 0;		// 유저 i의 케빈 베이컨 수
			Queue<Integer> q = new LinkedList<>();	// bfs를 위한 queue
			boolean[] check = new boolean[N+1];		// 이미 탐색한 유저인지 확인하는 check배열
			//System.out.println("username : " + i);
			
			q.add(i);			// 탐색할 유저 큐에 삽입
			check[i] = true;
			
			while(!q.isEmpty()) {	// 큐가 빌때까지
				//System.out.println(q);
				int size = q.size();
				for(int j=0; j<size; j++) {		// 큐 안에 들어있는 모든 유저의 친구 탐색
					int user = q.poll();
					
					for(int friend : friends.get(user))
						if(!check[friend]) {	// 유저와 친구이고 탐색하지 않은 유저이면 큐에 삽입
							q.add(friend);
							check[friend] = true;
						}
				}
				cnt++;
				kbkb += cnt * q.size();		// 케빈 베이컨 수 증가, 단 친구를 건널수록 cnt가 증가
			}
			if(kbkb < kb) {		// 더 적은 케빈 베이컨 수를 찾으면 답 갱신
				kb = kbkb;
				answer = i;
			}
		}
		
		System.out.println(answer);
	}

}
