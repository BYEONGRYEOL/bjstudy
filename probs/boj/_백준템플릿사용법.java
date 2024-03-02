package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _백준템플릿사용법 {

	static void input() throws Exception {
		// 실행하신다음에 아래 주석 4줄 입력하시면 이해가 되실겁니다

		// 1
		// 9000000000000000000
		// nextLine nextLine
		// next next

		// int 형 숫자 입력
		int integer = scan.nextInt();
		// long 형식 숫자 입력
		long mylong = scan.nextLong();
		// 한 줄 입력 받기
		String line = scan.nextLine();
		// 별로 쓸일 없음 : 띄어쓰기를 구분하여 한 단어를 출력합니다.
		String line2 = scan.next();

		// 한줄 씩 넘기면서 출력해야 하는 경우
		sb.append(integer).append('\n');
		sb.append(mylong).append('\n');
		sb.append(line).append('\n');
		sb.append(line2);

		sb.append('\n');

		// 한 칸씩 띄워서 출력해야 하는 경우

		sb.append(integer).append(' ');
		sb.append(mylong).append(' ');
		sb.append(line).append(' ');
		sb.append(line2);

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