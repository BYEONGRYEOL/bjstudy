package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class boj_13277_큰수곱셈 {

	static void input() throws Exception{
		String line = scan.nextLine();
		String a = line.split(" ")[0];
		String b = line.split(" ")[1];
		BigInteger aa = new BigInteger(a);
		BigInteger bb = new BigInteger(b);
		System.out.println(aa.multiply(bb));
	}
	// static int KARATSUBA_THRESHOLD = 80;
	// static int[] resultArray = new int[KARATSUBA_THRESHOLD + KARATSUBA_THRESHOLD];
	//
	// static void input() throws Exception {
	//
	// 	// Karatsuba 알고리즘
	// 	// 큰 수의 곱셈을 수행할 때, BigInteger 안에 내장되어있는 Karatsuba 알고리즘을 직접 구현한다.
	// 	// X * Y = (X1 * 10^m + X0) * (Y1 * 10^m + Y0)
	// 	// * 사람이 보기 편한 식       = X1 * Y1 * 10^(2m) + ((X1 * Y0 + X0 * Y1) * 10^m) + X0 * Y0
	// 	// * 재귀적으로 메모리를 덜 쓰도록 해야하는 식
	// 	// = X1 * Y1 * 10^(2m) + ((X1+X0)*(Y1*Y0) - X1Y1 - X0Y0) * 10^m  + X0Y0
	// 	// = P1*10^2m + P2*10^m + P3
	// 	// P1 = X1Y1
	// 	// P3 = X0Y0
	// 	// P2 = X1Y0 + X0Y1
	// 	//    = (X1+X0)*(Y1*Y0) - X1Y1 - X0Y0
	// 	//	  = (X1+X0)*(Y1*Y0) -   P1 -   P3
	//
	// 	String line = scan.nextLine();
	// 	String a = line.split(" ")[0];
	// 	String b = line.split(" ")[1];
	// 	List<Integer> numA = stringToList(a);
	// 	List<Integer> numB = stringToList(b);
	//
	// 	List<Integer> result = karatsuba(numA, numB);
	//
	// 	System.out.println(listToString(result));
	// }
	//
	// static List<Integer> karatsuba(List<Integer> a, List<Integer> b) {
	// 	int lenA = a.size();
	// 	int lenB = b.size();
	//
	// 	if (lenA <= KARATSUBA_THRESHOLD || lenB <= KARATSUBA_THRESHOLD) {
	// 		return multiply(a, b);
	// 	}
	//
	// 	int m = Math.max(lenA, lenB) / 2;
	//
	// 	List<Integer> X1 = a.subList(0, Math.max(0, lenA - m));
	// 	List<Integer> X0 = a.subList(Math.max(0, lenA - m), lenA);
	// 	List<Integer> Y1 = b.subList(0, Math.max(0, lenB - m));
	// 	List<Integer> Y0 = b.subList(Math.max(0, lenB - m), lenB);
	//
	// 	List<Integer> X1PlusX0 = plus(X1, X0);
	// 	List<Integer> Y1PlusY0 = plus(Y1, Y0);
	//
	// 	List<Integer> P1 = karatsuba(X1, Y1);
	// 	List<Integer> P3 = karatsuba(X0, Y0);
	// 	List<Integer> P2 = minus(minus(karatsuba(X1PlusX0, Y1PlusY0), P1), P3);
	//
	// 	return plus(plus(shiftLeft(P1, 2 * m), shiftLeft(P2, m)), P3);
	// }
	//
	// static List<Integer> plus(List<Integer> a, List<Integer> b) {
	// 	List<Integer> result = new ArrayList<>();
	// 	int carry = 0, maxLen = Math.max(a.size(), b.size());
	//
	// 	for (int i = 0; i < maxLen || carry > 0; i++) {
	// 		int digitA = i < a.size() ? a.get(i) : 0;
	// 		int digitB = i < b.size() ? b.get(i) : 0;
	//
	// 		int sum = digitA + digitB + carry;
	// 		result.add(sum % 10);
	// 		carry = sum / 10;
	// 	}
	// 	return result;
	// }
	//
	// static List<Integer> minus(List<Integer> a, List<Integer> b) {
	// 	List<Integer> result = new ArrayList<>();
	// 	int borrow = 0;
	//
	// 	for (int i = 0; i < a.size(); i++) {
	// 		int digitA = a.get(i);
	// 		int digitB = i < b.size() ? b.get(i) : 0;
	//
	// 		int diff = digitA - digitB - borrow;
	// 		if (diff < 0) {
	// 			diff += 10;
	// 			borrow = 1;
	// 		} else {
	// 			borrow = 0;
	// 		}
	// 		result.add(diff);
	// 	}
	//
	// 	// Remove leading zeros
	// 	while (result.size() > 1 && result.get(result.size() - 1) == 0) {
	// 		result.remove(result.size() - 1);
	// 	}
	// 	return result;
	// }
	//
	// static List<Integer> multiply(List<Integer> a, List<Integer> b) {
	// 	int[] resultArray = new int[a.size() + b.size()];
	//
	// 	for (int i = 0; i < a.size(); i++) {
	// 		for (int j = 0; j < b.size(); j++) {
	// 			resultArray[i + j] += a.get(i) * b.get(j);
	// 			resultArray[i + j + 1] += resultArray[i + j] / 10;
	// 			resultArray[i + j] %= 10;
	// 		}
	// 	}
	//
	// 	List<Integer> result = new ArrayList<>();
	// 	for (int digit : resultArray) {
	// 		result.add(digit);
	// 	}
	//
	// 	// Remove leading zeros
	// 	while (result.size() > 1 && result.get(result.size() - 1) == 0) {
	// 		result.remove(result.size() - 1);
	// 	}
	// 	return result;
	// }
	//
	// static List<Integer> shiftLeft(List<Integer> num, int n) {
	// 	List<Integer> result = new ArrayList<>(Collections.nCopies(n, 0));
	// 	result.addAll(num);
	// 	return result;
	// }
	//
	// static List<Integer> stringToList(String num) {
	// 	List<Integer> result = new ArrayList<>();
	// 	for (int i = num.length() - 1; i >= 0; i--) {
	// 		result.add(num.charAt(i) - '0');
	// 	}
	// 	return result;
	// }
	//
	// static String listToString(List<Integer> num) {
	// 	StringBuilder sb = new StringBuilder();
	// 	for (int i = num.size() - 1; i >= 0; i--) {
	// 		sb.append(num.get(i));
	// 	}
	// 	return sb.toString();
	// }

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