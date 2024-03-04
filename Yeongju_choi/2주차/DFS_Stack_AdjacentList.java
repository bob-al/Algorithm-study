package Yeongju_choi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFS_Stack_AdjacentList {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static ArrayList[] adj; // 2차원 인접리스트
  static boolean[] visited; // 방문 체크
  static ArrayList<Integer> track = new ArrayList<>(); // 이동 궤적 기록용
  static int V; // 노드의 갯수 (Vertex)
  static int E; // 간선의 갯수 (Edges)
  static int startNode = 1; // 1번 포도알부터 시작한다고 가정

  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    V = Integer.parseInt(st.nextToken());
    E = Integer.parseInt(st.nextToken());
    visited = new boolean[V+1];

    // 인접리스트 초기화
    adj = new ArrayList[V+1]; // 인덱스 - 노드번호 매칭 위해서 1칸 넉넉하게
    for (int i = 0; i < V+1; i++) {
      adj[i] = new ArrayList<>();
    }

    // 인접리스트 완성
    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      adj[start].add(end);
      adj[end].add(start);
    }

    System.out.println(Arrays.toString(adj));
    // [[], [2, 3], [1, 4, 5], [1, 7], [2, 6], [2, 6], [4, 5, 7], [6, 3]]

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
      // 인접리스트를 하나씩 돌면서! (0번 포도알 없음에 주의)
      for (int i = 1; i < V+1; i++) {
        for (Object dest : adj[i]) {
          if(!visited[(int)dest]){
            // 스택에 목적지를 넣어라!
            likeStack.addLast((int)dest);
          }
        }

      }
    }

    // 궤적을 기록해봅니다.
    System.out.println(track); // [1, 3, 7, 6, 5, 2, 4]
    System.out.println(track.size()); // 7 => 이어져있는 노드들의 집합 갯수
  }
}
