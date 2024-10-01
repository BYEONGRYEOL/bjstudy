package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class boj_8437_Julka {

	static void input() throws Exception {
		String total = scan.nextLine();
		String diff = scan.nextLine();

		// 9802324
		// 482
		// 9802324 - 482 = 9801842
		String common = halfOf(minus(total, diff));
		System.out.println(minus(total ,common));
		System.out.println(common);
	}
	static String halfOf(String a){
		int[] resultArray = new int[a.length()+1];
		for (int i = 0; i < a.length(); i++) {
			int num = a.charAt(i) - '0';
			resultArray[i] += num / 2;
			if(num % 2 != 0 ){
				resultArray[i+1] +=5;
			}
		}
		String result = Arrays.stream(resultArray).mapToObj(String::valueOf).collect(Collectors.joining());
		if(result.charAt(0) == '0'){
			result = result.substring(1);
		}
		return result.substring(0, result.length()-1);
	}
	static String minus(String a, String b){
		List<Integer> result = new ArrayList<>();
		int lenA = a.length();
		int lenB = b.length();
		int borrow = 0;
		for (int i = 0; i < lenA; i++) {
			int aDigit = a.charAt(lenA -1 -  i) - '0';
			int bDigit = i < b.length() ? b.charAt(lenB - 1 - i) - '0' : 0;

			int minus = 0;
			if(aDigit - borrow < bDigit){
				minus = aDigit - borrow + 10 - bDigit;
				borrow = 1;
			} else{
				minus = aDigit - borrow - bDigit;
				borrow = 0;
			}
			result.add(minus);
		}
		while(result.size() > 1 && result.get(result.size() - 1) == 0 )
			result.remove(result.size()-1);
		return reverse(result).stream().map(String::valueOf).collect(Collectors.joining());
	}

	static List<Integer> reverse(List<Integer> a) {
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < a.size(); i++) {
			result.add(a.get(a.size() - 1 - i));
		}
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