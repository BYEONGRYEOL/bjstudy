package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2805_나무자르기 {

	public static long calculateM(int cutter, int[] array) {
		long result = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > cutter)
				result += array[i] - cutter;
		}
		return result;
	}

	static void input() throws Exception {
		// 절단기 높이를 먼저 결정하면
		// 그에 맞는 X미터의 값이 나온다
		// X>M 절단기 높이를 높이고
		// X<M 절단기 높이를 낮춘다.
		// 낮은 절단기 높이에서 정답 발생

		int n = scan.nextInt();
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = scan.nextInt();
		}
		int target = scan.nextInt();

		int l = 0;
		int r = 1000000000;
		int m = 0;
		while (l + 1 < r) {
			m = (l + r) / 2;
			if (calculateM(m, array) >= target) {
				l = m;
			} else {
				r = m;
			}
		}
		System.out.println(l);
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