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
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class boj_2338_긴자리계산 {

	// a+b = c
	// a+(-b) = +-c
	// a-b = +-c
	// a-(-b) = c
	// -a+b = +-c
	// -a+(-b) = -c
	// -a-b = -c
	// -a-(-b) = +-c
	// a*b = c
	// a*(-b) = -c
	// -a*b = -c
	// -a*(-b) = c
	// c<0 then c = "-"+c;
	// c = 000?? then c = ??
	// c = -0 then c = 0
	static void input() {
		String a = scan.nextLine();
		String b = scan.nextLine();
		boolean aIsPlus = a.charAt(0) != '-';
		boolean bIsPlus = b.charAt(0) != '-';
		if (!aIsPlus) {
			a = a.substring(1);
		}
		if (!bIsPlus) {
			b = b.substring(1);
		}
		String plus = "";
		String minus = "";
		String multiply = "";
		if (aIsPlus && bIsPlus) {
			plus = plus(a, b);
			minus = minus(a, b);
			multiply = multiply(a, b);
		} else if (aIsPlus && bIsPlus == false) {
			plus = minus(a, b);
			minus = plus(a, b);
			multiply = "-" + multiply(a, b);
		} else if (aIsPlus == false && bIsPlus) {
			plus = minus(b, a);
			minus = "-" + plus(a, b);
			multiply = "-" + multiply(a, b);
		} else {
			plus = "-" + plus(a, b);
			minus = minus(b, a);
			multiply = multiply(a, b);
		}
		if(Objects.equals(plus, "-0")){
			plus = "0";
		}
		if(Objects.equals(minus, "-0")){
			plus = "0";
		}
		if(Objects.equals(multiply, "-0")){
			plus = "0";
		}
		sb.append(plus).append('\n').append(minus).append('\n').append(multiply);
		print();
	}

	static boolean smaller(String a, String b) {
		int alen = a.length();
		int blen = b.length();
		if (alen == blen) {
			for (int i = 0; i < alen; i++) {
				if (a.charAt(i) != b.charAt(i)) {
					return a.charAt(i) < b.charAt(i);
				}
			}
		} else {
			return alen < blen;
		}
		return false;
	}

	// 938 * 101
	// 938
	//
	// 938
	static String multiply(String a, String b) {
		int[] result = new int[a.length() + b.length()];
		for (int i = 0; i < a.length(); i++) {
			int aDigit = a.charAt(i) - '0';
			for(int j = 0; j < b.length(); j++) {
				int bDigit = b.charAt(j) - '0';
				int temp = aDigit * bDigit;
				result[i + j] += temp /10 ;
				result[i+j+1] += temp % 10;
			}
		}
		for (int i = 0; i < result.length-1; i++) {
			if(result[result.length-1-i] > 9){
				result[result.length-2-i] += result[result.length-1-i]/10;
				result[result.length-1-i] = result[result.length-1-i]%10;
			}
		}

		List<Integer> R = Arrays.stream(result).boxed().collect(Collectors.toList());
		while(R.size() > 1 && R.get(0) == 0)
			R.remove(0);
		return R.stream().map(String::valueOf).collect(Collectors.joining());
	}

	static String plus(String a, String b) {
		int maxLen = Math.max(a.length(), b.length());
		List<Integer> result = new ArrayList<>();

		int carry = 0;
		for (int i =0; i < maxLen; i++) {
			int aDigit = a.length() <= i ? 0 : a.charAt(a.length() - 1 - i) - '0';
			int bDigit = b.length() <= i ? 0 : b.charAt(b.length() - 1 - i) - '0';

			result.add((aDigit + bDigit + carry) % 10);
			if (aDigit + bDigit + carry >= 10) {
				carry = 1;
			} else {
				carry = 0;
			}

		}
		if(carry == 1){
			result.add(1);
		}

		while(result.size()>1 && result.get(result.size() - 1) == 0) {
			result.remove(result.size() - 1);
		}
		result = reverse(result);
		return ArrayListToString(result);
	}

	static String ArrayListToString(List<Integer> a) {
		return a.stream().map(String::valueOf).collect(Collectors.joining());
	}

	static List<Integer> reverse(List<Integer> a) {
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < a.size(); i++) {
			result.add(a.get(a.size() - 1 - i));
		}
		return result;
	}

	static String minus(String a, String b) {
		String minus = "";
		if (smaller(a, b)) {
			String temp = b;
			b = a;
			a = temp;
			minus = "-";
		}
		int maxLen = Math.max(a.length(), b.length());
		List<Integer> result = new ArrayList<>();

		int borrow = 0;
		for (int i =0; i < maxLen; i++) {
			int aDigit = a.length() <= i ? 0 : a.charAt(a.length()-1-i) - '0';
			int bDigit = b.length() <= i ? 0 : b.charAt(b.length()-1-i) - '0';

			if (aDigit - borrow < bDigit) {
				result.add(aDigit - borrow + 10 - bDigit);
				borrow = 1;
			} else {
				result.add(aDigit - borrow - bDigit);
				borrow = 0;
			}

		}

		while (result.size()>1 && result.get(result.size() - 1) == 0) {
			result.remove(result.size() - 1);
		}
		result = reverse(result);
		return minus +ArrayListToString(result);
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