package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class boj_9610_사분면 {

	static void solve() {
		int iter= scan.nextInt();
		int[] pointCount = new int[5];
		for (int i = 0; i < iter; i++) {
			int x= scan.nextInt();
			int y= scan.nextInt();
			if(x>0 && y > 0)
				pointCount[0]++;
			else if(x <0 && y > 0)
				pointCount[1]++;
			else if(x < 0 && y < 0)
				pointCount[2]++;
			else if(x >0 && y < 0)
				pointCount[3]++;
			else pointCount[4]++;
		}
		for (int i = 0; i < 4; i++) {
			sb.append(String.format("Q%d: %d", i+1, pointCount[i])).append("\n");
		}
		sb.append("AXIS: ").append(pointCount[4]);
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
		solve();
		print();
	}

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

}