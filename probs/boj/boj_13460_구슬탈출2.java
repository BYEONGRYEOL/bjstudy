package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_13460_구슬탈출2 {

	// dfs maxDepth를 10으로 제한
	static int maxDepth = 10;
	static int destx;
	static int desty;
	static Map<String, Integer> visitedMap;
	static char[][] board;

	static int[] dirx = {-1, 1, 0, 0};
	static int[] diry = {0, 0, -1, 1};

	static void input() throws Exception {
		int n = scan.nextInt();
		int m = scan.nextInt();
		board = new char[n][m];

		int bx = 0;
		int by = 0;
		int rx = 0;
		int ry = 0;
		desty = 0;
		destx = 0;
		// 초기입력
		for (int i = 0; i < n; i++) {
			String s = scan.nextLine();
			for (int k = 0; k < s.length(); k++) {
				if (s.charAt(k) == '#') {
					board[i][k] = '#';
				} else
					board[i][k] = '.';
				if (s.charAt(k) == 'B') {
					bx = i;
					by = k;
				}
				if (s.charAt(k) == 'R') {
					rx = i;
					ry = k;
				}
				if (s.charAt(k) == 'O') {
					destx = i;
					desty = k;
				}

			}
		}

		// 구슬들이 존재할 수 있는 경우가 생각보다 많지 않다.
		// {rx, ry, bx, by} 4개의 원소를 담는 int[]를 키로 하는 해시맵 활용
		visitedMap = new HashMap<>();

		PriorityQueue<int[]> pq = new PriorityQueue<>((a1, a2) -> a1[0] - a2[0]);
		pq.add(new int[] {0, rx, ry, bx, by});

		while (!pq.isEmpty()) {
			int[] now = pq.poll();
			if (now[0] == maxDepth)
				continue;
			String key = sb.append(now[1]).append(now[2]).append(now[3]).append(now[4]).toString();
			sb.setLength(0);
			// 방문처리와 유망하지않은 노드 제거
			if (visitedMap.containsKey(key)) {
				if (visitedMap.get(key) <= now[0])
					continue;
			}
			visitedMap.put(key, now[0]);

			for (int k = 0; k < 4; k++) {
				rx = now[1];
				ry = now[2];
				bx = now[3];
				by = now[4];

				// 상 이동시 r, b 중 위에있는 애가 먼저
				if (k == 0) {
					if (rx < bx) { // r이 위에있는 상황
						while (rx > 0 && board[rx - 1][ry] == '.') { // 이동가능
							rx--;
							if (rx == destx && ry == desty) {
								rx = -1;
								ry = -1;
								break;
							}
						}
						while (bx > 0 && board[bx - 1][by] == '.' && (bx - 1 == rx && by == ry) == false) { // b 이동가능
							bx--;
							if (bx == destx && by == desty) {
								bx = -1;
								by = -1;
								break;
							}
						}
					} // r이 위에있는 경우
					else { // b가 위에있는 경우
						while (bx > 0 && board[bx - 1][by] == '.') { // b 이동가능
							bx--;
							if (bx == destx && by == desty) {
								bx = -1;
								by = -1;
								break;
							}
						}
						while (rx > 0 && board[rx - 1][ry] == '.' && (bx == rx - 1 && by == ry) == false) { // 이동가능
							rx--;
							if (rx == destx && ry == desty) {
								rx = -1;
								ry = -1;
								break;
							}
						}
					}
				}
				if (k == 1) { //하 이동시 아래에있는 애가 먼저
					if (rx > bx) { // r이 아래에있는 상황
						while (rx > 0 && board[rx + 1][ry] == '.') { // 이동가능
							rx++;
							if (rx == destx && ry == desty) {
								rx = -1;
								ry = -1;
								break;
							}
						}
						while (bx > 0 && board[bx + 1][by] == '.' && (bx + 1 == rx && by == ry) == false) { // b 이동가능
							bx++;
							if (bx == destx && by == desty) {
								bx = -1;
								by = -1;
								break;
							}
						}
					} // r이 아래에있는 경우
					else { // b가 아래에있는 경우
						while (bx > 0 && board[bx + 1][by] == '.') { // b 이동가능
							bx++;
							if (bx == destx && by == desty) {
								bx = -1;
								by = -1;
								break;
							}
						}
						while (rx > 0 && board[rx + 1][ry] == '.' && (bx == rx + 1 && by == ry) == false) { // 이동가능
							rx++;
							if (rx == destx && ry == desty) {
								rx = -1;
								ry = -1;
								break;
							}
						}
					}
				}
				if (k == 2) {
					if (ry < by) { // r이 왼쪽에있는 상황
						while (ry > 0 && board[rx][ry - 1] == '.') { // 이동가능
							ry--;
							if (rx == destx && ry == desty) {
								rx = -1;
								ry = -1;
								break;
							}
						}
						while (by > 0 && board[bx][by - 1] == '.' && (bx == rx && by - 1 == ry) == false) { // b 이동가능
							by--;
							if (bx == destx && by == desty) {
								bx = -1;
								by = -1;
								break;
							}
						}
					} // r이 위에있는 경우
					else { // b가 왼쪽 있는 경우
						while (bx > 0 && board[bx][by - 1] == '.') { // b 이동가능
							by--;
							if (bx == destx && by == desty) {
								bx = -1;
								by = -1;
								break;
							}
						}
						while (rx > 0 && board[rx][ry - 1] == '.' && (bx == rx && by == ry - 1) == false) { // 이동가능
							ry--;
							if (rx == destx && ry == desty) {
								rx = -1;
								ry = -1;
								break;
							}
						}
					}
				}
				if (k == 3) { // 우
					if (ry > by) { // r이 오른쪽에있는 상황
						while (ry > 0 && board[rx][ry + 1] == '.') { // 이동가능
							ry++;
							if (rx == destx && ry == desty) {
								rx = -1;
								ry = -1;
								break;
							}
						}
						while (by > 0 && board[bx][by + 1] == '.' && (bx == rx && by + 1 == ry) == false) { // b 이동가능
							by++;
							if (bx == destx && by == desty) {
								bx = -1;
								by = -1;
								break;
							}
						}
					} // r이 위에있는 경우
					else { // b가 오른쪽 있는 경우
						while (bx > 0 && board[bx][by + 1] == '.') { // b 이동가능
							by++;
							if (bx == destx && by == desty) {
								bx = -1;
								by = -1;
								break;
							}
						}
						while (rx > 0 && board[rx][ry + 1] == '.' && (bx == rx && by == ry + 1) == false) { // 이동가능
							ry++;
							if (rx == destx && ry == desty) {
								rx = -1;
								ry = -1;
								break;
							}
						}
					}
				}

				if (rx == -1) { // 이동이 끝나고,
					if (bx > 0) { // r빠지고 b 살아있으면
						System.out.println(now[0] + 1);
						return;
					}
				}
				//System.out.println("k : " + k + "rx " + rx +"ry " + ry +"bx " + bx +"by " + by);
				pq.add(new int[] {now[0] + 1, rx, ry, bx, by});
			}

		}

		System.out.println(-1);

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