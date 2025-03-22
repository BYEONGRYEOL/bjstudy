package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_10262_주사위게임 {
	static void solve() throws Exception {
		int[][] dice = scan.nextIntMatrix(2,4);
		int sum1 = Arrays.stream(dice[0]).sum();
		int sum2 = Arrays.stream(dice[1]).sum();
		sb.append(sum1==sum2 ? "Tie" : sum1<sum2 ? "Emma" : "Gunnar");
	}

	private static int calculatePrize(int[] dice) {
		int[] count = new int[7];
		for (int num : dice) {
			count[num]++;
		}

		int prize = 0;

		for (int i = 1; i <= 6; i++) {
			if (count[i] == 4) {
				prize = 50000 + i * 5000;
				return prize;
			}
		}

		for (int i = 1; i <= 6; i++) {
			if (count[i] == 3) {
				prize = 10000 + i * 1000;
				return prize;
			}
		}

		int pair1 = 0, pair2 = 0;
		for (int i = 1; i <= 6; i++) {
			if (count[i] == 2) {
				if (pair1 == 0) {
					pair1 = i;
				} else {
					pair2 = i;
				}
			}
		}
		if (pair1 > 0 && pair2 > 0) {
			prize = 2000 + pair1 * 500 + pair2 * 500;
			return prize;
		}

		// 같은 눈 2개
		for (int i = 1; i <= 6; i++) {
			if (count[i] == 2) {
				prize = 1000 + i * 100;
				return prize;
			}
		}

		for (int i = 6; i >= 1; i--) {
			if (count[i] == 1) {
				prize = i * 100;
				break;
			}
		}

		return prize;
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

		int[] nextIntArray(int n) {
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = nextInt();
			}
			return arr;
		}

		long[] nextLongArray(int n) {
			long[] arr = new long[n];
			for (int i = 0; i < n; i++) {
				arr[i] = nextLong();
			}
			return arr;
		}

		long[][] nextLongMatrix(int n, int m) {
			long[][] arr = new long[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					arr[i][j] = nextLong();
				}
			}
			return arr;
		}

		public double[] nextDoubleArray(int n) {
			double[] arr = new double[n];
			for (int i = 0; i < n; i++) {
				arr[i] = nextDouble();
			}
			return arr;
		}

		double[][] nextDoubleMatrix(int n, int m) {
			double[][] arr = new double[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					arr[i][j] = nextDouble();
				}
			}
			return arr;
		}

		int[][] nextIntMatrix(int n) {
			return nextIntMatrix(n, n);
		}

		int[][] nextIntMatrix(int n, int m) {
			int[][] arr = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					arr[i][j] = nextInt();
				}
			}
			return arr;
		}

		char[] nextCharArrayFromString() {
			return scan.nextLine().toCharArray();
		}

		char[][] nextCharMatrixFromString(int n) {
			char[][] arr = new char[n][];
			for (int i = 0; i < n; i++) {
				arr[i] = nextCharArrayFromString();
			}
			return arr;
		}

		public String[] nextStringArray(int n) {
			String[] arr = new String[n];
			for (int i = 0; i < n; i++) {
				arr[i] = scan.nextLine();
			}
			return arr;
		}
	}

	public static void main(String[] args) throws Exception {
		solve();
		print();
	}

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

}