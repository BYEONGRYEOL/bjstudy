package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_5691_평균중앙값문제 {

	static void input() throws Exception {
		// a, b
		// mean = (a+b+x) / 3
		// 
		// 3mid = 3mean = a+b+x
		// x = 3mid - a - b
		// if mid == x : x = (a+b)/2
		// if mid == a : x = 2a -b
		// if mid == b : x = 2b - a
		while (true) { 
			int[] array = new int[2];
			array[0] = scan.nextInt();
			array[1] = scan.nextInt();
			if(array[0]==0 && array[1]== 0){
				break;
			}
			Arrays.sort(array);
			System.out.println(2 * array[0] - array[1]);
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