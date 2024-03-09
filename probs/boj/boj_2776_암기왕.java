package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.StringTokenizer;

public class boj_2776_암기왕 {

	static void input() throws Exception {

		// int t = scan.nextInt();
		// HashMap<Integer, Integer> map = new HashMap<>(1000000);
		// for (int i = 0; i < t; i++) {
		// 	map.clear();
		// 	int n = scan.nextInt();
		// 	for (int j = 0; j < n; j++) {
		// 		map.put(scan.nextInt(),0);
		// 	}
		// 	int m = scan.nextInt();
		// 	for (int j = 0; j < m; j++) {
		// 		sb.append(map.containsKey(scan.nextInt()) ? 1 : 0).append('\n');
		// 	}
		// }
		// print();

		// int t = scan.nextInt();
		// for (int i = 0; i < t; i++) {
		// 	int n = scan.nextInt();
		// 	int[] array = new int[n];
		// 	for (int j = 0; j < n; j++) {
		// 		array[j] = scan.nextInt();
		// 	}
		// 	Arrays.sort(array);
		// 	int m = scan.nextInt();
		// 	for (int j = 0; j < m; j++) {
		// 		sb.append(Arrays.binarySearch(array, scan.nextInt()) < 0 ? 0 : 1).append('\n');
		// 	}
		// }
		// print();

		int t = scan.nextInt();
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < t; i++) {
			set.clear();
			int n = scan.nextInt();
			for (int j = 0; j < n; j++) {
				set.add(scan.nextInt());
			}
			int m = scan.nextInt();
			for (int j = 0; j < m; j++) {
				sb.append(set.contains(scan.nextInt()) ? 1 : 0).append('\n');
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