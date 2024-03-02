package probs.pgm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class pgm_전력망을둘로나누기 {
	public int solution(int n, int[][] wires) {
		int answer = -1;
		ArrayList<Integer>[] edges = new ArrayList[n+1];
		for(int i = 0 ; i < n+1; i++){
			edges[i] = new ArrayList<>();
		}

		for(int[] wire : wires){
			int s = wire[0];
			int e = wire[1];

			edges[s].add(e);
			edges[e].add(s);
		}

		int minDiff = Integer.MAX_VALUE;
		for(int[] wire : wires){
			boolean[] visited = new boolean[n+1];

			int s = wire[0];
			int e = wire[1];
			int[] cantgo = new int[]{s,e};

			Queue<Integer> q = new LinkedList<>();
			q.add(1);
			int visitedCount = 0;
			while(!q.isEmpty()){
				int node = q.poll();
				visitedCount ++;
				visited[node] = true;
				for(Integer next : edges[node])
					if(visited[next] == false){
						if(cantgo[0] == node && cantgo[1] == next || cantgo[0] == next && cantgo[1] == node){
							continue;
						}
						q.add(next);
					}
			}
			// 9 3 -> 3
			// 9 5 -> 1
			// 9 1 -> 7
			visitedCount = (int)Math.abs(n-visitedCount - visitedCount);
			minDiff = Math.min(visitedCount, minDiff);
			if(minDiff == n%2)
				return minDiff;
		}
		return minDiff;
	}
}