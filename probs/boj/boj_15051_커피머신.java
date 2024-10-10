package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_15051_커피머신 {

	static void input() throws Exception {
		int arr[] = new int[3];
		for (int i = 0; i < 3; i++) {
			arr[i] = scan.nextInt();
		}
		int minTime = Integer.MAX_VALUE;
		for (int i = 1; i <= 3; i++) {
			minTime = Math.min(minTime, totalTime(arr, i));
		}
		System.out.println(minTime);
	}
	static int totalTime(int[] arr, int floor){
		int totalTime = 0;
		for (int i = 0; i < 3; i++) {
			totalTime += Math.abs(i - (floor - 1 )) * arr[i] * 2;
		}
		return totalTime;
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