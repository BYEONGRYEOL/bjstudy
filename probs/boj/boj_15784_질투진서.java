package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_15784_질투진서 {

	static void input() throws Exception {
		int n = scan.nextInt();
		int row = scan.nextInt()-1;
		int col = scan.nextInt()-1;
		int[][] array = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				array[i][j] = scan.nextInt();
			}
		}
		int jinseoCharm = array[row][col];
		boolean angry = false;
		for (int i = 0; i < n; i++) {
			if(jinseoCharm <array[i][col]){
				angry = true;
			}
		}
		for (int i = 0; i < n; i++) {
			if(jinseoCharm <array[row][i]){
				angry = true;
			}
		}
		System.out.println(angry? "ANGRY":"HAPPY");
	}


	static int calculateK(int n, int m) {
		int calculateK = 0;
		for (int i = 1; i <= n; i++) {
			calculateK += Math.min(m / i, n);
		}
		return calculateK;
	}

	static long lessThanCount(long n, long x) {
		long count = 0;
		for (int i = 1; i <= n; i++) {
			count += Math.min(n, x / i);
		}
		return count;
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