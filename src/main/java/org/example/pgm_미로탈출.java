package org.example;

import java.util.LinkedList;
import java.util.Queue;

class pgm_미로탈출 {
	public int solution(String[] maps) {
		int cantGo = -1;
		int toLever = move('S', 'L', maps);
		if (toLever == -1)
			return cantGo;
		int toGoal = move('L', 'E', maps);
		if (toGoal == -1)
			return cantGo;
		return toLever + toGoal;
	}

	private int[] findIndexOf(String[] maps, char target) {
		int result[] = new int[2];
		for (int i = 0; i < maps.length; i++) {
			int fromIndex = maps[i].indexOf(target);
			if (fromIndex >= 0) {
				result[0] = i;
				result[1] = fromIndex;
				break;
			}
		}
		return result;
	}

	public int move(char from, char to, String[] maps) {
		int n = maps.length;
		int m = maps[0].length();
		boolean[][] visited = new boolean[n][m];
		int[] dirx = new int[] {-1, 1, 0, 0};
		int[] diry = new int[] {0, 0, -1, 1};
		Queue<int[]> q = new LinkedList<>();

		int[] start = findIndexOf(maps, from);
		int sx = start[0];
		int sy = start[1];

		q.add(new int[] {sx, sy, 0});
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int x = now[0];
			int y = now[1];
			int move = now[2];
			if (maps[x].charAt(y) == to) {
				return move;
			}
			if (visited[x][y]) {
				continue;
			}
			visited[x][y] = true;

			for (int k = 0; k < 4; k++) {
				int newx = x + dirx[k];
				int newy = y + diry[k];
				if (newx >= 0 && newx < n && newy >= 0 && newy < m && maps[newx].charAt(newy) != 'X'
					&& visited[newx][newy] == false) {
					q.add(new int[] {newx, newy, move + 1});
				}
			}
		}
		return -1;
	}
}