package org.example;

import java.util.*;

class pgm_피로도 {
	public static int[] ORDER;
	public static boolean[] VISITED;
	public static int POSSIBLE_MAX;
	public static int[][] DUNGEONS;
	public static int K;
	public static int MAX_EXPLORE_COUNT;
	public int explore(){
		int tempK = K;
		int exploreCount = 0;
		for(int i = 0 ; i < DUNGEONS.length; i++){
			int index = ORDER[i];
			if(tempK >= DUNGEONS[index][0]){
				exploreCount++;
				tempK -= DUNGEONS[index][1];
			}
		}
		// System.out.println(exploreCount);
		return exploreCount;
	}
	public void permutation(boolean[] stop, int n,  int depth){
		if(stop[0]){
			return;
		}
		if(depth ==n){
			MAX_EXPLORE_COUNT = Math.max(MAX_EXPLORE_COUNT, explore());
			if(MAX_EXPLORE_COUNT == POSSIBLE_MAX){
				stop[0] = true;
				return;
			}
		}
		for(int i = 0; i < n ; i++){
			if(VISITED[i] == false){
				VISITED[i] = true;
				ORDER[depth] = i;
				permutation(stop, n, depth+1);
				VISITED[i] = false;
			}
		}

	}
	public int solution(int k, int[][] dungeons) {
		int answer = -1;
		int n = dungeons.length;
		K=k;
		// 던전의 수가 많아야 8,
		// 8!의 경우라면 충분히 전부 탐색할 수 있다.
		ORDER = new int[n];
		VISITED = new boolean[n];
		DUNGEONS = dungeons;
		Arrays.sort(dungeons, (a1,a2) -> a1[1] - a2[1]);
		int tempSum = 0;

		MAX_EXPLORE_COUNT = 0;
		POSSIBLE_MAX = n;
		for(int i = 0 ; i < n; i++){
			tempSum += DUNGEONS[i][1];
			if(tempSum > k){
				POSSIBLE_MAX = i;
			}
		}

		boolean[] stopFlag = new boolean[1];

		permutation(stopFlag, n, 0);

		return MAX_EXPLORE_COUNT;
	}
}