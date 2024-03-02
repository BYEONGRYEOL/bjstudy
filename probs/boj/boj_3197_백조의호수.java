package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_3197_백조의호수 {

	static int R;
	static int C;
	static char[][] board;
	static int[][] newBoard;
	static boolean[][] visited;
	static int[] dirx = {-1, 1, 0, 0};
	static int[] diry = {0, 0, -1, 1};

	static void swanMove(int sx, int sy) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {sx, sy, 0});

	}

	static void bfs(int sx, int sy) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {sx, sy, 0});
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int x = now[0];
			int y = now[1];
			int c = now[2];
			if (newBoard[x][y] == 0) {
				if (c > 0)
					c = 0;
				else
					visited[x][y] = true;
			} else {
				if (newBoard[x][y] <= c)
					continue;
				newBoard[x][y] = c;
			}
			for (int k = 0; k < 4; k++) {
				int newx = x + dirx[k];
				int newy = y + diry[k];
				if (newx >= 0 && newx < R && newy >= 0 && newy < C) {
					if (visited[newx][newy])
						continue;
					q.add(new int[] {newx, newy, (newBoard[newx][newy] > 0 ? c + 1 : c)});
				}
			}
		}
	}

	static void input() throws Exception {
		R = scan.nextInt();
		C = scan.nextInt();
		board = new char[R][C];
		for (int i = 0; i < R; i++)
			board[i] = scan.nextLine().toCharArray();
		newBoard = new int[R][C];
		visited = new boolean[R][C];

		ArrayList<int[]> swans = new ArrayList<>();

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				newBoard[i][j] = board[i][j] == 'x' ? 10000 : 0;
				if (board[i][j] == 'L')
					swans.add(new int[] {i, j});
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (board[i][j] != 'x' && visited[i][j] == false) {
					bfs(i, j);
				}
			}
		}

		// newBoard 갱신 완료

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