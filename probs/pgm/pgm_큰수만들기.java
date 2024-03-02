package probs.pgm;

import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.Collectors;

class pgm_큰수만들기 {
	public String solution(String number, int k) {
		String answer = "";
		int n = number.length();
		Deque<Integer> deque = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			int now = (number.charAt(i) - '0');
			while (!deque.isEmpty() && deque.peekLast() < now && k > 0) {
				deque.pollLast();
				k--;
			}
			deque.add(now);
		}
		return deque.stream().map(String::valueOf).limit(n - k).collect(Collectors.joining());
	}
}