package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_31945_정육면체의네꼭지점 {
	static void solve() throws Exception {
		// 점
		// $P_0 = (0,0,0)$,
		// $P_1 = (0,0,1)$,
		// $P_2 = (0,1,0)$,
		// $P_3 = (0,1,1)$,
		// $P_4 = (1,0,0)$,
		// $P_5 = (1,0,1)$,
		// $P_6 = (1,1,0)$,
		// $P_7 = (1,1,1)$을 꼭짓점으로 하는 정육면
		// 0,1,2,3
		// 0,1,4,5
		// 0,2,4,6
		int[][] criteria = {{0, 1, 2, 3}, {4, 5, 6, 7}, {0, 1, 4, 5}, {2, 3, 6, 7}, {0, 2, 4, 6}, {1, 3, 5, 7}};
		int iter = scan.nextInt();
		for (int i = 0; i < iter; i++) {
			int[] num = scan.nextIntArray(4);
			Arrays.sort(num);
			boolean success = false;
			for (int j = 0; j < criteria.length; j++) {
				int flag = 0;
				for (int k = 0; k < 4; k++) {
					if (criteria[j][k] == num[k]) {
						flag++;
					}
				}
				if (flag == 4) {
					success = true;
					break;
				}
			}
			sb.append(success ? "YES" : "NO").append("\n");
		}
	}

	static int toInt(String num) {
		int sum = 0;
		for (int i = 0; i < num.length(); i++) {
			sum += (int)(Math.pow(26, num.length() - 1 - i) * (num.charAt(i) - 'A'));
		}
		return sum;
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