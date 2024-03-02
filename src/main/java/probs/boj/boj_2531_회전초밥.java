package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2531_회전초밥 {

	static void input() throws Exception {
		int N = scan.nextInt();
		int d = scan.nextInt();
		int k = scan.nextInt();
		int coupon = scan.nextInt();

		int count = 0;

		int eatenSushi[] = new int[d + 1];
		int[] sushi = new int[N];
		for (int i = 0; i < N; i++) {
			sushi[i] = scan.nextInt();
		}
		int l = 0;
		int r = l + k - 1;
		for (int i = l; i <= r; i++) {
			if (eatenSushi[sushi[i]] == 0) {
				count++;
			}
			eatenSushi[sushi[i]]++;
		}
		int maxCount = count;
		if (eatenSushi[coupon] == 0) {
			maxCount++;
		}
		while (l < N) {
			eatenSushi[sushi[l]]--;
			if (eatenSushi[sushi[l]] == 0)
				count--;
			l++;

			r++;
			r = r % N;
			if (eatenSushi[sushi[r]] == 0)
				count++;
			eatenSushi[sushi[r]]++;
			if (eatenSushi[coupon] == 0) {
				maxCount = Math.max(count + 1, maxCount);
			} else {
				maxCount = Math.max(count, maxCount);
			}
		}

		System.out.println(maxCount);
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