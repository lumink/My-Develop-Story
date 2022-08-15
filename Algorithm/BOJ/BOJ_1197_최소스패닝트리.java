package ssafy;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ_1197_최소스패닝트리 {

	static int[] parents;
	static int[] rank;

	static void makeSet(int x) {
		parents[x] = x;
	}

	static int findSet(int x) {
		if (x == parents[x]) {
			return x;
		} else {
			parents[x] = findSet(parents[x]);
			return parents[x];
		}
	}

	static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);

		if (rank[px] > rank[py]) {
			parents[py] = px;
		} else {
			parents[px] = py;
			if (rank[px] == rank[py])
				rank[py]++;
		}
	}

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		int V = scann.nextInt();
		int E = scann.nextInt();
		int[][] edges = new int[E][3];
		parents = new int[V+1];
		rank = new int[V+1];
		for (int i = 0; i < E; i++) {
			edges[i][0] = scann.nextInt();
			edges[i][1] = scann.nextInt();
			edges[i][2] = scann.nextInt();
		}
		Arrays.sort(edges, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[2], o2[2]);
			}
		});
		for (int i = 1; i <= V; i++) {
			makeSet(i);
		}
		int cnt = 0;
		int result = 0;
		for (int i = 0; i < E; i++) {
			int a = findSet(edges[i][0]);
			int b = findSet(edges[i][1]);
			if (a == b) {
				continue;
			}
			union(a, b);
			result += edges[i][2];
			cnt++;
			if (cnt == V - 1) {
				break;
			}
		}
		System.out.println(result);
	}
}