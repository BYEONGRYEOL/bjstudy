	package probs.boj;

	import java.io.BufferedReader;
	import java.io.File;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.util.Arrays;
	import java.util.StringTokenizer;

	public class boj_9076_점수집계 {
		static void solve() throws Exception {
			int T = scan.nextInt();

			for (int t = 0; t < T; t++) {
				int[] scores = new int[5];
				for (int i = 0; i < 5; i++) {
					scores[i] = scan.nextInt();
				}
				System.out.println(calculateScore(scores));
			}
		}

		private static String calculateScore(int[] scores) {
			Arrays.sort(scores);
			int[] middleScores = Arrays.copyOfRange(scores, 1, 4);

			int range = middleScores[2] - middleScores[0];
			if (range >= 4) {
				return "KIN";
			}

			return String.valueOf(middleScores[0] + middleScores[1] + middleScores[2]);
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