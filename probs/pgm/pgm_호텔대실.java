package probs.pgm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class pgm_호텔대실 {
	private static int timeStringToInt(String time){
		String[] ss = time.split(":");
		return Integer.parseInt(ss[0]) * 60 + Integer.parseInt(ss[1]);
	}

	public static int solution(String[][] book_time) {
		int[] bookCountAtTime = new int[60 *24 + 10];
		for(String[] time : book_time){
			int s = timeStringToInt(time[0]);
			int e = timeStringToInt(time[1]);
			for(int i = s ; i < e + 10; i++){
				bookCountAtTime[i] ++;
			}
		}
		return Arrays.stream(bookCountAtTime)
			.max().getAsInt();
	}

	public static void main(String[] args) {
		solution(new String[][]{{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}});
	}
}