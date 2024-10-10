package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_17256_달달함이넘쳐흘러 {

	static void input() throws Exception {
		// a cake b =a.z + b.x, a.y × b.y, a.x + b.z = c
		// c.x = a.z + b.x
		// c.y = a.y * b.y
		// c.z = a.x + b.z

		int[] a = new int[3];
		int[] c = new int[3];
		for (int i = 0; i < 3; i++) {
			a[i] = scan.nextInt();
		}
		for (int i = 0; i < 3; i++) {
			c[i] = scan.nextInt();
		}
		int bx= c[0] - a[2];
		int by = c[1] / a[1];
		int bz = c[2] - a[0];
		System.out.printf("%d %d %d%n", bx, by, bz);
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