package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_14938_서강그라운드 {
	static void solve() throws Exception {
		// 지역마다 아이템 몇개인지는 안다.
		// 1 to N(전체) 로 탐색해야하므로, 크루스칼 월리스 탐색
		
		int n = scan.nextInt();
		int canGoDistance = scan.nextInt();
		int r = scan.nextInt();
		int[] rewardCount = scan.nextIntArray(n);
		int[][] board = new int[n+1][n+1];
		for(int i = 0 ; i < n+1; i++){
			Arrays.fill(board[i], Integer.MAX_VALUE /2);
			board[i][i] = 0;
		}
		
		for(int i  = 0 ; i < r ; i ++){
			int s = scan.nextInt();
			int e = scan.nextInt();
			int dist = scan.nextInt();
			board[s][e] = dist;
			board[e][s] = dist;
		}
		
		for(int k = 1 ; k <=n ; k++)
			for(int i = 1 ; i <=n; i++)
				for(int j = 1 ; j <= n ; j++)
					board[i][j] = Math.min(board[i][k] + board[k][j], board[i][j]);

		int maxReward = 0;
		int curReward = 0;
		for(int i = 1 ; i <=n; i++){
			curReward = 0;
			for(int j = 1; j <=n ; j ++)
				if(board[i][j] <= canGoDistance)
					curReward += rewardCount[j-1];
			maxReward = Math.max(maxReward, curReward);
		}
		sb.append(maxReward);
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