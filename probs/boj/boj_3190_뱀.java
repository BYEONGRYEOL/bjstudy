package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_3190_뱀 {

	static final int UP = 0;
	static final int DOWN = 1;

	static final int LEFT = 2;

	static final int RIGHT = 3;
	static int[] dirx = {-1, 1, 0, 0};
	static int[] diry = {0, 0, -1, 1};

	static void input() throws Exception {
		int n = scan.nextInt();
		int[][] board = new int[n][n];
		int appleCount = scan.nextInt();
		for (int i = 0; i < appleCount; i++) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			board[x - 1][y - 1] = 1;
		}
		int turnCount = scan.nextInt();
		HashMap<Integer, String> turnInfo = new HashMap<>();
		for (int i = 0; i < turnCount; i++) {
			String s = scan.nextLine();
			String[] ss = s.split(" ");
			turnInfo.put(Integer.parseInt(ss[0]), ss[1]);
		}
		Queue<int[]> snake = new LinkedList<>();
		snake.add(new int[] {0, 0});
		int x = 0;
		int y = 0;
		int dir = RIGHT;
		int time = 0;
		while (true) {
			time++;
			x += dirx[dir];
			y += diry[dir];
			if (turnInfo.containsKey(time)) {
				if (turnInfo.get(time).equals("D")) {
					switch (dir) {
						case UP:
							dir = RIGHT;
							break;
						case RIGHT:
							dir = DOWN;
							break;
						case DOWN:
							dir = LEFT;
							break;
						case LEFT:
							dir = UP;
							break;
					}
				} else {
					switch (dir) {
						case UP:
							dir = LEFT;
							break;
						case LEFT:
							dir = DOWN;
							break;
						case DOWN:
							dir = RIGHT;
							break;
						case RIGHT:
							dir = UP;
							break;
					}
				}
			}
			if (x < 0 || x >= n || y < 0 || y >= n || board[x][y] == -1) {
				// System.out.println("x" + x + "y" + y);
				System.out.println(time);
				break;
			}
			if (board[x][y] == 1) {
				board[x][y] = 0;
			} else {
				int[] passby = snake.poll();
				board[passby[0]][passby[1]] = 0;
			}
			snake.add(new int[] {x, y});
			board[x][y] = -1;
		}
	}

	static int calculateK(int n, int m) {
		int calculateK = 0;
		for (int i = 1; i <= n; i++) {
			calculateK += Math.min(m / i, n);
		}
		return calculateK;
	}

	static long lessThanCount(long n, long x) {
		long count = 0;
		for (int i = 1; i <= n; i++) {
			count += Math.min(n, x / i);
		}
		return count;
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