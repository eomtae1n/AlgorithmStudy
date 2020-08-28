/* 2020-08-28
https://programmers.co.kr/learn/courses/30/lessons/17680    <---------------  링크추가
 <[2018 카카오블라인드 1차] - 캐시> - 시뮬레이션, 큐, 리스트
 
 Test Case 1
 	- input : 	cacheSize = 3
 				cities = [Jeju, Pangyo, Seoul, NewYork, LA, Jeju, Pangyo, Seoul, NewYork, LA]
 	- return : 50
 	
 Test Case 2
 	- input : 	cacheSize = 3
 				cities = [Jeju, Pangyo, Seoul, Jeju, Pangyo, Seoul, Jeju, Pangyo, Seoul]
 	- return : 21
 	
 Test Case 3
 	- input : 	cacheSize = 2
 				cities = [Jeju, Pangyo, Seoul, NewYork, LA, SanFrancisco, Seoul, Rome, Paris, Jeju, NewYork, Rome]
 	- return : 60
 	
 Test Case 4
 	- input : 	cacheSize = 5
 				cities = [Jeju, Pangyo, Seoul, NewYork, LA, SanFrancisco, Seoul, Rome, Paris, Jeju, NewYork, Rome]
 	- return : 52
 	
 Test Case 5
 	- input : 	cacheSize = 2
 				cities = [Jeju, Pangyo, NewYork, newyork]
 	- return : 16
 	
 Test Case 6
 	- input : 	cacheSize = 0
 				cities = [Jeju, Pangyo, Seoul, NewYork, LA]
 	- return : 25
 */

import java.util.ArrayList;

public class Cache {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cacheSize = 2;
		String[] cities = {"Jeju", "Pangyo", "NewYork", "newyork"};
		
		System.out.println(solution(cacheSize, cities));
	}

	public static int solution(int cacheSize, String[] cities) {
		if(cacheSize == 0) return 5 * cities.length;
		
		int answer = 0;
		ArrayList<String> cache = new ArrayList<>();
		
		for(String c : cities) {
			String city = c.toLowerCase();
			
			if(cache.contains(city)) {
				cache.remove(city);
				cache.add(city);
				answer += 1;
			}
			else {
				answer += 5;
				if(cache.size() == cacheSize) {
					cache.remove(0);
					cache.add(city);
				}
				else
					cache.add(city);
			}
		}
		
		return answer;
	}
	
}
