import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class HotelRoom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long k = 10;
		long[] room_number = {1,3,4,1,3,1};
		
		//System.out.println(solution(k, room_number));
		long[] answer = solution(k, room_number);
		for(long l : answer) System.out.println(l);
	}

	public static long[] solution(long k, long[] room_number) {
		HashMap<Long, Long> hm = new HashMap<>();
        HashSet<Long> hs = new HashSet<>();
        ArrayList<Long> al = new ArrayList<>();
        
        for(long l : room_number) {
        	if(hm.containsValue(l)) {		// 방이 비어있는 경우
        		
        	}
        	else {						// 이미 방이 찬 경우
        		
        	}
        }
        
        long[] answer = new long[room_number.length];
        
        return answer;
    }
	
}
