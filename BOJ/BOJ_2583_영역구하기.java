package ssafy;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2583_영역구하기 {

	static int N, M, K;
	static int[][] map;
	static boolean[][] visited;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		K = sc.nextInt();
		map = new int[M][N];
		visited = new boolean[M][N];
		for (int k = 0; k < K; k++) {
			int leftx = sc.nextInt();
			int bottomy = sc.nextInt();
			int rightx = sc.nextInt();
			int topy = sc.nextInt();
			for (int i = bottomy; i < topy; i++) {
				for (int j = leftx; j < rightx; j++) {
					map[i][j] = 1;
				}
			}
		}
		int cnt = 1;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && map[i][j] == 0) {
					cnt++;
					visited[i][j] = true;
					dfs(i, j, cnt);
				}
			}
		}
		System.out.println(cnt - 1);
		int[] arr = new int[cnt - 1];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] > 1) {
					arr[map[i][j] - 2]++;
				}
			}
		}
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	private static void dfs(int y, int x, int count) {
		map[y][x] = count;
		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			if (check(ny, nx)) {
				dfs(ny, nx, count);
			}
		}
	}

	private static boolean check(int ny, int nx) {
		if (ny >= 0 && ny < M && nx >= 0 && nx < N && !visited[ny][nx] && map[ny][nx] == 0) {
			visited[ny][nx] = true;
			return true;
		} else
			return false;
	}

}
