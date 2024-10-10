package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11282_한글 {

	static void input() throws Exception {
		int num = scan.nextInt();
		// 유니코드 상 '가'의 코드 값
		int baseCode = '가';

		// 초성, 중성, 종성 개수
		int numChosung = 19;
		int numJungsung = 21;
		int numJongsung = 28;

		// N번째 글자 구하기 (N은 1부터 시작한다고 가정)
		int N = num -1;

		// 초성, 중성, 종성 인덱스 계산
		int chosungIndex = N / (numJungsung * numJongsung);
		int jungsungIndex = (N % (numJungsung * numJongsung)) / numJongsung;
		int jongsungIndex = N % numJongsung;

		// 최종 유니코드 계산
		int finalCode = baseCode + (chosungIndex * numJungsung * numJongsung)
			+ (jungsungIndex * numJongsung)
			+ jongsungIndex;

		// 유니코드를 문자로 변환하여 출력
		System.out.println((char) finalCode);
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