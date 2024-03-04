package Yeongju_choi;


// Vertex = 7개, Edge = 8개인 그래프가 있을 때,
// 다음 8개의 줄에 연결 정보를 제공
//        7 8
//        1 2
//        1 3
//        2 4
//        2 5
//        4 6
//        5 6
//        6 7
//        3 7

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 인접리스트 {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static ArrayList[] adj;
  static int V;
  static int E;

  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    V = Integer.parseInt(st.nextToken());
    E = Integer.parseInt(st.nextToken());
    adj = new ArrayList[V+1];
    for (int i = 0; i < adj.length; i++) {
      adj[i] = new ArrayList<>();
    }

    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      adj[start].add(end);
      adj[end].add(start);
    }

    System.out.println(Arrays.toString(adj));
    // [[], [2, 3], [1, 4, 5], [1, 7], [2, 6], [2, 6], [4, 5, 7], [6, 3]]
  }
}
