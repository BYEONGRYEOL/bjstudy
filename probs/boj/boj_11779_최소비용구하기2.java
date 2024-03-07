package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_11779_최소비용구하기2 {

	static void input() throws Exception {
		int n = scan.nextInt();
		int m = scan.nextInt();
		List<int[]>[] edges = new List[n + 1];
		for (int i = 0; i < n + 1; i++) {
			edges[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			int s = scan.nextInt();
			int e = scan.nextInt();
			int v = scan.nextInt();
			edges[s].add(new int[] {e, v});
		}

		int start = scan.nextInt();
		int end = scan.nextInt();

		int[] minDist = new int[n + 1];
		Arrays.fill(minDist, Integer.MAX_VALUE);
		int[] optPath = new int[n + 1];
		PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
		q.add(new int[] {start, 0});
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int pos = now[0];
			int dist = now[1];
			if (minDist[pos] <= dist)
				continue;
			minDist[pos] = dist;
			if (pos == end)
				continue;
			for (int[] next : edges[pos]) {
				int nextPos = next[0];
				int nextDist = dist + next[1];
				if (minDist[nextPos] > nextDist) {
					optPath[nextPos] = pos;
					q.add(new int[] {nextPos, nextDist});
				}
			}
		}
		int ptr = end;
		int optPathLen = 1;
		StringBuilder optPathReversed = new StringBuilder().append(end);
		while (optPath[ptr] != 0) {
			optPathLen++;
			ptr = optPath[ptr];
			optPathReversed.append(' ').append(ptr);
		}
		sb.append(minDist[end]).append('\n');
		sb.append(optPathLen).append('\n');
		sb.append(optPathReversed.reverse());
		print();
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