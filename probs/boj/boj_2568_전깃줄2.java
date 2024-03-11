package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class boj_2568_전깃줄2 {

	static void input() throws Exception {
		int n = scan.nextInt();
		int[][] array = new int[n][2];
		for (int i = 0; i < n; i++) {
			array[i][0] = scan.nextInt();
			array[i][1] = scan.nextInt();
		}
		Arrays.sort(array, Comparator.comparingInt(a -> a[0]));

		List<Integer> lis = new ArrayList<>();
		lis.add(Integer.MIN_VALUE);
		int[] pos = new int[n];
		Arrays.fill(pos, -1);

		for (int i = 0; i < n; i++) {
			if (lis.get(lis.size() - 1) < array[i][1]) {
				lis.add(array[i][1]);
				pos[i] = lis.size() - 1;
			} else if (lis.get(lis.size() - 1) > array[i][1]) {
				int index = Collections.binarySearch(lis, array[i][1]);
				index = (index + 1) * -1;
				pos[i] = index;
				lis.set(index, array[i][1]);
			}
		}
		int len = lis.size() - 1;
		sb.append(n - len).append('\n');
		List<Integer> toCut = new ArrayList<>();

		for (int i = n - 1; i >= 0; i--) {
			if (pos[i] == len) {
				len--;
			} else {
				toCut.add(array[i][0]);
			}
		}
		for (int i = toCut.size() - 1; i >= 0; i--) {
			sb.append(toCut.get(i)).append('\n');
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