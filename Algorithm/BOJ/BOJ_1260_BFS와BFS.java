package ssafy;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1260_BFS와BFS {

	static int N, M, V;
	static int[][] G;
	static boolean[] visited;
	static boolean[] visited2;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();
		G = new int[N+1][N+1];
		visited = new boolean[N+1];
		visited2 = new boolean[N+1];
		
		for (int i = 0; i < M; i++) {
				int y = sc.nextInt();
				int x = sc.nextInt();
				G[y][x] = 1;
				G[x][y] = 1;
		}
		
//		for (int i = 0; i < G.length; i++) {
//			for (int j = 0; j < G.length; j++) {
//				System.out.print(G[i][j] + " ");
//			}System.out.println();
//		}
		
		dfs(V);
		System.out.println();
		bfs(V);
		
	}
	private static void bfs(int v) {
		Queue<Integer> que = new LinkedList<>();
		que.add(v);
		visited2[v] = true;
		
		int depth = 0;
		while(!que.isEmpty()) {	
			int size = que.size();
			for (int s = 0; s < size; s++) {
				v = que.poll();
				System.out.print(v + " ");
			
				for (int i = 1; i <= N; i++) {
					if (!visited2[i] && G[v][i] == 1) {
						visited2[i] = true;
						que.add(i);
					}
				}
			}
			depth++;
		}
	}
	
	private static void dfs(int v) {
		visited[v] = true;
		System.out.print(v + " ");
		
		for (int i = 1; i <= N; i++) {
			if (!visited[i] && G[v][i] == 1) {
				dfs(i);
			}
		}
	}

}
