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

public class boj_14725_개미굴 {
	static String[] depthStr = new String[]{
		"",
		"--",
		"----",
		"------",
		"--------",
		"----------",
		"------------",
		"--------------",
		"----------------",
		"------------------",
		"--------------------",
		"----------------------",
		"------------------------",
		"--------------------------",
		"----------------------------",
		"------------------------------"
	};
	static class Node implements Comparable<Node>{
		String value;
		List<Node> childs;

		public Node(String value){
			this.value = value;
			childs = new ArrayList<>();
		}

		public Node addChild(String value){
			for (Node child : childs) {
			    if(child.value.equals(value)){
					return child;
				}
			}
			Node newChild =new Node(value);
			childs.add(newChild);
			return newChild;
		}

		@Override
		public int compareTo(Node o) {
			return this.value.compareTo(o.value);
		}
	}
	static void input() throws Exception {
		int n = scan.nextInt();
		Node dummyRoot = new Node("dummy");
		Node cur = dummyRoot;
		for (int i = 0; i < n; i++) {
			cur = dummyRoot;
			String line = scan.nextLine();
			String[] lineArray = line.split(" ");
			for (int j = 1; j < lineArray.length; j++) {
				cur = cur.addChild(lineArray[j]);
			}
		}
		Collections.sort(dummyRoot.childs);
		for (int i = 0; i < dummyRoot.childs.size(); i++) {
			searchAsc(dummyRoot.childs.get(i), 0);
		}
		print();
	}

	static void searchAsc(Node node, int depth){
		sb.append(depthStr[depth]).append(node.value).append('\n');
		Collections.sort(node.childs);
		for (int i = 0; i < node.childs.size(); i++) {
			searchAsc(node.childs.get(i), depth+1);
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