package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_31669_특별한학교탈출 {

	static void input() throws Exception {
		int n = scan.nextInt();
		int m = scan.nextInt();
		int[] possible = new int[m];
		Arrays.fill(possible, 1);
		for (int i = 0; i < n; i++) {
			String line = scan.nextLine();
			for (int j = 0; j < m; j++) {
				possible[j] *= (line.charAt(m) == 'X' ? 1 : 0);
			}
		}
		for (int i = 0; i < m; i++) {
			if(possible[i] == 1){
				System.out.println(i+1);
				return;
			}
		}
		System.out.println("ESCAPE FAILED");
	}

	static BigInteger fact(int s, int e) {
		if (s < e) {
			int m = (s + e) / 2;
			return fact(s, m).multiply(fact(m + 1, e));
		}
		return new BigInteger(String.valueOf(s));
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
