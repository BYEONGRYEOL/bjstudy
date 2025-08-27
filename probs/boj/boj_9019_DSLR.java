package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_9019_DSLR {

	static class State{
		int num;
		String command;
		public State(int num, String command) {
			this.num = num;
			this.command = command;
		}
	}
    static void solve() throws Exception {
		int t = scan.nextInt();
		while(t-->0) {
			int start = scan.nextInt();
			int end = scan.nextInt();
			boolean[] visited = new boolean[10000];
			Queue<State> queue = new LinkedList<>();
			State startState = new State(start, "");
			queue.add(startState); // num, depth, command
			while(!queue.isEmpty()){
				State cur = queue.poll();
				int num = cur.num;
				if(visited[num]) continue;
				visited[num] = true;

				int nextNum = (num*2)%10000;
				if(nextNum == end) {
					sb.append(cur.command).append("D\n");
					break;
				}
				State nextStateD = new State(nextNum, cur.command + "D");
				queue.add(nextStateD); // D
				
				nextNum = (num == 0 ? 9999 : num - 1);
				if(nextNum == end) {
					sb.append(cur.command).append("S\n");
					break;
				}
				State nextStateS = new State(nextNum, cur.command + "S");
				queue.add(nextStateS); // S

				nextNum = (num / 1000) + // 1의자리
						(num % 10) * 10 + // 10의자리
						((num % 100) / 10) * 100 + // 100의자리
						((num % 1000) / 100) * 1000 // 1000의자리
						;
				if(nextNum == end) {
					sb.append(cur.command).append("L\n");
					break;
				}
				State nextStateL = new State(nextNum, cur.command + "L");
				queue.add(nextStateL); // L


				nextNum = ((num % 100) / 10) + // 1의자리
						((num % 1000) / 100) * 10 + // 10의자리				
						(num % 10 ) * 1000 + // 1000의자리				
						(num / 1000) * 100  // 100의자리				
						;				
				if(nextNum == end) {
					sb.append(cur.command).append("R\n");
					break;
				}
				State nextStateR = new State(nextNum, cur.command + "R");
				queue.add(nextStateR); // R
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