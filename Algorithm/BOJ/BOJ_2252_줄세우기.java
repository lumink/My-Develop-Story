package ssafy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2252_줄세우기 {

	static int N, M;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		// input edge;
		int[] edge = new int[N];
		
		for (int i = 0; i < M; i++) {
			int pre = sc.nextInt() -1;
			int next = sc.nextInt() -1;
			graph.get(pre).add(next);
			edge[next]++;
		}
		
		Queue<Integer> que = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			if (edge[i] == 0) {
				que.offer(i);
			}
		}
		
		while (!que.isEmpty()) {
			
			int v = que.poll();
			
			System.out.print((v + 1) + " ");
			
			for (int next : graph.get(v)) {
				edge[next]--;
				
				if (edge[next] == 0) {
					que.offer(next);
				}
			}
		}
	}

}