package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_2606_바이러스 {

	static int answer = 0;
	static boolean[] visited;

	static void dfs(ArrayList<Integer>[] edges, int node) {
		if (visited[node])
			return;
		visited[node] = true;
		answer++;
		for (Integer next : edges[node]) {
			dfs(edges, next);
		}
	}

	static void input() throws Exception {
		int n = scan.nextInt();
		int m = scan.nextInt();
		visited = new boolean[n + 1];
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

		dfs(edges, 1);
		System.out.println(answer - 1);
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