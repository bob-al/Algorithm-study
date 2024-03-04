package com.algorithm.assignment.snail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
//        m = Integer.parseInt(br.readLine());

        int i = n / 2 + 1;
        int[][] numbers = new int[n][n];

        numbers[0][0] = n * n;
        int firstNum = numbers[0][0];
        int[] firstNumList = new int[n];

    }
}
