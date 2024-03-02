package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_10451_순열사이클 {

	static void input() throws Exception {
		int caseNum = scan.nextInt();
		for (int i = 0; i < caseNum; i++) {
			int n = scan.nextInt();
			int[] array = new int[n + 1];
			for (int j = 1; j < n + 1; j++) {
				array[j] = scan.nextInt();
			}
			boolean[] visited = new boolean[n + 1];
			int numOfCycle = 0;
			for (int j = 1; j < n + 1; j++) {
				if (!visited[j]) {
					dfs(array, visited, j);
					numOfCycle++;
				}
			}
			sb.append(numOfCycle).append('\n');
		}
		print();
	}

	static void dfs(int[] array, boolean[] visited, int node) {
		if (visited[node]) {
			return;
		}
		visited[node] = true;
		dfs(array, visited, array[node]);
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