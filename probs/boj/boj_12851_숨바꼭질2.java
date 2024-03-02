package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_12851_숨바꼭질2 {

	static void input() throws Exception {
		int n = scan.nextInt();
		int dest = scan.nextInt();
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {n, 0, 1});
		boolean searching = true;
		int[] minTime = new int[100001];
		int[] visitCount = new int[100001];
		Arrays.fill(minTime, Integer.MAX_VALUE);
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int pos = now[0];
			int time = now[1];
			int numOfCase = now[2];
			// System.out.println(String.format(" pos %d time %d cases %d", pos, time, numOfCase));
			if (pos == dest) {
				searching = false;
			}
			if (minTime[pos] < time)
				continue;
			minTime[pos] = time;
			visitCount[pos] += numOfCase;
			if (!searching)
				continue;
			if (pos > 0)
				q.add(new int[] {pos - 1, time + 1, numOfCase});
			if (pos < dest)
				q.add(new int[] {pos + 1, time + 1, numOfCase});
			if (pos < dest && pos <= 100000 / 2)
				q.add(new int[] {pos * 2, time + 1, numOfCase});
		}
		sb.append(minTime[dest]).append('\n').append(visitCount[dest]);
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