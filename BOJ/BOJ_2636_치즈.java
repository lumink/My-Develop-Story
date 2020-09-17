package ssafy;

import java.util.Scanner;

public class BOJ_2636_치즈 {

	static int N, M;
	static int[] dy = { 0, 0, -1, 1 };
	static int[] dx = { -1, 1, 0, 0 };
	static int[][] map;
	static boolean[][] visit;
	static int day;
	static int[] remain;
	static boolean check;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		remain = new int[10000];
		int out = N * M;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 1) {
					check = true;
				}
			}
		}
		
		if (!check) {
			System.out.println(0);
			System.out.println(0);
		}

		while (check) {

			visit = new boolean[N][M];

			visit[0][0] = true;
			dfs(0, 0);
			
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < M; j++) {
//					System.out.print(map[i][j] + " ");
//				}System.out.println();
//			}System.out.println();

			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1) {
						remain[day]++;
						melt(i, j);
					}
				}
			}
			
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < M; j++) {
//					System.out.print(map[i][j] + " ");
//				}System.out.println();
//			}System.out.println();

			int isend = 0;

			day++;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == -1) {
						map[i][j] = 0;
					} else if (map[i][j] == 2) {
						map[i][j] = 0;
					}
					if (map[i][j] == 0) {
						isend++;
					}
				}
			}
			
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < M; j++) {
//					System.out.print(map[i][j] + " ");
//				}System.out.println();
//			}System.out.println();
			

			if (isend == out) {
				System.out.println(day);
				System.out.println(remain[day - 1]);
				check = false;
			}
		}

	}

	private static void melt(int y, int x) {

		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			if (meltgo(ny, nx)) {
				map[y][x] = -1;
				break;
			}
		}

	}

	private static void dfs(int y, int x) {

		map[y][x] = 2;
		
		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			if (go(ny, nx)) {
				dfs(ny, nx);
			}
		}
	}

	private static boolean go(int ny, int nx) {
		if (ny < N && ny >= 0 && nx < M && nx >= 0 && map[ny][nx] == 0 && !visit[ny][nx]) {
			visit[ny][nx] = true;
			return true;
		} else {
			return false;
		}
	}

	private static boolean meltgo(int ny, int nx) {
		if (ny < N && ny >= 0 && nx < M && nx >= 0 && map[ny][nx] == 2) {
			return true;
		} else {
			return false;
		}
	}

}
