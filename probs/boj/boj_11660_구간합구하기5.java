package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_11660_구간합구하기5 {

    public static void solve(){
		int n = scan.nextInt();
		int m = scan.nextInt();
		int[][] arr = scan.nextIntMatrix(n);
		
		// 누적합 배열을 기록할건데

		// X X X X 
		// X O O O
		// X O O O
		// X X X X

		// 0,0 부터 i,j 까지 합을 다 기록한 다음에, 

		// (x1, y1) ~ (x2, y2) 까지의 합을 구할 때에는

		// AAABBB
		// AAABBB
		// BBBCCC
		// BBBCCC
		// BBBCCC

		// C의 값을 구하려면 B를 포함하는 범위를 빼고 나서, 중복으로 빠진 A를 더해주면 된다.
		
		// (0,0) ~ (x2,y2) 까지의 합 - (0,0) ~ (x1-1,y2) 까지의 합 - (0,0) ~ (x2,y1-1) 까지의 합 + (0,0) ~ (x1-1,y1-1) 까지의 합

		long[][] dp = new long[n+1][n+1];
		for(int i = 1 ; i <= n; i++){
			for(int j = 1 ; j <= n; j++){
				dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + arr[i-1][j-1];
			}
		}
		for(int i = 0 ; i < m; i++){
			int x1 = scan.nextInt();
			int y1 = scan.nextInt();
			int x2 = scan.nextInt();
			int y2 = scan.nextInt();
			long result = dp[x2][y2] - dp[x1-1][y2] - dp[x2][y1-1] + dp[x1-1][y1-1];
			sb.append(result).append('\n');
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