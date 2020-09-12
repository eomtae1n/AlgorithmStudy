/*
 * 레스토랑을 운영하던 스카피는 코로나19로 인한 불경기를 극복하고자 메뉴를 새로 구성하려고 고민하고 있습니다.
기존에는 단품으로만 제공하던 메뉴를 조합해서 코스요리 형태로 재구성해서 새로운 메뉴를 제공하기로 결정했습니다. 어떤 단품메뉴들을 조합해서 코스요리 메뉴로 구성하면 좋을 지 고민하던 스카피는 이전에 각 손님들이 주문할 때 가장 많이 함께 주문한 단품메뉴들을 코스요리 메뉴로 구성하기로 했습니다.
단, 코스요리 메뉴는 최소 2가지 이상의 단품메뉴로 구성하려고 합니다. 또한, 최소 2명 이상의 손님으로부터 주문된 단품메뉴 조합에 대해서만 코스요리 메뉴 후보에 포함하기로 했습니다.

예를 들어, 손님 6명이 주문한 단품메뉴들의 조합이 다음과 같다면,
(각 손님은 단품메뉴를 2개 이상 주문해야 하며, 각 단품메뉴는 A ~ Z의 알파벳 대문자로 표기합니다.)

손님 번호	주문한 단품메뉴 조합
1번 손님	A, B, C, F, G
2번 손님	A, C
3번 손님	C, D, E
4번 손님	A, C, D, E
5번 손님	B, C, F, G
6번 손님	A, C, D, E, H
가장 많이 함께 주문된 단품메뉴 조합에 따라 스카피가 만들게 될 코스요리 메뉴 구성 후보는 다음과 같습니다.

코스 종류	메뉴 구성	설명
요리 2개 코스	A, C	1번, 2번, 4번, 6번 손님으로부터 총 4번 주문됐습니다.
요리 3개 코스	C, D, E	3번, 4번, 6번 손님으로부터 총 3번 주문됐습니다.
요리 4개 코스	B, C, F, G	1번, 5번 손님으로부터 총 2번 주문됐습니다.
요리 4개 코스	A, C, D, E	4번, 6번 손님으로부터 총 2번 주문됐습니다.
[문제]
각 손님들이 주문한 단품메뉴들이 문자열 형식으로 담긴 배열 orders, 스카피가 추가하고 싶어하는 코스요리를 구성하는 단품메뉴들의 갯수가 담긴 배열 course가 매개변수로 주어질 때, 스카피가 새로 추가하게 될 코스요리의 메뉴 구성을 문자열 형태로 배열에 담아 return 하도록 solution 함수를 완성해 주세요.

[제한사항]
orders 배열의 크기는 2 이상 20 이하입니다.
orders 배열의 각 원소는 크기가 2 이상 10 이하인 문자열입니다.
각 문자열은 알파벳 대문자로만 이루어져 있습니다.
각 문자열에는 같은 알파벳이 중복해서 들어있지 않습니다.
course 배열의 크기는 1 이상 10 이하입니다.
course 배열의 각 원소는 2 이상 10 이하인 자연수가 오름차순으로 정렬되어 있습니다.
course 배열에는 같은 값이 중복해서 들어있지 않습니다.
정답은 각 코스요리 메뉴의 구성을 문자열 형식으로 배열에 담아 사전 순으로 오름차순 정렬해서 return 해주세요.
배열의 각 원소에 저장된 문자열 또한 알파벳 오름차순으로 정렬되어야 합니다.
만약 가장 많이 함께 주문된 메뉴 구성이 여러 개라면, 모두 배열에 담아 return 하면 됩니다.
orders와 course 매개변수는 return 하는 배열의 길이가 1 이상이 되도록 주어집니다.
[입출력 예]
orders	course	result
["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"]	[2,3,4]	["AC", "ACDE", "BCFG", "CDE"]
["ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"]	[2,3,5]	["ACD", "AD", "ADE", "CD", "XYZ"]
["XYZ", "XWY", "WXA"]	[2,3,4]	["WX", "XY"]
입출력 예에 대한 설명
입출력 예 #1
문제의 예시와 같습니다.

입출력 예 #2
AD가 세 번, CD가 세 번, ACD가 두 번, ADE가 두 번, XYZ 가 두 번 주문됐습니다.
요리 5개를 주문한 손님이 1명 있지만, 최소 2명 이상의 손님에게서 주문된 구성만 코스요리 후보에 들어가므로, 요리 5개로 구성된 코스요리는 새로 추가하지 않습니다.

입출력 예 #3
WX가 두 번, XY가 두 번 주문됐습니다.
3명의 손님 모두 단품메뉴를 3개씩 주문했지만, 최소 2명 이상의 손님에게서 주문된 구성만 코스요리 후보에 들어가므로, 요리 3개로 구성된 코스요리는 새로 추가하지 않습니다.
또, 단품메뉴를 4개 이상 주문한 손님은 없으므로, 요리 4개로 구성된 코스요리 또한 새로 추가하지 않습니다.

 */



