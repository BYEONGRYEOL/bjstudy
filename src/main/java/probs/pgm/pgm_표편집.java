package probs.pgm;

import java.util.Stack;

class pgm_표편집 {

	public class Node {
		Node prev;
		Node next;
		int value;

		public Node(int value) {
			this.value = value;
		}

		public Node remove() {
			prev.next = next;
			next.prev = prev;
			if (next.value == -1) {
				return prev;
			} else {
				return next;
			}
		}

		public void undo() {
			prev.next = this;
			next.prev = this;
		}

		public Node up(int num) {
			Node cur = this;
			for (int i = 0; i < num; i++) {
				cur = cur.prev;
			}
			return cur;
		}

		public Node down(int num) {
			Node cur = this;
			for (int i = 0; i < num; i++) {
				cur = cur.next;
			}
			return cur;
		}
	}

	public Node init(int n) {
		Node lDummy = new Node(-1);
		Node prevNode = lDummy;
		Node curNode = null;
		for (int i = 0; i < n; i++) {
			curNode = new Node(i);
			prevNode.next = curNode;
			curNode.prev = prevNode;
			prevNode = curNode;
		}
		Node rDummy = new Node(-1);
		curNode.next = rDummy;
		return lDummy.next;
	}

	public String solution(int n, int k, String[] commands) {
		Node cur = init(n);
		Node startNode = cur;
		Stack<Node> dNodeStack = new Stack<>();
		for (int i = 0; i < k; i++) {
			cur = cur.next;
		}
		int num = 0;
		for (String cmd : commands) {
			switch (cmd.charAt(0)) {
				case 'U':
					num = Integer.parseInt(cmd.substring(2));
					cur = cur.up(num);
					break;
				case 'D':
					num = Integer.parseInt(cmd.substring(2));
					cur = cur.down(num);
					break;
				case 'C':
					dNodeStack.push(cur);
					cur = cur.remove();
					break;
				case 'Z':
					dNodeStack.pop().undo();
					break;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append('0');
		}
		while (!dNodeStack.isEmpty()) {
			sb.setCharAt(dNodeStack.pop().value, 'X');
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String result = new pgm_표편집().solution(8, 2, new String[] {
			"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"
		});
	}
}