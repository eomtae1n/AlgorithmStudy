import java.time.LocalTime;

public class ShuttleBus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 1;
		int t = 1;
		int m = 5;
		String[] timetable = {"00:01", "00:01", "00:01", "00:01", "00:01"};
		
		System.out.println(solution(n, t, m, timetable));
	}

	public static String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        
        LocalTime[] times = new LocalTime[timetable.length];
        
        for(int i=0; i<timetable.length; i++)
        	times[i] = LocalTime.parse(timetable[i]);
        
        LocalTime nextBus = LocalTime.parse("09:00");
        
        for(int i=0; i<m; i++) {
        	
        }
        
        return answer;
    }
	
}
