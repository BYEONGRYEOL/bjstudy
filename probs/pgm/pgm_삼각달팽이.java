package probs.pgm;

import java.util.Arrays;
import java.util.stream.Stream;

class pgm_삼각달팽이 {
	public static int[] solution(int n) {
		int[][] result = new int[n+1][n+1];
		int lastNumber = n * (n+1) / 2;
		int number = 1;
		int x = 1;
		int y = 1;
		int dir = 0;
		int[] dirx = {1,0,-1};
		int[] diry = {0,1,-1};
		// 0 하, 1 우 2 좌상

		while(number <= lastNumber){
			result[x][y] = number;
			int newx = x + dirx[dir];
			int newy = y + diry[dir];
			if(newx <1 || newx >n || newy <1 || newy>n || result[newx][newy] > 0){
				dir = (dir + 1) % 3;
				if(number ==lastNumber){
					break;
				}
			}
			else{
				x = newx;
				y = newy;
				number++;
			}

		}
		int[] answer = Stream.of(result).flatMapToInt(Arrays::stream).filter(i -> i > 0).toArray();
		return answer;
	}

	public static void main(String[] args) {
		Arrays.stream(solution(4)).forEach(System.out::println);
	}
}