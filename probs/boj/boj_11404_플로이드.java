package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_11404_플로이드 {

	public static void solve() {
		int n = scan.nextInt();
		int m = scan.nextInt();
		int[][] graph = new int[n + 1][n + 1];
		for (int[] graphRow : graph) {
			Arrays.fill(graphRow, Integer.MAX_VALUE / 2);
		}
		for (int i = 1; i <= n; i++) {
			graph[i][i] = 0;
		}
		for (int i = 0; i < m; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			int c = scan.nextInt();
			graph[a][b] = Math.min(graph[a][b], c);
		}

		// 플로이드 워셜 알고리즘

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					// i -> k -> j 로 가는게 i -> j 로 바로 가는 것보다 더 짧은 경우를 찾는다.
					graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
				}
			}
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (graph[i][j] == Integer.MAX_VALUE / 2) {
					sb.append(0).append(' ');
				} else {
					sb.append(graph[i][j]).append(' ');
				}
			}
			sb.append('\n');
		}
	}

	static int[] getLongestNode(List<int[]>[] nodes, int start) {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[] visited = new boolean[nodes.length];
		int maxLen = 0;
		int[] farthestNode = new int[2];
		q.add(new int[] { start, 0 });
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			if (visited[cur[0]])
				continue;
			visited[cur[0]] = true;
			if (cur[1] > maxLen) {
				maxLen = cur[1];
				farthestNode = cur;
			}
			for (int i = 0; i < nodes[cur[0]].size(); i++) {
				if (nodes[cur[0]].get(i) != null && !visited[nodes[cur[0]].get(i)[0]]) {
					q.add(new int[] { nodes[cur[0]].get(i)[0], cur[1] + nodes[cur[0]].get(i)[1] });
				}
			}
		}
		return farthestNode;
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

		int[] nextIntArray(int n) {
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = nextInt();
			}
			return arr;
		}

		long[] nextLongArray(int n) {
			long[] arr = new long[n];
			for (int i = 0; i < n; i++) {
				arr[i] = nextLong();
			}
			return arr;
		}

		long[][] nextLongMatrix(int n, int m) {
			long[][] arr = new long[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					arr[i][j] = nextLong();
				}
			}
			return arr;
		}

		String[][] nextStringMatrix_space(int n, int m) {
			String[][] arr = new String[n][m];
			for (int i = 0; i < n; i++) {
				arr[i] = scan.nextLine().split(" ");
			}
			return arr;
		}

		public double[] nextDoubleArray(int n) {
			double[] arr = new double[n];
			for (int i = 0; i < n; i++) {
				arr[i] = nextDouble();
			}
			return arr;
		}

		double[][] nextDoubleMatrix(int n, int m) {
			double[][] arr = new double[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					arr[i][j] = nextDouble();
				}
			}
			return arr;
		}

		int[][] nextIntMatrix(int n) {
			return nextIntMatrix(n, n);
		}

		int[][] nextIntMatrix(int n, int m) {
			int[][] arr = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					arr[i][j] = nextInt();
				}
			}
			return arr;
		}

		char[] nextCharArrayFromString() {
			return scan.nextLine().toCharArray();
		}

	}

	public static void main(String[] args) throws Exception {
		solve();
		print();
	}

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

}