package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17144_미세먼지안녕 {
	
	static int R, C, T;
	static int[][] map;
	static int upY, upX, downX, downY;
	static int[] dy = {};
	static int
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			s = br.readLine();
			st = new StringTokenizer(s);
			for (int j = 0; j < C; j++) {
				int value = Integer.parseInt(st.nextToken());
				if (value == -1) {
					upY = R;
					upX = C;
				}
				map[R][C] = value;
			}
		}
		
		downY = upY + 1;
		downX = upX;
		
		for (int i = 0; i < T; i++) {
			spread();
		}
		
	}
	
	private static void spread() {
		
		Queue<Integer> que = new LinkedList<>();
		
			
		wind();
		
	}

	private static void wind() {
		
		
	}

}
