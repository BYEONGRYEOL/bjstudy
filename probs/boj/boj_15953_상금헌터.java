package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_15953_상금헌터 {


	static void input() throws Exception {
		int iter = scan.nextInt();
		int[] aPriceCriteria = {1,3,6,10,15,21};
		int[] aPrice = {500,300,200,50,30,10};
		int[] bPriceCriteria = {1,3,7,15,31};
		int[] bPrice = {512,256,128,64,32};
		for (int i = 0; i < iter; i++) {
			int aRank = scan.nextInt();
			int bRank = scan.nextInt();
			if(aRank == 0) aRank = 101;
			if(bRank == 0) bRank = 101;
			int totalPrice = 0;
			for (int j = 0; j< aPriceCriteria.length; j++) {
				if(aPriceCriteria[j] >= aRank){
					totalPrice += aPrice[j] * 10000;
					break;
				}
			}
			for (int j = 0; j < bPriceCriteria.length; j++) {
				if(bPriceCriteria[j] >= bRank){
					totalPrice += bPrice[j] * 10000;
					break;
				}
			}
			sb.append(totalPrice).append('\n');
		}
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