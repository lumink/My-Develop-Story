package ssafy;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2630_색종이만들기 {

	static int N;
	static int G[][];
	static boolean visitedBlue[][];
	static boolean visitedWhite[][];
	static int[] dy = {0,1,1};
	static int[] dx = {1,1,0};
	static int count, count2;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		G = new int[N][N];
		visitedWhite = new boolean [N][N];
		visitedBlue = new boolean [N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				G[i][j] = sc.nextInt();
			}
		}
		
		count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (G[i][j] == 0 && !visitedWhite[i][j]) {
					bfs(i,j);
				}
			}
		}
		
		count2 = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (G[i][j] == 1 && !visitedBlue[i][j]) {
					bfsB(i,j);
				}
			}
		}
		
		System.out.println(count);
		System.out.println(count2);
		
	}
	
	private static void bfs(int y, int x) {
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {y,x});
		
		while (!que.isEmpty()) {
			int point[] = que.poll();
			visitedWhite[y][x] = true;
			for (int d = 0; d < 2; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				if (check(ny, nx)) {
					que.offer(new int[] {ny, nx});
				}
			}
		}
		count++;
	}

	private static boolean check(int ny, int nx) {
		if (ny >= 0 && nx >= 0 && ny < N && nx < N && G[ny][nx] == 0 && !visitedWhite[ny][nx]) {
			visitedWhite[ny][nx] = true;
			return true;
		}else {
			return false; 
		}
	}
	
	private static void bfsB(int y, int x) {
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {y,x});
	
		while (!que.isEmpty()) {
			int cnt = 0;
			int point[] = que.poll();
			visitedBlue[y][x] = true;
			for (int d = 0; d < 2; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];
				if (check2(ny, nx)) {
					cnt ++;
				}
			}
		}
		count2++;
	}

	private static boolean check2(int ny, int nx) {
		if (ny >= 0 && nx >= 0 && ny < N && nx < N && G[ny][nx] == 1 && !visitedBlue[ny][nx]) {
			visitedBlue[ny][nx] = true;
			return true;
		}else {
			return false; 
		}
	}

}
