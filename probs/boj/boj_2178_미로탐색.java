package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2178_미로탐색 {

    static void solve() throws Exception {
		// dfs로 갱신해도 괜찮,
		// 사실 bfs는 도착 시 바로 최단경로이므로 bfs가 더 유리

		int n = scan.nextInt();
		int m = scan.nextInt();
		int[][] arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			String line = scan.nextLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = line.charAt(j) - '0';
			}
		}
		int[][] dist = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		Queue<int[]> q = new ArrayDeque<>();

		q.offer(new int[]{0, 0,1});
		while(!q.isEmpty()){
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			int distance = cur[2];
			if(dist[x][y] <= distance) continue;
			dist[x][y] = distance;
			for(int dir = 0 ; dir < 4; dir++){
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
				if(arr[nx][ny] == 0) continue;
				if(dist[nx][ny] > dist[x][y] + 1){
					// dist[nx][ny] = dist[x][y] + 1;
					q.offer(new int[]{nx, ny, distance + 1});
				}
			}
		}
		sb.append(dist[n-1][m-1]);
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