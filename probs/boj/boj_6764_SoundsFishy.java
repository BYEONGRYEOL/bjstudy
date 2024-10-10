package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_6764_SoundsFishy {

	static void input() throws Exception {

		int[] arr = new int[4];
		for (int i = 0; i < 4; i++) {
			arr[i] = scan.nextInt();
		}

		if(arr[0] > arr[1] && arr[1] > arr[2] && arr[2] > arr[3]) {
			sb.append("Fish Diving");
		} else if (arr[0] < arr[1] && arr[1] < arr[2] && arr[2] < arr[3]) {
			sb.append("Fish Rising");
		} else if (arr[0] == arr[1] && arr[1] == arr[2] && arr[2] == arr[3]) {
			sb.append("Fish At Constant Depth");
		} else
			sb.append("No Fish");
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