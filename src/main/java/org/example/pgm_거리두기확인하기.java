package org.example;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class pgm_거리두기확인하기 {
	int N;
	int M;
	boolean checkDistance(int sx,int sy , String[] places){
		int[] dirx = new int[] {-1, 0, 1};
		int[] diry = new int[] {0, 1, 0};
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		q.add(new int[]{sx,sy,0});
		while(!q.isEmpty()){
			int[] now = q.poll();
			int x = now[0];
			int y = now[1];
			int d = now[2];
			visited[x][y] = true;
			if(d == 2){
				continue;
			}
			for(int k= 0 ; k < 3; k ++){
				int newx = x +dirx[k];
				int newy = y + diry[k];
				if(newx >=0 && newx < N && newy >= 0 && newy < M){
					char next = places[newx].charAt(newy);
					if(visited[newx][newy]){
						continue;
					}
					if(next == 'X'){
						continue;
					}
					if(next == 'P'){
						return false;
					} else{
						q.add(new int[]{newx,newy,d+1});
					}
				}
			}
		}
		return true;
	}

	public int[] solution(String[][] places) {
		int T = places.length;
		int[] answer = new int[T];
		Arrays.fill(answer, 1);
		N = places[0].length;
		M = places[0][0].length();
		for(int t = 0 ; t < T ; t++){
			for(int i = 0; i < N; i++){
				for(int j = 0 ; j < M; j++){
					if(places[t][i].charAt(j) == 'P'){
						if(checkDistance(i,j,places[t]) == false){
							answer[t] = 0;
						}
					}
				}
			}
		}

		return answer;
	}
}