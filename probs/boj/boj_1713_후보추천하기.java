package probs.boj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1713_후보추천하기 {

	static class Picture implements Comparable<Picture> {
		int createAt;
		int thumbs;
		int number;

		public Picture(int number, int createAt) {
			this.createAt = createAt;
			this.number = number;
			this.thumbs = 1;
		}

		public void addThumbs() {
			this.thumbs++;
		}

		@Override
		public int compareTo(Picture o) {
			return this.thumbs == o.thumbs ? this.createAt - o.createAt : this.thumbs - o.thumbs;
		}
	}

	static void input() throws Exception {
		int n = scan.nextInt();
		int m = scan.nextInt();
		PriorityQueue<Picture> pq = new PriorityQueue<>();
		Queue<Picture> tempQ = new LinkedList<>();
		int[] thumbs = new int[101];
		for (int i = 0; i < m; i++) {
			int number = scan.nextInt();
			if (pq.size() < n) {
				if (thumbs[number] > 0) {
					addThumbs(pq, number, tempQ);
				} else {
					pq.add(new Picture(number, i));
				}
				thumbs[number]++;
			} else {
				if (thumbs[number] > 0) {
					thumbs[number]++;
					addThumbs(pq, number, tempQ);
				} else {
					Picture now = pq.poll();
					thumbs[now.number] = 0;
					thumbs[number]++;
					pq.add(new Picture(number, i));
				}
			}
		}
		for (int i = 0; i < 101; i++) {
			if (thumbs[i] > 0) {
				sb.append(i).append(' ');
			}
		}

		print();
	}

	private static void printArray(int[] arr) {
		Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
		System.out.println();
	}

	private static void addThumbs(PriorityQueue<Picture> pq, int number, Queue<Picture> tempQ) {
		while (true) {
			Picture now = pq.poll();
			if (now.number == number) {
				now.addThumbs();
				pq.add(now);
				break;
			} else {
				tempQ.add(now);
			}
		}
		while (!tempQ.isEmpty()) {
			pq.add(tempQ.poll());
		}
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