package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class boj_1271_엄청난부자2 {

	static void input() throws Exception {
		String nm = scan.nextLine();
		String n = nm.split(" ")[0];
		String m = nm.split(" ")[1];
		int[] dividend = toIntArray(n);
		int[] divisor = toIntArray(m);
		List<Integer> Q = new ArrayList<>();
		List<Integer> tempDividened = new ArrayList<>();

		// 문자 정수의 뺄셈 로직
		for (int i = 0; i < dividend.length; i++) {
			tempDividened.add(dividend[i]);
			if (smaller(tempDividened, divisor)) {
				// System.out.println("나눌 수 없음");
				if (!Q.isEmpty())
					Q.add(0);
				while(!tempDividened.isEmpty() && tempDividened.get(0) == 0) {
					tempDividened.remove(0);
				}
			} else {
				int tempQ = 0;
				while (!smaller(tempDividened, divisor)) {
					tempQ++;
					tempDividened = subtract(tempDividened, divisor);
				}
				Q.add(tempQ);
			}
			// System.out.println("Q = " + Q);
			// System.out.println("tempDividened = " + tempDividened);
		}
		if (Q.isEmpty()) {
			Q.add(0);
		}
		String q = intArrayToString(Q);
		while(!tempDividened.isEmpty() && tempDividened.get(0) == 0) {
			tempDividened.remove(0);
		}
		if (tempDividened.isEmpty()) {
			tempDividened.add(0);
		}

		String r = intArrayToString(tempDividened);
		sb.append(q).append('\n').append(r);
		print();
	}

	static int[] toIntArray(String a) {
		int[] result = new int[a.length()];
		for (int i = 0; i < result.length; i++) {
			result[i] = a.charAt(i) - '0';
		}
		return result;
	}

	static String intArrayToString(List<Integer> a) {
		return a.stream().map(String::valueOf).collect(Collectors.joining());
	}

	static boolean smaller(List<Integer> a, int[] b) {
		int aLen = a.size();
		int bLen = b.length;
		if (aLen != bLen) {
			return aLen < bLen;
		} else {
			for (int i = 0; i < aLen; i++) {
				if (a.get(i) != b[i]) {
					return a.get(i) < b[i];
				}
			}
		}
		return false;
	}

	static List<Integer> subtract(List<Integer> a, int[] b) {
		List<Integer> result = new ArrayList<>();
		int borrow = 0;
		int alen = a.size();
		int blen = b.length;

		for (int i = 0; i < alen; i++) {
			int adigit = a.get(alen - 1 - i);
			int bdigit = (i < blen) ? b[blen - 1 - i] : 0;

			adigit -= borrow;
			int diff = 0;
			if (adigit < bdigit) {
				diff = adigit + 10 - bdigit;
				borrow = 1;
			} else {
				diff = adigit - bdigit;
				borrow = 0;
			}
			result.add(diff);
		}

		while (!result.isEmpty() && result.get(result.size() - 1) == 0) {
			result.remove(result.size() - 1);
		}
		// System.out.println("result.reversed() = " + result.reversed());
		if(result.isEmpty()){
			return new ArrayList<>();
		}
		List<Integer> e = new ArrayList<>();
		for(int i = 0 ; i < result.size() ; i++) {
			e.add(result.get(result.size()-1-i));
		}
		return e;
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