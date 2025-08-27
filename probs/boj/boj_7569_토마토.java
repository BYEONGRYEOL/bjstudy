package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_7569_토마토 {

    static void solve() throws Exception {
		int n = scan.nextInt();
		int m = scan.nextInt();
		int h = scan.nextInt();
		int[][][] box = new int[h][m][n];
		int[][] directions = {{1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};
		boolean[][][] visited = new boolean[h][m][n];
		int noRipeCount = 0;
		Queue<int[]> q = new LinkedList<>();
		for(int i = 0; i < h; i++) {
			for (int j = 0; j < m; j++) {
				for (int k = 0; k < n; k++) {
					box[i][j][k] = scan.nextInt();
					if(box[i][j][k] == 0) {
						noRipeCount++;
					} else if (box[i][j][k] == 1) {
						q.offer(new int[]{i, j, k,0});
					}
				}
			}
		}
		if(noRipeCount == 0) {
			sb.append(0);
			return;
		}
		while(!q.isEmpty()) {
			int[] current = q.poll();
			int z = current[0];
			int y = current[1];
			int x = current[2];
			int day = current[3];
			
			for(int[] dir : directions) {
				int nz = z + dir[0];
				int ny = y + dir[1];
				int nx = x + dir[2];
				if(nz < 0 || nz >= h || ny < 0 || ny >= m || nx < 0 || nx >= n) continue;
				if(visited[nz][ny][nx] || box[nz][ny][nx] != 0) continue;
				if(box[nz][ny][nx] == -1) continue; // Skip if it's a wall
				visited[nz][ny][nx] = true;
				box[nz][ny][nx] = 1;
				noRipeCount--;
				if(noRipeCount == 0){
					sb.append(day + 1);
					return;
				}
				q.offer(new int[]{nz, ny, nx, day+1});
			}
		}
		sb.append(-1);
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