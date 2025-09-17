package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_17070_파이프옮기기1 {
	
    static int[][] board;
	static int GARO = 0;
	static int SERO = 1;
	static int DAGAK = 2;
	static int n;
	static int route = 0;
	static void solve() throws Exception {
		n = scan.nextInt();
		board = scan.nextIntMatrix(n);
		// {가장마지막 위치, 파이스상태{0,1,2}}
		// 0 가로
		// 1 세로
		// 2 대각선
		dfs(0,1, GARO);
		sb.append(route);
	}

	static void dfs(int x, int y, int status){
		if(x == n-1 && y == n-1){
			route ++;
			return;
		}
		if(status == GARO){
			if(y + 1 < n && board[x][y+1] == 0)
				dfs(x, y+1, GARO);
			if(x+1 < n && y + 1 < n && board[x][y+1] == 0 && board[x+1][y] == 0 && board[x+1][y+1] == 0)
				dfs(x+1,y+1,DAGAK);
		}
		else if(status == SERO){
			if(x + 1 < n &&board[x+1][y] == 0)
				dfs(x+1, y, SERO);
			if(x+1 < n && y + 1 < n && board[x][y+1] == 0 && board[x+1][y] == 0 && board[x+1][y+1] == 0)
				dfs(x+1,y+1,DAGAK);
		}
		else if(status == DAGAK){
			if(x + 1 < n &&board[x+1][y] == 0)
				dfs(x+1, y, SERO);
			if(y + 1 < n &&board[x][y+1] == 0)
				dfs(x, y+1, GARO);
			if(x+1 < n && y + 1 < n && board[x][y+1] == 0 && board[x+1][y] == 0 && board[x+1][y+1] == 0)
				dfs(x+1,y+1,DAGAK);
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