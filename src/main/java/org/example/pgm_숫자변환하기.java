package org.example;

import java.util.*;
class pgm_숫자변환하기 {
	// dfs방식은 n이 1이고 x와 y가 차이가 엄청 큰 케이스를 커버하지 못한다.
	// 런타임에러 시간초과 등등 다양함
	// 최소의 연산횟수일때 바로 찾아야하므로 bfs?
	// bfs도 똑같이 에러난다 개선은 좀 되었지만
	// dp???

	public int solution(int x, int y, int n) {
		int[] dp = new int[1000001];
		int maxValue = 1000001;
		Arrays.fill(dp, maxValue);

		dp[x] = 0;
		for(int i = x; i <= y ; i++){
			if(dp[i] != maxValue){ // 현재 수를 만드는게 가능했다면
				// 어레이 오버플로우 조심
				if(i+n < maxValue)
					dp[i+n] = Math.min(dp[i+n], dp[i] + 1);
				if(i*2 < maxValue)
					dp[i*2] = Math.min(dp[i*2], dp[i] + 1);
				if(i*3 < maxValue)
					dp[i*3] = Math.min(dp[i*3], dp[i] + 1);
			}
		}

		return dp[y] == maxValue ? -1 : dp[y];
	}
}