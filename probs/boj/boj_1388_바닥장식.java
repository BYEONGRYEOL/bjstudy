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

public class boj_1388_바닥장식 {
	static int[] xMove = {-1, 1};
	static int[] yMove = {-1, 1};

	static void input() throws Exception {
		int n = scan.nextInt();
		int m = scan.nextInt();

		char[][] board = new char[n][m];

		for (int i = 0; i < n; i++) {
			board[i] = scan.nextLine().toCharArray();
		}

		boolean[][] visited = new boolean[n][m];
		int numOfCluster = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j]) {
					numOfCluster++;
					findCluster(board, i, j, visited);
				}
			}
		}
		System.out.println(numOfCluster);
	}

	static void findCluster(char[][] board, int sx, int sy, boolean[][] visited) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {sx, sy});
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int x = now[0];
			int y = now[1];
			visited[x][y] = true;
			for (int i = 0; i < 2; i++) {
				if (board[x][y] == '|') {
					int newx = x + xMove[i];
					if (newx >= 0 && newx < board.length && !visited[newx][y] && board[newx][y] == '|') {
						queue.add(new int[] {newx, y});
					}
				} else if (board[x][y] == '-') {
					int newy = y + yMove[i];
					if (newy >= 0 && newy < board[0].length && !visited[x][newy] && board[x][newy] == '-') {
						queue.add(new int[] {x, newy});
					}
				}
			}

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
	}

	public static void main(String[] args) throws Exception {
		input();
	}

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

}