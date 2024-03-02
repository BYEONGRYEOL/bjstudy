package probs.pgm;

import java.util.HashSet;
import java.util.Set;

class pgm_소수찾기 {
	static int N;
	static boolean[] VISITED;
	String NUMBERS = "";
	String RESULT = "";
	Set<Integer> results;

	public void dfs(int depth) {
		if (depth == N) {
			if (RESULT.isEmpty() == false) {
				results.add(Integer.parseInt(RESULT));
			}
			return;
		}
		dfs(depth + 1);
		for (int i = 0; i < N; i++) {
			if (VISITED[i] == false) {
				VISITED[i] = true;
				RESULT += NUMBERS.charAt(i);
				dfs(depth + 1);
				RESULT = RESULT.substring(0, RESULT.length() - 1);
				VISITED[i] = false;
			}
		}
	}

	public int countPrime() {
		int n = results.size();
		int maxLen = 10000000;
		boolean[] notPrime = new boolean[maxLen];
		notPrime[0] = true;
		notPrime[1] = true;
		for (int i = 2; i < maxLen; i++) {
			if (!notPrime[i]) {
				for (int j = i * 2; j < maxLen; j = j + i) {
					notPrime[j] = true;
				}
			}
		}
		return (int)results.stream().filter(i -> !notPrime[i]).count();
	}

	public int solution(String numbers) {
		NUMBERS = numbers;
		N = numbers.length();
		VISITED = new boolean[N];
		results = new HashSet<>();
		dfs(0);
		return countPrime();
	}
}