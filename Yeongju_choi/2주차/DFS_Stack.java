package Yeongju_choi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
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
public class DFS_Stack {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int[][] adj; //인접행렬

  static boolean[] visited; // 방문 체크
  static ArrayList<Integer> track = new ArrayList<>(); // 이동 궤적 기록용

  static int startNode = 1; // 1번 포도알부터 시작한다고 가정
  static int V;
  static int E;

  // 그래프 프린트용
  static void print(int[][] graph) {
    for (int i = 0; i < graph.length; i++) {
      for (int j = 0; j < graph.length; j++) {
        System.out.print(graph[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    V = Integer.parseInt(st.nextToken());
    E = Integer.parseInt(st.nextToken());
    adj = new int[V + 1][V + 1]; //1부터 시작하는 vertax라 넉넉하게 만듬!
    visited = new boolean[V + 1]; //visited 크기 설정

    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      adj[start][end] = 1;
      adj[end][start] = 1;
    }

    // stack 생성시, 초기 노드를 먼저 넣고 시작함.
    ArrayDeque<Integer> likeStack = new ArrayDeque<>(Arrays.asList(startNode));

    // 스택이 빌때까지 돌아라!
    while (!likeStack.isEmpty()) {
      // 로직 1
      // 스택에서 데이터를 하나 뽑고
      int cur = likeStack.removeLast();
      // current가 visited에 없다면?
      if(!visited[cur]) {
        // 방문체크를 해줍니다.
        visited[cur] = true;
        track.add(cur);
      }

      // 로직 2
      // 인접행렬을 하나씩 돌면서! (0번 포도알 없음에 주의)
      for (int i = 1; i < V+1; i++) {
      // 도착 노드가 방문체크되지 않았고 + 갈 수 있다면?
        if(!visited[i] && adj[i][cur] == 1){
          // 스택에 목적지를 넣어라!
          likeStack.addLast(i);
        }
      }
    }
    System.out.println(track); // [1, 3, 7, 6, 5, 2, 4]
  }
}

