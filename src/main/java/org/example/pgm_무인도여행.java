import java.util.*;
import java.util.stream.*;

class pgm_무인도여행 {
	int[] dirx = {-1,1,0,0};
	int[] diry = {0,0,-1,1};
	int N;
	int M;
	public int visit(String[] maps, int x, int y, boolean[][] visited){
		int result = maps[x].charAt(y) - '0';
		visited[x][y] = true;

		for(int k = 0 ; k<4; k ++){
			int newx = x + dirx[k];
			int newy = y + diry[k];

			if(newx >=0 && newx < N && newy >= 0 && newy < M && visited[newx][newy] == false && maps[newx].charAt(newy) != 'X'){
				visited[newx][newy] = true;
				result += visit(maps,newx,newy,visited);
			}
		}
		return result;
	}
	public int[] solution(String[] maps) {
		N = maps.length;
		M = maps[0].length();
		List<Integer> days = new ArrayList<>();
		boolean[][] visited = new boolean[N][M];

		for(int i = 0 ; i < N ; i ++){
			for(int j = 0; j< M ; j ++){
				if(visited[i][j] == false && maps[i].charAt(j) != 'X'){
					days.add(visit(maps ,i ,j, visited));
				}
			}
		}

		if(days.isEmpty()){
			return new int[]{-1};
		}
		return days.stream().sorted().mapToInt(Integer::intValue).toArray();
	}
}