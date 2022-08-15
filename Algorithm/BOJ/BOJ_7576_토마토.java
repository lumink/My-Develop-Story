package ssafy;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_7576_토마토 {

	static int N, M;
	static int[][] G;
	static boolean[][] visited;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int count;
	static Queue<int[]> que = new LinkedList<int[]>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		G = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				G[i][j] = sc.nextInt();
			}
		}
		count = -1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (G[i][j] == 1 && !visited[i][j]) {
					que.offer(new int[] { i, j });
					visited[i][j] = true;
				}
			}
		}
		
		bfs();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (G[i][j] == 0 && !visited[i][j]) {
					count = -1;
				}
			}
		}
		System.out.println(count);
	}

	private static void bfs() {
		while (!que.isEmpty()) {
			int size = que.size();
			for (int s = 0; s < size; s++) {
				int point[] = que.poll();
				for (int d = 0; d < 4; d++) {
					int ny = point[0] + dy[d];
					int nx = point[1] + dx[d];
					if (check(ny, nx)) {
						que.offer(new int[] { ny, nx });
					}
				}
			}
			count++;
		}
	}

	private static boolean check(int ny, int nx) {
		if (ny >= 0 && nx >= 0 && ny < N && nx < M && G[ny][nx] == 0 && !visited[ny][nx]) {
			visited[ny][nx] = true;
			return true;
		} else {
			return false;
		}
	}

}
