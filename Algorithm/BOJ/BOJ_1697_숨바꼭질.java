package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697_숨바꼭질 {

	static int n, k, result;
	static int[] visit;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		visit = new int[100000+1];
		Arrays.fill(visit, Integer.MAX_VALUE);

		Queue<Point> que = new LinkedList<>();
		que.clear();
		que.offer(new Point(n, 0));
		visit[n] = 0;
		while (!que.isEmpty()) {
			int size = que.size();
			
			for (int i = 0; i < size; i++) {
				
				Point v = que.poll();
				int current = v.node;
				int second = v.second;
				
				if (current == k) {
					result = second;
					que.clear();
					break;
				}
				
				int next = current + 1;
				int pre = current - 1;
				int tele = current * 2;
				
				if (next <= 100000 && visit[next] > second+1 ) { 
					que.offer(new Point(next, second+1));
					visit[next] = second+1;
				}
				if (pre >= 0 && visit[pre] > second+1) {
					que.offer(new Point(pre, second+1));
					visit[pre] = second+1;
				}
				if (tele <= 100000 && visit[tele] > second+1) {
					que.offer(new Point(tele, second+1));
					visit[tele] = second+1;
				}
			}
		}

		System.out.println(result);
	}
}

class Point {
	int node;
	int second;

	public Point(int node, int second) {
		this.node = node;
		this.second = second;
	}

}
