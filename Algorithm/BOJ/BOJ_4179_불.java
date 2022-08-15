package ssafy;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_4179_불 {

	static int R, C;
	static char[][] map;
	static boolean[][] fireVisited;
	static boolean[][] visited;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int min;
	static boolean escape;
	static int jx, jy;
	static Queue<int[]> fireQue = new LinkedList<int[]>();
	static Queue<int[]> que = new LinkedList<int[]>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new char[R][C];
		fireVisited = new boolean[R][C];
		visited = new boolean[R][C];
		escape = false;
		que.clear();
		fireQue.clear();

		for (int i = 0; i < R; i++) {
			String s = sc.next();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'J') {
					que.offer(new int[] { i, j });
					visited[i][j] = true;
				}
				if (map[i][j] == 'F') {
					fireQue.offer(new int[] { i, j });
					fireVisited[i][j] = true;
				}
			}
		}

		move();

		if (escape) {
			System.out.println(min);
		} else {
			System.out.println("IMPOSSIBLE");
		}
	}

	private static void move() {
		int size = 0, cnt = 0;

		if (fireQue.isEmpty()) {
			while (!que.isEmpty()) {
				if (escape) {
					break;
				}
				moveJihun();
				cnt++;
			}
		}

		while (!fireQue.isEmpty()) {
			if (escape) {
				break;
			}
			size = fireQue.size();
			for (int s = 0; s < size; s++) {
				int fire[] = fireQue.poll();
				for (int d = 0; d < 4; d++) {
					int ny = fire[0] + dy[d];
					int nx = fire[1] + dx[d];
					if (firecheck(ny, nx)) {
						fireQue.offer(new int[] { ny, nx });
					}
				}
			}
			moveJihun();
			cnt++;
		}
		min = cnt;
	}

	private static void moveJihun() {
		int size2 = 0;
		size2 = que.size();
		for (int s = 0; s < size2; s++) {
			int jihun[] = que.poll();
			for (int d = 0; d < 4; d++) {
				if (jihun[0] == R - 1 || jihun[1] == C - 1 || jihun[0] == 0 || jihun[1] == 0) {
					escape = true;
					break;
				}
				int ny = jihun[0] + dy[d];
				int nx = jihun[1] + dx[d];
				if (check(ny, nx)) {
					que.offer(new int[] { ny, nx });
				}
			}
		}
	}

	private static boolean check(int ny, int nx) {
		if (ny >= 0 && ny < R && nx >= 0 && nx < C && !visited[ny][nx] && map[ny][nx] == '.' && !fireVisited[ny][nx]) {
			visited[ny][nx] = true;
			return true;
		} else {
			return false;
		}
	}

	private static boolean firecheck(int ny, int nx) {
		if (ny >= 0 && ny < R && nx >= 0 && nx < C && !fireVisited[ny][nx] && map[ny][nx] != '#') {
			fireVisited[ny][nx] = true;
			return true;
		} else {
			return false;
		}
	}

}
