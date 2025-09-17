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

public class boj_9465_스티커 {

    public static void solve(){
		int t = scan.nextInt();
		while(t-- > 0){
			int n = scan.nextInt();
			int[][] stickers = scan.nextIntMatrix(2, n);
			int[][] dp = new int[2][n];
			// 특정 열에 대해서 첫 번째 행을 선택한다면, 
			// 이전 열에서 첫 번째 행을 선택하지 않았어야한다.
			// 즉, 이전 열에서 두 번째 행을 선택했거나, 아무것도 선택하지 않았어야 한다.
			// 특정 열에 대해서 두 번째 행을 선택한다면,
			// 이전 열에서 두 번째 행을 선택하지 않았어야한다.
			// 즉, 이전 열에서 첫 번째 행을 선택했거나, 아무것도 선택하지 않았어야 한다.
			// 특정 열에서 아무것도 선택하지 않는다면,
			// 이전 열에서 어떤 행을 선택했든지 상관없다.

			// X X O
			// O X X

			// O X O
			// X O X

			// X O X
			// O X O	

			// O X X
			// X X O
			// 이러한 현상을 모두 반영하기 위해서 0~1열까지 초기화한다.

			// 현재 열에서 선택하지 않았을 때 최대가 되는 경우는 이미 X일 적에 반영되므로 고려하지 않아도 된다.
			// 자세히 말하자면, X일때에 대한 최대값은 다음 열(i+1)에서 선택했을 때에 반영된다.

			if(n == 1){
				sb.append(Math.max(stickers[0][0], stickers[1][0])).append('\n');
				continue;
			}
			dp[0][0] = stickers[0][0];
			dp[1][0] = stickers[1][0];
			dp[0][1] = stickers[0][1] + dp[1][0];
			dp[1][1] = stickers[1][1] + dp[0][0];
			for(int i = 2; i < n ; i++){
				dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + stickers[0][i];
				dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + stickers[1][i];
			}
			sb.append(Math.max(dp[0][n-1], dp[1][n-1])).append('\n');			
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