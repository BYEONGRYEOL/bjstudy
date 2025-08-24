package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_14940_쉬운최단거리 {
    static void solve() throws Exception {
		int n = scan.nextInt();
		int m = scan.nextInt();
		int[][] board = scan.nextIntMatrix(n, m);
		
		int[] start = new int[3];
		for(int i = 0;  i < n ; i++){
			for(int j = 0; j < m; j++){
				if(board[i][j] == 2){
					start[0] = i;
					start[1] = j;
				}
			}
		}

		int[] dirX = {-1,1,0,0};
		int[] dirY = {0,0,-1,1};
		Queue<int[]> q = new java.util.LinkedList<>();
		q.offer(start);

		int[][] minDistance = new int[n][m];
		while(!q.isEmpty()){
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			int curDistance = cur[2];
			if(minDistance[x][y] != 0) continue; // Already visited
			minDistance[x][y] = curDistance;
			for(int i = 0; i < 4; i++){
				int nextX = x + dirX[i];
				int nextY = y + dirY[i];

				if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) continue;
				if(board[nextX][nextY] == 0) continue;
				if(minDistance[nextX][nextY] != 0) continue; // Already visited
				if(board[nextX][nextY] == 1){
					board[nextX][nextY] = board[x][y] + 1;
					q.offer(new int[]{nextX, nextY, curDistance + 1});
				}
			}
		}
		minDistance[start[0]][start[1]] = 0; // Start point distance is 0
		
		for(int i = 0 ; i < n; i++){
			for(int j = 0; j < m; j++){
				if(board[i][j] == 1 && minDistance[i][j] == 0) {
					minDistance[i][j] = -1; // If it's unreachable, set distance to -1
				}
			}
		}
		for(int i = 0 ; i < n ; i++){
			for(int j = 0; j < m; j++){
				sb.append(minDistance[i][j]).append(' ');
			}
			sb.append('\n');
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