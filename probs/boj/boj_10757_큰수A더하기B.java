package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class boj_10757_큰수A더하기B {

	static void input() throws Exception {
		String prob = scan.nextLine();
		String a = prob.split(" ")[0];
		String b = prob.split(" ")[1];
		System.out.println(plus(a,b));
	}
	static String plus(String a, String b){
		int lenA = a.length();
		int lenB = b.length();
		int[] resultArray = new int[Math.max(lenA, lenB)+1];
		int carry = 0;
		for (int i = 0; i < resultArray.length; i++) {
			int digitA = i < lenA ? a.charAt(lenA - 1 -i) - '0' : 0;
			int digitB = i < lenB ? b.charAt(lenB - 1 -i) - '0' : 0;
			resultArray[resultArray.length - 1 - i] = (digitA + digitB + carry) % 10;
			carry = (digitA + digitB + carry) / 10;
		}
		String result = Arrays.stream(resultArray).mapToObj(String::valueOf).collect(Collectors.joining());
		if(result.charAt(0) == '0')
			result = result.substring(1);
		return result;
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