package probs.pgm;

import java.util.Arrays;

class pgm_숫자변환하기 {
	// "최소" 연산 횟수를 찾아야 하므로 bfs
	// 시간 초과가 난다. 왜 시간 초과가 나지?
	// x = 1, y = 1,000,000, n=1인 극단적인 경우를 커버하지 못함
	// dp문제인가?
	// 가능한 모든 state를 배열로 정의하는 dp 유형
	// 각 x에서 *2, *3, +n의 3개의 action을 수행하고 계속해서 최소 연산 횟수를 갱신해야함

	public int solution(int x, int y, int n) {
		int[] dp = new int[1000001];
		int maxValue = 1000001;
		Arrays.fill(dp, maxValue);

		dp[x] = 0;
		for (int i = x; i <= y; i++) {
			if (dp[i] != maxValue) { // 현재 수를 만드는게 가능했다면
				// 어레이 오버플로우 조심
				if (i + n < maxValue)
					dp[i + n] = Math.min(dp[i + n], dp[i] + 1);
				if (i * 2 < maxValue)
					dp[i * 2] = Math.min(dp[i * 2], dp[i] + 1);
				if (i * 3 < maxValue)
					dp[i * 3] = Math.min(dp[i * 3], dp[i] + 1);
			}
		}

		return dp[y] == maxValue ? -1 : dp[y];
	}
}