import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Kakao2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] orders = {"XYZ", "XWY", "WXA"};
		int[] course = {2,3,5};
		
		String[] answer = solution(orders, course);
		
		for(String s : answer) 
			System.out.println(s);
	}

	static HashMap<Set<Character>, Integer> hm = new HashMap<>();
	
	public static String[] solution(String[] orders, int[] course) {
        String[] answer;
        
        for(String order : orders) {
        	int n = order.length();
        	
        	int[] arr = new int[n];
        	for(int i=0; i<n; i++) arr[i] = i+1;
        	
        	boolean[] visited = new boolean[n];
        	
        	for(int i=2; i<=n; i++) {
        		System.out.println("\n" + n + " 개 중에서 " + i + " 개 뽑기" + order);
                combination(arr, visited, 0, n, i, order);
        	}
        }
        
        ArrayList<Set<Character>> answerList = new ArrayList<>();
        
        for(int courseNum : course) {
        	ArrayList<Set<Character>> al = new ArrayList<>();		// 코스 갯수만큼 조합을 담은 임시 리스트
        	
        	for(Set<Character> set : hm.keySet()) {
        		if(set.size() == courseNum)
        			al.add(set);
        	}
        	
        	int value = 0;
        	for(Set<Character> set : al) {							// 코스들 중 원하는 사람이 가장 많은 사람 수 value에 저장
        		if(value < hm.get(set))
        			value = hm.get(set);
        	}
        	
        	// 최소 2명 이상의 손님
        	if(value > 1) {
	        	for(Set<Character> set : al) {						// 원하는 사람이 가장 많은 조합을 answerList에 저장
	        		if(value == hm.get(set))
	        			answerList.add(set);
	        	}
        	}
        }
        
        System.out.println(answerList);
        ArrayList<String> sortArray = new ArrayList<>();
        
        for(Set<Character> set : answerList) {
        	String str = "";
        	for(char c : set) {
        		str += Character.toString(c);
        	}
        	sortArray.add(str);
        }
        
        Collections.sort(sortArray);
        //System.out.println(sortArray);
        
        answer = new String[answerList.size()];
        int idx = 0;
        
        for(String s : sortArray)
        	answer[idx++] = s;
        
        return answer;
    }
	
	public static void combination(int[] arr, boolean[] visited, int start, int n, int r, String order) {
	    if(r == 0) {
	        add(arr, visited, n, order);
	        return;
	    } 

	    for(int i=start; i<n; i++) {
	        visited[i] = true;
	        combination(arr, visited, i + 1, n, r - 1, order);
	        visited[i] = false;
	    }
	}
	// Set 추가
    public static void add(int[] arr, boolean[] visited, int n, String order) {
        Set<Character> hs = new HashSet<>();
    	for (int i = 0; i < n; i++) {
            if (visited[i]) {
                System.out.print(arr[i] + " ");
                hs.add(order.charAt(arr[i] - 1));
            }
        }
        System.out.println(hs);
        
    	// 최소 2가지 이상의 단품메뉴
    	if(hs.size() > 1) {
	        boolean isExist = false;
	        for(Set<Character> set : hm.keySet()) {
	        	if(hs.equals(set)) {
	        		isExist = true;
	        		hm.put(set, hm.get(set) + 1);		// 같은 조합을 원하는 손님 1명 추가
	        	}
	        }
	        
	        if(!isExist) {			// 이 조합을 원하는 첫 손님이면
	        	hm.put(hs, 1);
	        }
    	}
    }
}
