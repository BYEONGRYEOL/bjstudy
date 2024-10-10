package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_10101_삼각형외우기 {

	static void input() throws Exception {
		int[] angle = new int[3];
		for (int i = 0; i < 3; i++) {
			angle[i] = scan.nextInt();
		}
		if(angle[0] == 60 && angle[1] == 60 && angle[2] == 60){
			System.out.println("Equilateral");
		} else if (angle[0] + angle[1] + angle[2] == 180){
			if(angle[0] == angle[1] || angle[0] == angle[2] || angle[1] == angle[2]){
				System.out.println("Isosceles");
			} else {
				System.out.println("Scalene");
			}
		} else{
			System.out.println("Error");
		}
	}

	static void print() {
		System.out.print(sb.toString());
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		public FastReader(String s) throws FileNotFoundException {
			br = new BufferedReader(new FileReader(new File(s)));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

	public static void main(String[] args) throws Exception {
		input();
	}

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

}