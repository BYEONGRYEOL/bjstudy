package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1966_프린터큐 {

	static void input() throws Exception {
		int t = scan.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> i2 - i1);
		Queue<int[]> q = new LinkedList<>();
		for (int z = 0; z < t; z++) {
			pq.clear();
			q.clear();

			int n = scan.nextInt();
			int m = scan.nextInt();
			for (int i = 0; i < n; i++) {
				int priority = scan.nextInt();
				pq.add(priority);
				q.add(new int[] {priority, i});
			}
			int popped = 0;
			while (!q.isEmpty() && !pq.isEmpty()) {
				int[] now = q.poll();
				if (now[0] == pq.peek()) {
					popped++;
					pq.poll();
					if (now[1] == m) {
						sb.append(popped).append('\n');
						break;
					}
				} else {
					q.add(now);
				}
			}
		}
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