package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_6778_WhichAlien {

	static void input() throws Exception {
		//TroyMartian, who has at least 3 antenna and at most 4 eyes;
		// VladSaturnian, who has at most 6 antenna and at least 2 eyes;
		// GraemeMercurian, who has at most 2 antenna and at most 3 eyes.
		int antenna = scan.nextInt();
		int eyes = scan.nextInt();
		if(antenna >= 3 && eyes <=4)
			sb.append("TroyMartian").append('\n');
		if(antenna <= 6 && eyes >= 2)
			sb.append("VladSaturnian").append('\n');
		if(antenna <=2 && eyes <=3)
			sb.append("GraemeMercurian").append('\n');
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