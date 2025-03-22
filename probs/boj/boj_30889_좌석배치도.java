package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_30889_좌석배치도 {

	static void solve() throws Exception {
		int n = scan.nextInt();
		char[][] seats = new char[10][20];
		for (int i = 0; i < 10; i++) {
			Arrays.fill(seats[i],'.');
		}
		for (int i = 0; i < n; i++) {
			String seat = scan.nextLine();
			int[] idx = toIndex(seat);
			seats[idx[0]][idx[1]] = 'o';
		}
		Arrays.stream(seats).forEachOrdered(System.out::println);
	}
	static int[] toIndex(String seat){
		int row = seat.charAt(0) - 'A';
		int col = Integer.parseInt(seat.substring(1)) - 1;
		return new int[]{row, col};
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
		solve();
	}

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

}