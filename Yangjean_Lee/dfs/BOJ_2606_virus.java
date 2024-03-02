package com.algorithm.Backjoon.assignment.virus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int v;  // 컴퓨터의 수
    static int e;  // 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수
    static int firstNode = 1;  // 첫 번째 컴퓨터
    static boolean[] visited;
    static ArrayList<Integer> track = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        v = Integer.parseInt(br.readLine());
        e = Integer.parseInt(br.readLine());
        int[][] adj = new int[v + 1][v + 1];
        visited = new boolean[v + 1];

        // 인접배열 구하기
        for (int i = 0; i < e; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            adj[start][end] = 1;
            adj[end][start] = 1;
        }
        // stack 생성
        ArrayDeque<Integer> stack = new ArrayDeque<>(Arrays.asList(firstNode));
        while (!stack.isEmpty()) {

            int current = stack.removeLast();

            if (!visited[current]) {
                visited[current] = true;
                track.add(current);
            }

            for (int destination = 1; destination < v + 1; destination++) {
                if (!visited[destination] && adj[current][destination] == 1) {
                    stack.addLast(destination);
                }
            }
        }

        System.out.println(track.size() - 1);
    }
}
