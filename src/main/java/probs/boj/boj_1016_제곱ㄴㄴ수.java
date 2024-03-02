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

public class boj_1016_제곱ㄴㄴ수 {

	static void input() throws Exception {
		long min = scan.nextLong();
		long max = scan.nextLong();

		// 2 3 5
		// 1000001000000
		int x = (int)Math.sqrt((double)(1000001000000L));
		boolean[] isPrime = new boolean[x + 1];
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;
		for (int i = 2; i < x + 1; i++) {
			if (!isPrime[i])
				continue;
			for (int j = i * 2; j < x + 1; j += i) {
				isPrime[j] = false;
			}
		}

		long[] squareOfPrime =
			IntStream.rangeClosed(2, x)
				.filter(i -> isPrime[i])
				.mapToLong(i -> (long)i * i)
				// .forEach(System.out::print);
				.toArray();

		boolean[] isPrime2 = new boolean[(int)(max - min + 1)];
		Arrays.fill(isPrime2, true);
		for (int i = 0; i < squareOfPrime.length; i++) {
			long number = (long)(Math.ceil(min / (double)squareOfPrime[i]) * squareOfPrime[i]);
			while (number <= max) {
				isPrime2[(int)(number - min)] = false;
				number += squareOfPrime[i];
			}
		}
		System.out.println(IntStream.range(0, isPrime2.length).filter(i -> isPrime2[i]).count());
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