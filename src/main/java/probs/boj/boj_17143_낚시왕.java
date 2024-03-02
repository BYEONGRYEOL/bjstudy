package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class boj_17143_낚시왕 {

	static int UP = 1;
	static int DOWN = 2;
	static int LEFT = 4;
	static int RIGHT = 3;

	static void input() throws Exception {
		int R = scan.nextInt();
		int C = scan.nextInt();
		int M = scan.nextInt();
		List<Shark> sharkList = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			sharkList.add(
				new Shark(scan.nextInt() - 1, scan.nextInt() - 1, scan.nextInt(), scan.nextInt(), scan.nextInt()));
		}

		int answer = 0;
		for (int i = 0; i < C; i++) {
			// System.out.println(i + 1 + "로 이동함");
			int caughtSharkIndex = -1;
			int nearX = R;
			for (int j = 0; j < sharkList.size(); j++) {
				if (sharkList.get(j).y == i) {
					if (nearX > sharkList.get(j).x) {
						nearX = sharkList.get(j).x;
						caughtSharkIndex = j;
					}
				}
			}
			if (caughtSharkIndex >= 0) {
				answer += sharkList.get(caughtSharkIndex).size;
				// System.out.println(i + 1 + "으로 이동 후 잡은 상어 " + sharkList.get(caughtSharkIndex).size);
				sharkList.remove(caughtSharkIndex);

			}

			moveSharks(R, C, sharkList);
		}
		System.out.println(answer);
	}

	static void moveSharks(int R, int C, List<Shark> sharkList) {
		ArrayList<Shark> dieSharks = new ArrayList<>();
		Map<String, Shark> sharkMap = new HashMap<>();
		R -= 1;
		C -= 1;
		for (int i = 0; i < sharkList.size(); i++) {
			Shark now = sharkList.get(i);
			int dir = now.dir;
			int move = now.speed;
			// 0000S00
			// 오른쪽으로 2칸
			// S000000
			// 오른쪽으로 6칸
			// 000000S
			// 왼쪽을 바라본다.

			// 0000S00
			// 오른쪽으로 3칸
			// S000000
			// 오른쪽으로 7칸
			// 00000S0
			// 왼쪽을 바라본다.

			// 0000S00
			// 오른쪽으로 9칸
			// S000000
			// 오른쪽으로 13칸
			// 0S00000
			// 오른쪽을 바라본다.
			// System.out.println("이동 전 : " + now.x + " " + now.y);
			if (dir == UP) {
				//R-1 만큼 이동하면 끝으로 이동가능
				move += R - now.x;
				boolean isEven = (move / (R)) % 2 == 0;
				now.x = isEven ? R - (move % R) : (move % R);
				now.dir = (move / (R)) % 2 == 0 ? now.dir : DOWN;
			} else if (dir == DOWN) {
				//R-1 만큼 이동하면 끝으로 이동가능
				move += now.x;
				boolean isEven = (move / (R)) % 2 == 0;
				now.x = isEven ? (move % R) : R - (move % R);
				now.dir = isEven ? now.dir : UP;
			} else if (dir == LEFT) {
				//R-1 만큼 이동하면 끝으로 이동가능
				move += C - now.y;
				boolean isEven = (move / C) % 2 == 0;
				now.y = isEven ? (C - (move % C)) : move % C;
				now.dir = (move / (C)) % 2 == 0 ? now.dir : RIGHT;
			} else if (dir == RIGHT) {
				//R-1 만큼 이동하면 끝으로 이동가능
				move += now.y;
				boolean isEven = (move / C) % 2 == 0;
				now.y = isEven ? move % C : (C - (move % C));
				now.dir = (move / (C)) % 2 == 0 ? now.dir : LEFT;
			}
			// System.out.println("이동 후 : " + now.x + " " + now.y);
			String posKey = String.format("%d %d", now.x, now.y);
			if (sharkMap.containsKey(posKey)) {
				if (sharkMap.get(posKey).size < now.size) {
					// System.out.println(now.size + " 가" + sharkMap.get(posKey).size + " 보다 무거우니까 잡아먹기");
					dieSharks.add(sharkMap.get(posKey));
					sharkMap.put(posKey, now);
				} else {
					// System.out.println(now.size + " 가" + sharkMap.get(posKey).size + " 보다 가벼우니까 잡아먹히기");
					dieSharks.add(now);
				}
			} else {
				// System.out.println("아무 상어도 없었음");
				sharkMap.put(posKey, now);
			}
		}
		sharkList.removeAll(dieSharks);
	}

	static class Shark {
		int x;
		int y;
		int speed;
		int dir;
		int size;

		public Shark(int x, int y, int speed, int dir, int size) {
			this.x = x;
			this.y = y;
			this.speed = speed;
			this.dir = dir;
			this.size = size;
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