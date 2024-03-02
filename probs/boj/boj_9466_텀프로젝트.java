package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_9466_텀프로젝트 {

	static void input() {
		int caseNum = scan.nextInt();
		boolean visited[] = new boolean[100001];
		int array[] = new int[100001];
		int inDegree[] = new int[100001];
		Queue<Integer> q = new LinkedList<>();
		for (int z = 0; z < caseNum; z++) {
			int n = scan.nextInt();
			Arrays.fill(inDegree, 0);
			for (int i = 1; i <= n; i++) {
				array[i] = scan.nextInt();
				inDegree[array[i]]++;
			}
			// inDegree가 0인 학생은 팀을 이룰 수 없음
			// inDegree==0이 가리키는 학생도 팀을 이룰 수 없음?

			// 1->3
			// 2->1
			// 3->3
			// 4->7
			// 5->3
			// 6->4
			// 7->6

			// 사이클이 발생한 경우에만 한 조가 된다
			// 본인을 선택한 경우도 사이클
			// 탐색중 가능한 시나리오
			// 1 -> 2 -> 3-> 5-> 8-> 3 이라면, 1,2는 버려지고, 358끼리는 팀을 맺어야한다.
			// 1, 2를 어떻게 걸러내지?

			for (int i = 1; i <= n; i++) {
				if (inDegree[i] == 0)
					q.add(i);
			}

			int deletedCount = 0;
			while (!q.isEmpty()) {
				int now = q.poll();
				deletedCount++;
				inDegree[array[now]]--;
				if (inDegree[array[now]] == 0)
					q.add(array[now]);
			}
			sb.append(deletedCount).append('\n');
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

	public static void main(String[] args) {
		input();
	}

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

}