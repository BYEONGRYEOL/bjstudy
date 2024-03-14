package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_1708_볼록껍질 {

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int compareTo(Point other) {
			if (this.x == other.x) {
				return this.y - other.y > 0 ? 1 : -1;
			}
			return this.x - other.x > 0 ? 1 : -1;
		}
	}

	static void input() throws Exception {
		int n = scan.nextInt();
		List<Point> points = new ArrayList<>();
		Point root = new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);

		for (int i = 0; i < n; i++) {
			Point point = new Point(scan.nextInt(), scan.nextInt());
			if (root.x > point.x || (root.x == point.x && root.y > point.y)) {
				root = point;
			}
			points.add(point);
		}

		points.remove(root);

		final Point finalRoot = root;
		points.sort((p1, p2) -> {
			// ccw
			long ccw = ccw(finalRoot, p1, p2);
			if (ccw == 0) {
				return p1.compareTo(p2);
			}
			// ccw > 0 : 반시계
			// ccw = 0 : 직선
			// ccw < 0 : 시계
			// 시계방향 우선 정렬
			return ccw > 0 ? 1 : -1;
		});

		Stack<Point> s = new Stack<>();
		s.push(root);
		for (int i = 0; i < points.size(); i++) {
			// 시계방향을 기준으로 한바퀴 감쌀 예정
			// 현재 검사하는 점에 의해 반시계방향 방향성이 생긴다면 이전에 선택된 점이 Convex Hull에 포함되지 않으므로 stack에서 제거
			while (s.size() > 1 && ccw(s.get(s.size() - 2), s.get(s.size() - 1), points.get(i)) >= 0) {
				s.pop();
			}
			s.push(points.get(i));
		}
		System.out.println(s.size());

	}

	static long ccw(Point p1, Point p2, Point p3) {
		return ((long)p1.x * (p2.y - p3.y) + (long)p2.x * (p3.y - p1.y) + (long)p3.x * (p1.y - p2.y));
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