package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test {

   static int countryCount;
   static int planeCount;
   static int[] parents;
   static int[] ranks;
   static int[][] countries;

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;

      int TC = Integer.parseInt(br.readLine().trim());

      for (int t = 1; t <= TC; t++) {
         st = new StringTokenizer(br.readLine().trim());

         countryCount = Integer.parseInt(st.nextToken());
         planeCount = Integer.parseInt(st.nextToken());
         parents = new int[countryCount];
         ranks = new int[countryCount];

         for (int c = 0; c < countryCount; c++) {
            parents[c] = c;
         }

         countries = new int[countryCount][2];
         
         for (int p = 0; p < planeCount; p++) {
            st = new StringTokenizer(br.readLine().trim());

            countries[p][0] = Integer.parseInt(st.nextToken()) -1;
            countries[p][1] = Integer.parseInt(st.nextToken()) -1;
         }

         int cnt = 0;
         for (int i = 0; i < planeCount; i++) {
            int from = getParent(countries[i][0]);
            int to = getParent(countries[i][1]);

            if (from == to)
               continue;

            unionFind(from, to);
            ++cnt;
         }

         System.out.println(cnt);
      }
   }

   private static int getParent(int idx) {
      if (parents[idx] != idx) {
         int answer = getParent(parents[idx]);
         parents[idx] = answer;
         return parents[idx];
      } else {
    	 return idx;
      }
   }

   private static void unionFind(int idx1, int idx2) {
      idx1 = getParent(idx1);
      idx2 = getParent(idx2);

      if (ranks[idx1] < ranks[idx2]) {
         parents[idx1] = parents[idx2];
      } else {
         parents[idx2] = parents[idx1];
         if (ranks[idx2] == ranks[idx1]) {
            ranks[idx1]++;
         }
      }
   }
}