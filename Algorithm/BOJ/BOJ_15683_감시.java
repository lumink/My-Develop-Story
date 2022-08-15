package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15683_감시 {

	static int N, M;
	static int[][] map;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, -1, 0, 1 };
	static int[][] cctv;
	static int visited[];
	static boolean check;
	static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		cctv = new int[4][8];

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] > 0 && map[i][j] < 6) {
					cctv[0][cnt] = map[i][j];
					cctv[1][cnt] = i;
					cctv[2][cnt] = j;
					cnt++;
				}
			}
		}

		visited = new int[cnt+1];

		while (!check) {
			for (int i = 0; i < cnt; i++) {
				if (i == cnt-1 && visited[i] == 1) {
					check = true;
				}
				if (visited[i] != 1) {
					dfs(i,cctv[0][i], cctv[1][i], cctv[2][i], cctv[3][i]);
					cctv[3][i] = cnt + 1;
				}
			}

			int output = 0;
			min = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					System.out.print(map[i][j] + " ");
					if (map[i][j] == 0) {
						output++;
					}
				}System.out.println();
			}
			if (min > output) {
				min = output;
			}
		}
		System.out.println(min);
	}

	private static void dfs(int number, int cc, int r, int c, int cnt) {

		if (cc == 1) {
			if (cnt == 4) {
				visited[number] = 1;
				return;
			}
			
			int ny = r + dy[cnt];
			int nx = c + dx[cnt];
			if (go(ny, nx)) {
				if (map[ny][nx] == 0) {
					map[ny][nx] = -1;
					dfs(number,cc, ny, nx, cnt);
				}
			}
			
		} else if (cc == 2) {
			if (cnt == 2) {
				visited[number] = 1;
				return;
			}
			for (int i = 0; i < 3; i = i+2) {
				int ny = r + dy[cnt + i];
				int nx = c + dx[cnt + i];
				if (go(ny, nx)) {
					if (map[ny][nx] == 0) {
						map[ny][nx] = -1;
						dfs(number,cc, ny, nx, cnt);
					}
				} else {
					return;
				}
			}
			
		} else if (cc == 3) {
			if (cnt == 4) {
				visited[number] = 1;
				return;
			}
	
			for (int i = 0; i < 2; i = i++) {
				int ny = r + dy[(cnt + i) % 4];
				int nx = c + dx[(cnt + i) % 4];
				if (go(ny, nx)) {
					if (map[ny][nx] == 0) {
						map[ny][nx] = -1;
						dfs(number,cc, ny, nx, cnt);
					}
				}
			}
			
		} else if (cc == 4) {
			if (cnt == 4) {
				visited[number] = 1;
				return;
			}
			for (int i = 0; i < 3; i++) {
				int ny = r + dy[(cnt + i) % 4];
				int nx = c + dx[(cnt + i) % 4];
				if (go(ny, nx)) {
					if (map[ny][nx] == 0) {
						map[ny][nx] = -1;
						dfs(number,cc, ny, nx, cnt);
					}
				}
			}
		} else if (cc == 5) {
			if (cnt == 1) {
				visited[number] = 1;
				return;
			}
			for (int i = 0; i < 4; i++) {
				int ny = r + dy[i];
				int nx = c + dx[i];
				if (go(ny, nx)) {
					if (map[ny][nx] == 0) {
						map[ny][nx] = -1;
						dfs(number,cc, ny, nx, cnt);
					}
				}
			}
		}
	}

	private static boolean go(int ny, int nx) {
		if (ny >= 0 && ny < N && nx >= 0 && nx < M && map[ny][nx] != 6) {
			return true;
		} else {
			return false;
		}
	}
}
