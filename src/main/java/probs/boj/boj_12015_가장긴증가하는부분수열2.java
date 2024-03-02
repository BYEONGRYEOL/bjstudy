package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class boj_12015_가장긴증가하는부분수열2 {

	static void input() throws Exception {
		// 1의 경우보다 시간복잡도 측면에서 문제가 생겼다.
		// 절대 for문 2개로는 해결 못함
		// 최대 n * root n or nlogn 정도의 개선이 필요하다.

		// 1 2 5 3 4  수열에서 1,2,5 -> 1,2,3,4 로 변경되는 것을 구현해야함

		// 1 2 5 가 index가 2일 때의 가장 긴 수열이라고 아예 들고있어야한다?
		// index 3일때 3의 값을 만났을 때
		// 1 2 5 대신 1 2 3으로 수열을들고 있는게 합리적이다.
		// 1 2 5 7 3 4 6 의 경우

		// 1 2 5 7 에서 3을 만났을 때 1 2 3 7로 변경되어야함
		// 이분탐색으로 현재 수가 박힌 돌을 빼고 들어갈 자리를 찾는다.

		int n = scan.nextInt();
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = scan.nextInt();
		}

		List<Integer> list = new ArrayList<>();
		list.add(array[0]);
		for (int i = 1; i < n; i++) {
			if (list.get(list.size() - 1) < array[i]) {
				// 증가중
				list.add(array[i]);
			} else {
				int insertIndex = Collections.binarySearch(list, array[i]);
				// 만약 insertIndex가 양수라면 값을 찾았으니 상관없다.
				if (insertIndex < 0) {
					// 새로운 자리를 찾아 들어감
					// 1 2 5 인 상황에서 새로운 숫자가 3이라면,
					// 3을 찾지 못햇으므로 -1 - (2) 라는 값이 나옴
					insertIndex += 1;
					insertIndex *= -1;
					list.set(insertIndex, array[i]);
				}
			}
		}
		System.out.println(list.size());

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