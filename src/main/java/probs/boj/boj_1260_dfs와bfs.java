package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1260_dfs와bfs {

	static void dfs(ArrayList<Integer>[] edges, boolean[] visited, int node) {
		if (visited[node])
			return;
		visited[node] = true;
		sb.append(node).append(' ');
		for (Integer next : edges[node])
			if (!visited[next])
				dfs(edges, visited, next);
	}

	static void bfs(ArrayList<Integer>[] edges, boolean[] visited, int node) {
		Queue<Integer> q = new LinkedList<>();
		q.add(node);
		while (!q.isEmpty()) {
			Integer now = q.poll();
			if (visited[now])
				continue;
			visited[now] = true;
			sb.append(now).append(' ');
			for (Integer next : edges[now]) {
				if (!visited[next]) {
					q.add(next);
				}
			}
		}
	}

	static void input() throws Exception {
		int n = scan.nextInt();
		int m = scan.nextInt();
		int start = scan.nextInt();

		ArrayList<Integer>[] edges = new ArrayList[n + 1];
		for (int i = 0; i < n + 1; i++) {
			edges[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			int s = scan.nextInt();
			int e = scan.nextInt();
			edges[s].add(e);
			edges[e].add(s);
		}

		for (int i = 0; i < n + 1; i++) {
			edges[i].sort((i1, i2) -> i1 - i2);
		}

		boolean visited[] = new boolean[n + 1];
		dfs(edges, visited, start);
		sb.append('\n');
		Arrays.fill(visited, false);
		bfs(edges, visited, start);
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