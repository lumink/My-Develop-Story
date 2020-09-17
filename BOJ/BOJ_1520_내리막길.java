package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1520_내리막길 {

	static int m, n;
	static long[][] map, memo;
	static int dy[] = { 0, 0, -1, 1 };
	static int dx[] = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		map = new long[m][n];
		memo = new long[m][n];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				memo[i][j] = -1;
			}
		}

		System.out.println(dfs(0, 0));
	}

	private static long dfs(int y, int x) {

		if (y == m-1 && x == n-1) {
			return 1;
		}

		if (memo[y][x] == -1) {
			memo[y][x] = 0;
			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				if (ny >= 0 && ny < m && nx >= 0 && nx < n) {
					if (map[y][x] > map[ny][nx]) {
						memo[y][x] += dfs(ny, nx);
					}
				}
			}
		}

		return memo[y][x];
	}

}
