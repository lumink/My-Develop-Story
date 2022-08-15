package ssafy;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BOJ_1194_달이차오른다가자 {

	static int N, M;
	static char[][] map;
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };
	static boolean[][][] visit;
	static Set<Character> key = new HashSet<>();
	static int sy, sx;
	static int output;
	static boolean escape;
	static boolean isescape;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		map = new char[N][M];
		visit = new boolean[N][M][0b111111 + 1];

		for (int i = 0; i < N; i++) {
			String s = sc.next();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == '0') {
					sy = i;
					sx = j;
					map[i][j] = '.';
				}
			}
		}

		output = Integer.MAX_VALUE;
		dfs(sy, sx, 0, 0);
		System.out.println(isescape ? output : "-1");
	}

	private static void dfs(int y, int x, int cnt, int mat) {
		
		visit[y][x][mat] = true;

		if (escape) {
			isescape = true;
			if (output >  cnt) {
				output = cnt;
				escape = false;
			}
			return;
		}

		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			
			boolean go = false;
			
			if (check(ny, nx)) {
				
				if (map[ny][nx] == '.') {
					go = true;
				}
				
				if (map[ny][nx] >= 'A' && map[ny][nx] <= 'F') {
					if (key.contains((char) (map[ny][nx] + 32))) {
						go = true;
					} else {
						continue;
					}
				}
				
				if (map[ny][nx] >= 'a' && map[ny][nx] <= 'f') {
					key.add(map[ny][nx]);
					
					go = true;
				}
				
				if (map[ny][nx] == '1') {
					go = true;
					escape = true;
				}
				
				if (map[ny][nx] == '#') {
					continue;
				} 
				
				if (go) {
					visit[ny][nx] = true;
					dfs(ny, nx, cnt + 1, mat);
					visit[ny][nx] = false;
				}
				
			}
		}
	}

	private static boolean check(int ny, int nx) {
		if (ny >= 0 && ny < N && nx >= 0 && nx < M && !visit[ny][nx]) {
			return true;
		} else {
			return false;
		}
	}

}
