package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class pgm_배달 {
	public int solution(int N, int[][] road, int K) {
		int answer = 0;
		ArrayList<int[]>[] edges = new ArrayList[N+1];
		for(int i = 0 ; i < N+1; i ++){
			edges[i] = new ArrayList<>();
		}
		for(int[] r : road){
			int s = r[0];
			int e = r[1];
			int v = r[2];
			edges[s].add(new int[]{e,v});
			edges[e].add(new int[]{s,v});
		}

		int s= 1;
		int[] dist = new int[N+1];
		Arrays.fill(dist, 100000000);

		PriorityQueue<int[]> pq = new PriorityQueue<>((a1,a2) -> a1[1] - a2[1]);
		pq.add(new int[]{s,0});
		while(!pq.isEmpty()){
			int[] now = pq.poll();
			int node = now[0];
			int nowDist = now[1];
			if(dist[node] <= nowDist){
				continue;
			}
			dist[node] = nowDist;
			for(int[] next : edges[node]){
				int nextNode = next[0];
				int nextDist = next[1];
				if(dist[nextNode] <= nowDist + nextDist){
					continue;
				}
				pq.add(new int[]{nextNode, nowDist + nextDist});
			}
		}
		// Arrays.stream(dist).forEach(System.out::println);
		return (int)Arrays.stream(dist).filter(i-> i<=K).count();
	}
}