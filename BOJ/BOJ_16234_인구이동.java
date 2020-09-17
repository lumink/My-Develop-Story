package ssafy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_16234_인구이동 {

	static int N, L, R;
	static int[][] A;
	static int[][] association;
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };
	static boolean[][] visited;
	static boolean[][] visited2;
	static boolean isEnd = false;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();
		A = new int[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				A[r][c] = sc.nextInt();
			}
		}
		int output = 0;
		while (true) {
			int cnt = 0;
			visited = new boolean[N][N];
			association = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j]) {
						cnt++;
						visited[i][j] = true;
						open(i, j, cnt);
					}
				}
			}

			if (cnt == N * N) {
				break;
			}

			output++;

			visited2 = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited2[i][j]) {
						move(i, j);
						visited2[i][j] = true;
					}
				}
			}
		}
		System.out.println(output);
	}

	private static void move(int y, int x) {
		Queue<int[]> que = new LinkedList<>();
		Queue<int[]> que2 = new LinkedList<>();
		que.clear();
		que2.clear();
		int c = association[y][x];
		que.offer(new int[] { y, x });
		int sum = 0;
		while (!que.isEmpty()) {
			int point[] = que.poll();
			for (int d = 0; d < 4; d++) {
				int ny = point[0] + dy[d];
				int nx = point[1] + dx[d];
				if (ny >= 0 && ny < N && nx >= 0 && nx < N && !visited2[ny][nx] && (c == association[ny][nx])) {
					visited2[ny][nx] = true;
					que.offer(new int[] { ny, nx });
					que2.offer(new int[] { ny, nx });
					sum += A[ny][nx];
				}
			}
		}

		if (que2.size() > 0) {
			int a = sum / que2.size();
			while (!que2.isEmpty()) {
				int point[] = que2.poll();
				A[point[0]][point[1]] = a;
			}
		}
	}

	private static void open(int y, int x, int cnt) {

		association[y][x] = cnt;

		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			if (check(ny, nx) && (Math.abs(A[y][x] - A[ny][nx]) >= L) && (Math.abs(A[y][x] - A[ny][nx]) <= R)) {
				visited[ny][nx] = true;
				open(ny, nx, cnt);
			}
		}
	}

	private static boolean check(int ny, int nx) {
		if (ny >= 0 && ny < N && nx >= 0 && nx < N && !visited[ny][nx]) {
			return true;
		} else {
			return false;
		}
	}

}
