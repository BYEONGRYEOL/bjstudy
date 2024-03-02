package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_18258_queue2 {
	static void input() throws Exception {
		int operationCount = scan.nextInt();
		// 간단한 데크 자료구조 문제인데,
		// deque
		// 4 3 1
		// 앞뒤로 add, pop, peek이 가능한 데크로 풀면 너무 쉬우니까 큐로 풀면서
		// 4바이트짜리 캐시 메모리 느낌으로 최근에 push한 수를 들고 있다가 back 연산할떄 쓰자
		Queue<Integer> q = new LinkedList<>();
		int recentPushedNumber = -1;
		for (int z = 0; z < operationCount; z++) {
			String[] operation = scan.nextLine().split(" ");
			if (operation[0].equals("push")) {
				recentPushedNumber = Integer.parseInt(operation[1]);
				q.add(recentPushedNumber);
			} else if (operation[0].equals("pop")) {
				if (q.isEmpty())
					sb.append(-1).append('\n');
				else
					sb.append(q.poll()).append('\n');
			} else if (operation[0].equals("size"))
				sb.append(q.size()).append('\n');
			else if (operation[0].equals("empty"))
				sb.append(q.isEmpty() ? 1 : 0).append('\n');
			else if (operation[0].equals("front")) {
				if (q.isEmpty())
					sb.append(-1).append('\n');
				else
					sb.append(q.peek()).append('\n');
			} else if (operation[0].equals("back")) {
				if (q.isEmpty())
					sb.append(-1).append('\n');
				else
					sb.append(recentPushedNumber).append('\n');
			}

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