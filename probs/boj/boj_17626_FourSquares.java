package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_17626_FourSquares {

    static void solve() throws Exception {
		// 제곱해서 50000 이하의 수를 구한다.
		int n = scan.nextInt();
		int[] dp = new int[n + 1];
		dp[0] = 0; // 0은 제곱수의 합으로 표현할 수 없음
		// 1 = 1제곱
		// 2 = 1제곱 + 1제곱
		// 3 = 1제곱 + 1제곱 + 1제곱
		// 4 = 2제곱
		// 5 = 4 + 1
		// 6 = 4 + 1 + 1
		// 7 = 4 + 1 + 1 + 1
		// 8 = 4 + 4
		// 갱신 방식의 DP
		// 특정 n 에 대해서 정답인 dp[n]을 알 고 있다면,
		// n + 제곱수에 대해서도 답을 알 수 있다.
		// n + 1
		// n + 4 ,., 등등
		// 물론 n + 36 같이 멀어지는 경우 다른 n에 의해 초기화될 수 있다. 이 때 n은 더 작을 수도 있음,
		// 그렇다면 기준을 n + 제곱수가 아니라, n - 제곱수로 잡아서 갱신dp 진행
		for(int i = 1 ; i <=n ; i ++){
			dp[i] = Integer.MAX_VALUE; // 초기값을 최대값으로 설정
			for(int j = 1; j * j <= i; j++){
				dp[i] = Math.min(dp[i], dp[i - j*j] +1);
			}
		}
		sb.append(dp[n]);
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

		String[][] nextStringMatrix_space(int n, int m) {
			String[][] arr = new String[n][m];
			for (int i = 0; i < n; i++) {
				arr[i] = scan.nextLine().split(" ");
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

	}

	public static void main(String[] args) throws Exception {
		solve();
		print();
	}

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

}