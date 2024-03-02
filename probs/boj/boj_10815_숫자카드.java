package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_10815_숫자카드 {

	static void input() {
		int n = scan.nextInt();
		int[] existCards = new int[n];
		for (int i = 0; i < n; i++) {
			existCards[i] = scan.nextInt();
		}
		Arrays.sort(existCards);

		int m = scan.nextInt();
		for (int i = 0; i < m; i++) {
			int check = scan.nextInt();
			sb.append(binarySearch(existCards, check) ? 1 : 0).append(' ');
		}
		print();
	}

	static boolean binarySearch(int[] array, int key) {
		int l = 0;
		int r = array.length - 1;
		int m = 0;
		while (l < r) {
			m = (l + r) / 2;
			if (array[m] == key) {
				return true;
			} else if (array[m] < key) {
				l = m + 1;
			} else {
				r = m - 1;
			}
		}
		return false;
	}

	static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
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

	public static void main(String[] args) {
		input();
	}

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();
}