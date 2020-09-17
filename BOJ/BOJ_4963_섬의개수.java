package ssafy;
import java.util.Scanner;

public class BOJ_4963_섬의개수 {

	static int W, H;
	static int[][] map;
	static boolean[][] visited;
	static int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};
	static int[] dx = {-1, 1, 0, 0, 1, -1, -1, 1};
	//1 land 0 sea
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			W = sc.nextInt();
			H = sc.nextInt();
			map = new int[H][W];
			visited = new boolean[H][W];
			if (W == 0 && H == 0) {
				break;
			}
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			int count = 1;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (!visited[i][j] && map[i][j] == 1) {
						count++;
						visited[i][j] = true;
						dfs(i, j, count);					
					}
				}
			}
			System.out.println(count-1);
		}

	}
	private static void dfs(int y, int x, int cnt) {
		map[y][x] = cnt;
		for (int d = 0; d < 8; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			if (check(ny, nx)) {
				dfs(ny, nx, cnt);
			}
		}
	}
	private static boolean check(int ny, int nx) {
		if (ny < H && ny >= 0 && nx < W && nx >= 0 && !visited[ny][nx] && map[ny][nx] == 1) {
			visited[ny][nx] = true;
			return true;
		}
		else { return false; }
	}

}
