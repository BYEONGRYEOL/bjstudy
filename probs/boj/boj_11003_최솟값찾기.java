package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class boj_11003_최솟값찾기 {

	static void addData(Deque<int[]> deque, int[] data) {
		while (deque.isEmpty() == false && deque.peekLast()[0] > data[0]) {
			deque.pollLast();
		}
		deque.addLast(data);
	}

	static void printMin(Deque<int[]> deque, int index, int l) {
		if (deque.peekFirst()[1] + l <= index)
			deque.pollFirst();
		sb.append(deque.peekFirst()[0]).append(' ');
	}

	static void input() throws Exception {
		// 1 5 2 4 3 7
		// 우선순위 큐를 사용하면 매 add함수에 log N 연산을 진행하다보니 불필요하게 정렬된다.
		// 슬라이딩 윈도우를 사용하면 될 것 같은데 뭔가 애매한 경우이ㅏㅁ
		// 뭐가 애매하냐면
		// 검사를 진행하면서 r++, l++ 한칸씩 shift하면서 잘 간다.
		// 현재 들고 있는 최솟값 min이 이제는 검사구역을 벗어나는 l의 값과 같다면?
		// 다시 새롭게 윈도우 내의 최솟값을 찾는다??

		//이럴 때는 인덱싱 트릭과 유망하지 않은 후보는 애초에 추가하지 않는 방식으로 데크를 사용해야한다.

		Deque<int[]> deque = new LinkedList<>();
		int N = scan.nextInt();
		int L = scan.nextInt();

		for (int i = 0; i < N; i++) {
			addData(deque, new int[] {scan.nextInt(), i});
			printMin(deque, i, L);
		}
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