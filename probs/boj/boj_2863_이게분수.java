package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2863_이게분수 {

	static void input() throws Exception {
		int[][] array = new int[2][2];
		for (int i = 0; i < 4; i++) {
			array[i / 2][i % 2] = scan.nextInt();
		}
		double maxVal = 0;
		double val;
		int maxIndex = 0;
		for (int i = 0; i < 4; i++) {
			val = calculate(array);
			if (maxVal < val) {
				maxVal = val;
				maxIndex = i;
			}
			array = rotate(array);
		}
		System.out.println(maxIndex);
	}

	static double calculate(int[][] arr) {
		return (double)arr[0][0] / arr[1][0] + (double)arr[0][1] / arr[1][1];
	}

	static void printArray(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	static int[][] rotate(int[][] arr) {
		int[][] resultArray = new int[arr.length][arr[0].length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				resultArray[j][arr.length - 1 - i] = arr[i][j];
			}
		}
		return resultArray;
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