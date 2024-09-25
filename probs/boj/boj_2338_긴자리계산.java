package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2338_긴자리계산 {

	static void input() {
		String a = scan.nextLine();
		String b = scan.nextLine();
		boolean aIsPlus = a.charAt(0) == '-';
		boolean bIsPlus = b.charAt(0) == '-';

		String plus = "";
		String minus = "";
		if(aIsPlus && bIsPlus){
			plus = plus(a, b);
			minus = minus(a,b);
		} else if(aIsPlus && bIsPlus == false){
			plus = minus(a,b);
			minus = plus(a,b);
		} else if(aIsPlus == false && bIsPlus){
			plus = 
		}
		
		print();
	}


	static String plus(String a, String b){
		int maxLen = Math.max(a.length(), b.length());
		StringBuilder result = new StringBuilder();

		int carry = 0;
		for(int i = maxLen-1 ; i >=0; i--){
			int aDigit = a.length() <= i ? 0 : a.charAt(i)-'0';
			int bDigit = b.length() <= i ? 0 : b.charAt(i)-'0';
			
			result.append((aDigit + bDigit + carry) % 10);
			if(aDigit + bDigit + carry >= 10){
				carry = 1;
			} else{
				carry = 0;
			}
		
		}
		
		result.reverse();
		if(result.charAt(0) == '0'){
			result.deleteCharAt(0);
		}
		return result.toString();
	}
	static String minus(String a, String b){
		int maxLen = Math.max(a.length(), b.length());
		StringBuilder result = new StringBuilder();

		int borrow = 0;
		for(int i = maxLen-1 ; i >=0; i--){
			int aDigit = a.length() <= i ? 0 : a.charAt(i)-'0';
			int bDigit = b.length() <= i ? 0 : b.charAt(i)-'0';
			
			if(aDigit - borrow < bDigit){
				result.append(aDigit - borrow + 10 - bDigit);
				borrow = 1;
			} else{
				result.append(aDigit - borrow - bDigit);
				borrow = 0;
			}
		
		}
		
		result.reverse();
		while(result.charAt(0) == '0'){
			result.deleteCharAt(0);
		}
		return result.toString();
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

	public static void main(String[] args) {
		input();
	}

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

}