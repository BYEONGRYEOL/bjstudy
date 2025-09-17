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

public class boj_5430_AC {

    static void solve() throws Exception {
		int t = scan.nextInt();
		while( t > 0){
			t--;
			String command = scan.nextLine();
			int n = scan.nextInt();
			String arr = scan.nextLine();
			String[] elements = arr.substring(1, arr.length() - 1).split(",");
			int start = 0;
			int end = n;
			boolean reverse = false;
			boolean error = false;
			for (char c : command.toCharArray()) {
				if (c == 'R') {
					reverse = !reverse; // Toggle reverse flag
				} else if (c == 'D') {
					if (n == 0) {
						error = true; // Error if trying to delete from an empty array
						break;
					}
					if (reverse) {
						end--; // Remove from end
					} else {
						start++; // Remove from start
					}
					n--;
				}
			}
			if(!error){
				if(reverse){
					sb.append("[");
					for(int i = end - 1; i >= start; i--){
						sb.append(elements[i]);
						if(i > start) sb.append(",");
					}
					sb.append("]\n");
				} else {
					sb.append("[");
					for(int i = start; i < end; i++){
						sb.append(elements[i]);
						if(i < end - 1) sb.append(",");
					}
					sb.append("]\n");
				}
			}else{
				sb.append("error\n");
			}
		}
	}

	static void dfs(int[][] graph, int[][] reachable, int start, int current) {
		for (int next = 0; next < graph.length; next++) {
			if (graph[current][next] == 1 && reachable[start][next] == 0) {
				reachable[start][next] = 1;
				dfs(graph, reachable, start, next);
			}
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