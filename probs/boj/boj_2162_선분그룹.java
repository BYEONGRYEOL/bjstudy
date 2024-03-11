package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class boj_2162_선분그룹 {

	// static double e = 0.0001d;
	static int[] parent;
	static int[] rank;

	static int[][][] points;

	static int findParent(int c) {
		if (c == parent[c])
			return c;
		parent[c] = findParent(parent[c]);
		return parent[c];
	}

	static void union(int a, int b) {
		int c = findParent(a);
		int p = findParent(b);
		if (c == p)
			return;
		if (rank[c] < rank[p]) {
			parent[c] = p;
		} else if (rank[c] > rank[p]) {
			parent[p] = c;
		} else {
			parent[p] = c;
			rank[c]++;
		}
	}

	static void input() throws Exception {
		int n = scan.nextInt();
		parent = new int[n];
		rank = new int[n];
		points = new int[n][2][2];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
			rank[i] = 1;
		}
		for (int i = 0; i < n; i++)
			for (int j = 0; j < 2; j++)
				for (int k = 0; k < 2; k++)
					points[i][j][k] = scan.nextInt();
		for (int i = 0; i < n; i++)
			for (int j = 0; j < i; j++)
				if (checkIntersect(i, j))
					union(i, j);

		Map<Integer, Integer> sets = new HashMap<>();
		for (int i = 0; i < n; i++) {
			int root = findParent(i);
			sets.put(root, sets.getOrDefault(root, 0) + 1);
		}

		int setCount = 0;
		int maxElementCount = 0;
		for (Map.Entry<Integer, Integer> entry : sets.entrySet()) {
			setCount++;
			maxElementCount = Math.max(maxElementCount, entry.getValue());
		}

		sb.append(setCount).append('\n');
		sb.append(maxElementCount);
		print();
	}

	static int ccw(int[] p1, int[] p2, int[] p3) {
		int s = p1[0] * p2[1] + p2[0] * p3[1] + p3[0] * p1[1];
		s -= p1[1] * p2[0] + p2[1] * p3[0] + p3[1] * p1[0];
		return Integer.compare(s, 0);
	}

	static boolean checkIntersect(int i, int j) {
		int[] p1 = points[i][0];
		int[] p2 = points[i][1];
		int[] p3 = points[j][0];
		int[] p4 = points[j][1];
		int ccw1 = ccw(p1, p2, p3);
		int ccw2 = ccw(p1, p2, p4);
		int ccw4 = ccw(p3, p4, p2);
		int ccw3 = ccw(p3, p4, p1);

		if (ccw1 * ccw2 < 0 && ccw3 * ccw4 < 0)
			return true;
		if (ccw1 == 0 && isBetween(p1, p2, p3))
			return true;
		if (ccw2 == 0 && isBetween(p1, p2, p4))
			return true;
		if (ccw3 == 0 && isBetween(p3, p4, p1))
			return true;
		if (ccw4 == 0 && isBetween(p3, p4, p2))
			return true;

		return false;
	}

	static boolean isBetween(int[] p1, int[] p2, int[] x) {
		return x[0] >= Math.min(p1[0], p2[0]) && x[0] <= Math.max(p1[0], p2[0]) && x[1] >= Math.min(p1[1], p2[1])
			&& x[1] <= Math.max(p1[1], p2[1]);
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