package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_21736_헌내기는친구가필요해 {

    static void solve() throws Exception {
		int n = scan.nextInt();
		int m = scan.nextInt();
		char[][] map = new char[n][m];
		for(int i = 0; i < n; i++) {
			map[i] = scan.nextCharArrayFromString();
		}
		int sX = -1;
		int sY = -1;
		for(int i  = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == 'I') {
					map[i][j] = 'O';
					sX = i;
					sY = j;
				}
			}
		}
		boolean[][] visited = new boolean[n][m];
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};

		int count = 0;
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {sX, sY});
		while(!queue.isEmpty()){
			int[] cur = queue.poll();
			int x = cur[0];
			int y = cur[1];
			if(visited[x][y]) continue;
			visited[x][y] = true;
			if(map[x][y] == 'P') {
				count++;
			}
			for(int k = 0 ; k < 4 ; k++){
				int nextX = x + dx[k];
				int nextY = y + dy[k];
				if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) continue;
				if(visited[nextX][nextY]) continue;
				if(map[nextX][nextY] == 'X') continue;
				queue.offer(new int[] {nextX, nextY});
			}
		}
		sb.append(count == 0 ? "TT" : count);
		
	}

	static int result(long[] arr, long m){
		int max = 0;
		for(int i = 0 ; i < arr.length; i++){
			max += arr[i] / m;
		}
		return max;
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