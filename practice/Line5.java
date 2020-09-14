package test2;

import java.util.ArrayList;

public class Line5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] cards = {3,3,5,7,9,1};
		
		System.out.println(solution(cards));
	}

	public static int solution(int[] cards) {
        int answer = 0;
        
        ArrayList<Integer> player = new ArrayList<>();
        ArrayList<Integer> dealer = new ArrayList<>();
        
        for(int i=0; i<cards.length;) {
//          1. 딜러가 카드를 한 장 뽑아 플레이어에게 준다.
        	if(i == cards.length) return answer;
        	int p = cards[i++];
        	if(p >= 10) player.add(10);
        	else player.add(p);
//          2. 딜러가 카드를 한 장 뽑아 딜러 앞에 뒤집어 놓는다.
        	if(i == cards.length) return answer;
        	int d = cards[i++];
        	if(d >= 10) dealer.add(10);
        	else dealer.add(d);
//          3. 딜러가 카드를 한 장 뽑아 플레이어에게 준다.
        	if(i == cards.length) return answer;
        	p = cards[i++];
        	if(p >= 10) player.add(10);
        	else player.add(p);
//          4. 딜러가 카드를 한 장 뽑아 딜러 앞에 보이도록 놓는다.
        	if(i == cards.length) return answer;
        	d = cards[i++];
        	if(d >= 10) dealer.add(10);
        	else dealer.add(d);
//          5. 플레이어에게 카드를 더 받을지 말지 물어본다.
        	int psum = 0;
        	int dsum = 0;
        	// 플레이어가 1을 들고 있다면
        	if(player.contains(1)) {
        		for(int num : player) {
        			if(num == 1) psum += 11;
        			else psum += num;
        		}
        		for(int num : dealer) {
        			if(num == 1) dsum += 11;
        			else dsum += num;
        		}
//              5.1 플레이어가 최초로 받은 카드 두 장의 합이 21인 경우에는 더 이상 카드를 받지 않고, 딜러의 카드를 확인하여 승패를 결정한다.
        		if(psum == 21) {
        			if(dsum == 21) continue;
        			else {
        				// 게임 끝!!!!!!!!!!!!!!
        				System.out.println("player : " + psum + ", dealer : " + dsum);
        				player.removeAll(player);
        				dealer.removeAll(dealer);
        				answer += 3;
        				continue;
        			}
        		}
//              5.2 플레이어가 받은 모든 카드의 합이 21보다 작으면 계속해서 한 장씩 더 받을 수 있다.
        		else if(psum < 21) {
//                	필승법 1. 딜러의 보이는 카드가 1이거나 7 이상인 경우, 플레이어는 카드 합이 17 이상이 될 때까지 받는다.
                	if(d == 1 || d >= 7) {
                		while(psum < 17) {
                			if(i == cards.length) return answer;
                			p = cards[i++];
                        	if(p >= 10) psum += 10;
                        	else psum += p;
                		}
//                      5.3 플레이어가 받은 모든 카드의 합이 21을 넘어가면 플레이어가 즉시 게임에서 진다.
                		if(psum > 21) {
                			// 게임 끝!!!!!!!!!!!!!!
                			System.out.println("player : " + psum + ", dealer : " + dsum);
            				player.removeAll(player);
            				dealer.removeAll(dealer);
            				answer -= 2;
            				continue;
                		}
                	}
//                	필승법 2. 딜러의 보이는 카드가 4, 5, 6인 경우, 플레이어는 카드를 받지 않는다.
                	else if(d == 4 || d == 5 || d == 6) {

                	}
//                	필승법 3. 딜러의 보이는 카드가 2, 3인 경우, 플레이어는 카드 합이 12 이상이 될 때까지 받는다.
                	else if(d == 2 || d == 3) {
                		while(psum < 12) {
                			if(i == cards.length) return answer;
                			p = cards[i++];
                        	if(p >= 10) psum += 10;
                        	else psum += p;
                		}
                	}
        		}
        	}
        	
        	// 플레이어가 1을 들고 있지 않다면
        	if(!player.contains(1)) {
        		for(int num : player) psum += num;
        		for(int num : dealer) {
        			if(num == 1) dsum += 11;
        			else dsum += num;
        		}
        		
//              5.2 플레이어가 받은 모든 카드의 합이 21보다 작으면 계속해서 한 장씩 더 받을 수 있다.
//            	필승법 1. 딜러의 보이는 카드가 1이거나 7 이상인 경우, 플레이어는 카드 합이 17 이상이 될 때까지 받는다.
            	if(d == 1 || d >= 7) {
            		while(psum < 17) {
            			if(i == cards.length) return answer;
            			p = cards[i++];
                    	if(p >= 10) psum += 10;
                    	// 받은 카드가 1이면
                    	else if(p == 1) {
                    		if(psum <= 10) psum += 11;
                    		else psum += 1;
                    	}
                    	else psum += p;
            		}
            	}
//            	필승법 2. 딜러의 보이는 카드가 4, 5, 6인 경우, 플레이어는 카드를 받지 않는다.
            	else if(d == 4 || d == 5 || d == 6) {
//                  
            	}
//            	필승법 3. 딜러의 보이는 카드가 2, 3인 경우, 플레이어는 카드 합이 12 이상이 될 때까지 받는다.
            	else if(d == 2 || d == 3) {
            		while(psum < 12) {
            			if(i == cards.length) return answer;
            			p = cards[i++];
                    	if(p >= 10) psum += 10;
                    	else if(p == 1) {
                    		if(psum <= 10) psum += 11;
                    		else psum += 1;
                    	}
                    	else psum += p;
            		}
            	}
        	}
//          5.3 플레이어가 받은 모든 카드의 합이 21을 넘어가면 플레이어가 즉시 게임에서 진다.
        	if(psum > 21) {
    			// 게임 끝!!!!!!!!!!!!!!
        		System.out.println("player : " + psum + ", dealer : " + dsum);
				player.removeAll(player);
				dealer.removeAll(dealer);
				answer -= 2;
				continue;
    		}
//          6. 플레이어가 더이상 카드를 받지 않으면 딜러 앞의 뒤집어놓은 카드를 공개한 후, 딜러의 카드 합이 17 이상이 될 때까지 계속해서 딜러가 카드를 한 장씩 받는다.
    		while(dsum < 17) {
    			if(i == cards.length) return answer;
    			d = cards[i++];
    			if(d >= 10) dsum += 10;
    			else if(d == 1) {
    				if(dsum <= 10) dsum += 11;
    				else dsum += 1;
    			}
    			else dsum += d;
    		}
//          6.1 딜러가 받은 모든 카드의 합이 21을 넘으면 딜러가 즉시 게임에서 진다.
//          6.2 이때 딜러는 플레이어가 가진 카드의 합을 고려하지 않으며, 딜러가 가진 카드의 합이 17 이상이 되면 받기를 중단한다.
    		if(dsum > 21) {
    			// 게임 끝!!!!!!!!!!!!!!
    			System.out.println("player : " + psum + ", dealer : " + dsum);
				player.removeAll(player);
				dealer.removeAll(dealer);
				answer += 2;
				continue;
    		}
    		else if(dsum == 21) {
    			if(psum == 21) {
    				// 게임 끝!!!!!!!!!!!!!!
    				System.out.println("player : " + psum + ", dealer : " + dsum);
    				player.removeAll(player);
    				dealer.removeAll(dealer);
    				continue;
    			}
    			else {
	    			// 게임 끝!!!!!!!!!!!!!!
    				System.out.println("player : " + psum + ", dealer : " + dsum);
					player.removeAll(player);
					dealer.removeAll(dealer);
					answer -= 2;
					continue;
    			}
    		}
    		else {
//              7. 승패를 가린다. 카드 합이 21에 더 가까운 사람이 이기며, 카드 합이 서로 같으면 비긴다.
    			if(psum > dsum) {
    				// 게임 끝!!!!!!!!!!!!!!
    				System.out.println("player : " + psum + ", dealer : " + dsum);
    				player.removeAll(player);
    				dealer.removeAll(dealer);
    				answer += 2;
    				continue;
    			}
    			else if(psum == dsum) {
    				// 게임 끝!!!!!!!!!!!!!!
    				System.out.println("player : " + psum + ", dealer : " + dsum);
    				player.removeAll(player);
    				dealer.removeAll(dealer);
    				continue;
    			}
    			else {
    				// 게임 끝!!!!!!!!!!!!!!
    				System.out.println("player : " + psum + ", dealer : " + dsum);
    				player.removeAll(player);
    				dealer.removeAll(dealer);
    				answer -= 2;
    				continue;
    			}
    		}
        }
        
        return answer;
    }
}
