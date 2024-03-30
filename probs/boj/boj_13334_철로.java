package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_13334_철로 {

	static void input() throws Exception {
		int n = scan.nextInt();
		int[][] array = new int[n][2];
		for (int i = 0; i < n; i++) {
			int s = scan.nextInt();
			int e = scan.nextInt();
			if (s > e) {
				int temp = s;
				s = e;
				e = temp;
			}
			array[i][0] = s;
			array[i][1] = e;
		}
		int d = scan.nextInt();

		Arrays.sort(array, (a1, a2) -> {
			if (a1[1] == a2[1]) {
				return a1[0] - a2[0] ;
			}
			return a1[1] - a2[1];
		});

		PriorityQueue<Integer> startPoints = new PriorityQueue<>();



		int count = 0;
		int maxCount = 0;
		for (int i = 0; i < n; i++) {
			int maskE = array[i][1];
			int maskS = maskE - d;
			if(maskS <= array[i][0] && maskE >= array[i][1]){
				startPoints.add(array[i][0]);
				count++;
			}
			while(!startPoints.isEmpty() && startPoints.peek() < maskS){
				startPoints.poll();
				count --;
			}
			maxCount = Math.max(maxCount, count);

		}

		sb.append(maxCount);
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