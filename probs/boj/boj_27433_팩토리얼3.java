package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class boj_27433_팩토리얼3 {

	static void input() throws Exception {
		// 단순히 1부터 100000까지의 숫자를 곱하게 되면
		// 결과 숫자의 자릿수는 기하급수적으로 늘어나지만, 반복적으로 곱하는 자릿수는 6을 넘지않는다.
		// BigInteger의 곱셈의
		// private BigInteger multiply(BigInteger val, boolean isRecursion, boolean parallel, int depth) {
		//         if (val.signum == 0 || signum == 0)
		//             return ZERO;
		//
		//         int xlen = mag.length;
		//
		//         if (val == this && xlen > MULTIPLY_SQUARE_THRESHOLD) {
		//             return square(true, parallel, depth);
		//         }
		//
		//         int ylen = val.mag.length;
		//
		//         if ((xlen < KARATSUBA_THRESHOLD) || (ylen < KARATSUBA_THRESHOLD)) {
		//             int resultSign = signum == val.signum ? 1 : -1;
		//             if (val.mag.length == 1) {
		//                 return multiplyByInt(mag,val.mag[0], resultSign);
		//             }
		//             if (mag.length == 1) {
		//                 return multiplyByInt(val.mag,mag[0], resultSign);
		//             }
		//             int[] result = multiplyToLen(mag, xlen,
		//                                          val.mag, ylen, null);
		//             result = trustedStripLeadingZeroInts(result);
		//             return new BigInteger(result, resultSign);
		//         } else {
		//             if ((xlen < TOOM_COOK_THRESHOLD) && (ylen < TOOM_COOK_THRESHOLD)) {
		//                 return multiplyKaratsuba(this, val);
		
		// 기본적으로 80으로 설정되어있는 KARATSUBA_THRESHOLD 값 때문에 모든 곱셈이 학교에서 배운 수동 곱셈 으로 처리된다.
		// 따라서 BigInteger 를 사용하는 이점을 볼 수 없음
		// KARATSUBA 혹은 TOOMCOOK 알고리즘 등(지금은 알 필요 없지만)
		// 비슷한 자릿수끼리 곱하도록 하는것이 유리함
		System.out.println(fact(1, scan.nextInt()));
	}

	static BigInteger fact(int s, int e){
		if(s<e){
			int m = (s+e) / 2;
			return fact(s,m).multiply(fact(m+1, e));
		}
		return new BigInteger(String.valueOf(s));
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
