package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_23348_스트릿코딩파이터 {

	static void input() throws Exception {
		int[] scores = new int[3];
		for (int i = 0; i < 3; i++) {
			scores[i] = scan.nextInt();
		}
		int n = scan.nextInt();
		int maxScore = 0;
		for (int i = 0; i < n; i++) {
			int score = 0;

			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					score += scores[k] * scan.nextInt();
				}
			}
			maxScore  = Math.max(maxScore, score);
		}
		System.out.println(maxScore);
	}

	static long gcd(long a, long b) {
		return a % b == 0 ? b : gcd(b, a % b);
	}

	static int getRemainder(String num, int divisor) {
		int remainder = 0;
		for (int i = 0; i < num.length(); i++) {
			int digit = Character.getNumericValue(num.charAt(i));
			remainder = (remainder * 10 + digit) % divisor;
		}
		return remainder;
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