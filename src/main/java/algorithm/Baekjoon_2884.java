package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon_2884 {
	public static void main(String[] args){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
            String[] time = reader.readLine().split(" ");
            int hh = Integer.parseInt(time[0]);
            int mm = Integer.parseInt(time[1]);
            alarm(45, hh, mm);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

	private static void alarm(int earlyMM, int hh, int mm) {
		if( mm >= earlyMM) {
			mm = mm - earlyMM;
		}else {
			if(hh == 0) {
				hh = 23;
			}else {
				hh--;
			}
			mm = 60 + (mm - earlyMM);
		}
		System.out.println(hh + " " + mm);
	}
}
