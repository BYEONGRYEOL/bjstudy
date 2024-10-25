package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class boj_11586_지영공주님의마법거울 {

	static void input() throws Exception {
		int n = scan.nextInt();
		String[] jiyeong = new String[n];
		for (int i = 0; i < n; i++) {
			jiyeong[i] = scan.nextLine();
		}
		StringBuilder sb2 = new StringBuilder();
		int type = scan.nextInt();
		if (type == 1) {
			Arrays.stream(jiyeong).forEachOrdered(System.out::println);
		} else if (type == 2) {
			Arrays.stream(jiyeong).forEachOrdered(e -> {
				System.out.println((sb2.append(e).reverse()));
				sb2.setLength(0);
			});
		} else if (type == 3) {
			IntStream.range(0, n).forEachOrdered(d -> System.out.println(jiyeong[n - 1 - d]));
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
	}

	public static void main(String[] args) throws Exception {
		input();
	}

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

}