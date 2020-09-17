package ssafy;

import java.util.Scanner;
import java.util.TreeSet;

public class BOJ_2468_안전영역 {

	static int[][] map, copy;
	static boolean[][] visit;
	static int max, N;
	static int[] dy = {0, 0, -1, 1};
	static int[] dx = {-1, 1, 0, 0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		 
		TreeSet<Integer> set = new TreeSet<>();
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				set.add(map[i][j]);
			}
		}
		
		max = 1;
		for (int n : set) {
			visit = new boolean[N][N];
			rain(n);
		}
		
		System.out.println(max);
		
	}
	
	private static void rain(int n) {
		
		copy = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			System.arraycopy(map[i], 0, copy[i], 0, N);
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (copy[i][j] <= n) {
					copy[i][j] = -1;
				}
			}
		}	
		
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (copy[i][j] > 0 && !visit[i][j]) {
					count++;
					visit[i][j] = true;
					dfs(i, j, count);
				}
			}
		}
		
		if (count > max) {
			max = count;
		}
	}

	private static void dfs(int y, int x, int count) {
		
		copy[y][x] = count;
		
		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			if (check(ny, nx)) {
				visit[ny][nx] = true;
				dfs(ny, nx, count);
			}
		}
	}
	
	private static boolean check(int ny, int nx) {
		if (ny >= 0 && ny < N && nx >= 0 && nx < N && copy[ny][nx] > 0 && !visit[ny][nx]) {
			return true;
		} else {
			return false;
		}
	}

}
