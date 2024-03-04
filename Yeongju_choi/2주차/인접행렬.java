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
import java.util.StringTokenizer;

public class 인접행렬 {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int[][] adj; //인접행렬
  static int V;
  static int E;



  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    V = Integer.parseInt(st.nextToken());
    E = Integer.parseInt(st.nextToken());
    adj = new int[V+1][V+1]; //1부터 시작하는 vertax라 넉넉하게 만듬!

    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      adj[start][end] = 1;
      adj[end][start] = 1;
    }
    print(adj);
  }

  // 그래프 프린트용
  static void print(int[][] graph) {
    for (int i = 0; i < graph.length; i++) {
      for (int j = 0; j < graph.length; j++) {
        System.out.print(graph[i][j] + " ");
      }
      System.out.println();
    }
  }
}
