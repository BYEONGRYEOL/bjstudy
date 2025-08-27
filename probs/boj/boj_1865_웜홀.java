package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1865_웜홀 {

	static int[] dist;

    static void solve() throws Exception {
		int tc = scan.nextInt();
		while (tc-- > 0) {
			int node = scan.nextInt();
			int edge = scan.nextInt();
			int wormhole = scan.nextInt();
			dist = new int[node + 1];
			ArrayList<int[]>[] adj = new ArrayList[node + 1];
			// 가상의 노드 0을 추가해서 0에서 모든 노드로 가는 간선 추가
			for (int i = 0; i <= node; i++) {
				adj[i] = new ArrayList<>();
			}
			for(int i = 1; i <= node; i++) {
				adj[0].add(new int[] {i, 0}); //단방향
			}
			for (int i = 0; i < edge; i++) {
				int a = scan.nextInt();
				int b = scan.nextInt();
				int c = scan.nextInt();
				adj[a].add(new int[] { b, c });
				adj[b].add(new int[] { a, c });
			}
			for (int i = 0; i < wormhole; i++) {
				int a = scan.nextInt();
				int b = scan.nextInt();
				int c = scan.nextInt();
				adj[a].add(new int[] { b, -c });
			}
			Arrays.fill(dist, Integer.MAX_VALUE);

			bellmanFord(0, adj, node);
		}
	}

	static void bellmanFord(int start, ArrayList<int[]>[] adj, int node) {
		
		dist[start] = 0;

		boolean updated = false;
		for (int i = 0; i <= node; i++) {
			updated = false;
			for (int j = 0; j <= node; j++) {
				for (int[] edges : adj[j]) {
					int cur = j;
					int next = edges[0];
					int cost = edges[1];

					if (dist[j] != Integer.MAX_VALUE && dist[next] > dist[j] + cost) {
						dist[next] = dist[j] + cost;
						updated = true;
					}
				}
			}
			if (!updated) break;
		}
		if (updated) {
			sb.append("YES\n");
		} else {
			sb.append("NO\n");
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