package probs.pgm;

import java.util.Arrays;

import java.util.*;
class pgm_다리를지나는트럭 {
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;
		// 0   -     -      7 4 5 6
		// 1   -     7      4 5 6
		// 2   -     7      4 5 6
		// 3   7     4      5 6
		// 4   7    4 5     6
		// 5  7 4    5      6
		// 6  7 4 5  6      -
		// 7  7 4 5  6
		// 8
		int n  = truck_weights.length;
		int time = 1;
		Queue<int[]> q = new LinkedList<>();
		int truckIndex = 0;
		while(true){
			if(!q.isEmpty() && q.peek()[1] <=time){
				int[] arrived = q.poll();
				weight += arrived[0];
			}
			if(weight >= truck_weights[truckIndex]){
				weight -= truck_weights[truckIndex];
				q.add(new int[]{truck_weights[truckIndex++], time + bridge_length});
			}

			if(truckIndex == n){
				break;
			}
			time++;
		}

		while(!q.isEmpty()){
			time = q.poll()[1];
		}
		return time;
	}

	public static void main(String[] args) {
		solution(10, 100, new int[]{10,10,10,10,10,10,10,10,10,10});
	}
}