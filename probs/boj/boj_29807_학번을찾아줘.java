package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_29807_학번을찾아줘 {
	static int 국어 = 0;
	static int 수학 = 1;
	static int 영어 = 2;
	static int 탐구 = 3;
	static int 외	= 4;
	static void input() throws Exception {
		int T = scan.nextInt();
		int[] score = new int[5];
		for (int i = 0; i < T; i++) {
			score[i] = scan.nextInt();
		}
		int realScore = 0;
		int 국어빼기영어 = score[국어] - score[영어];
		int 수학빼기탐구 = score[수학] - score[탐구];
		if(국어빼기영어 > 0){
			realScore += 국어빼기영어 * 508;
		} else{
			realScore += -1 * 국어빼기영어 * 108;
		}
		if(수학빼기탐구 > 0){
			realScore += 수학빼기탐구 * 212;
		} else{
			realScore += -1 * 수학빼기탐구 * 305;
		}
		if(score.length == 5){
			realScore += score[외] * 707;
		}
		System.out.println(realScore * 4763);
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