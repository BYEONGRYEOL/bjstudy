package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_25704_출석이벤트 {

	static void input() throws Exception {
		//출석 도장 5개   → 500원 할인 쿠폰
		// 출석 도장 10개 → 10% 할인 쿠폰
		// 출석 도장 15개 → 2,000원 할인 쿠폰
		// 출석 도장 20개 → 25% 할인 쿠폰
		int N = scan.nextInt();
		int P = scan.nextInt();
		int minPrice = P;
		if(N >=20){
			minPrice = Math.min(P * 3 / 4, minPrice);
		}
		if(N >= 15) {
			minPrice = Math.min(P - 2000, minPrice);
		}
		if(N >= 10) {
			minPrice = Math.min(P / 10 * 9, minPrice);
		}
		if(N >= 5) {
			minPrice = Math.min(P -500, minPrice);
		}
		System.out.println(Math.max(0,minPrice));
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
