package com.algorithm.assignment.robot;
/**
 * 테스트 케이스
 * "GRGLGRG" -> [2, 2]
 * "GRGRGRB" -> [2, 0]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int x, y, temp;  // 좌푯값
    static String command;  // 명령어
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        command = getCommand(br);

        for (int i = 0; i < command.length(); i++) {

            char operation = command.charAt(i);

            if (operation == 'L' || operation == 'R' ) {
                swap();

            } else {
                y = (operation == 'G') ? y + 1 : y - 1;
            }

        }

        System.out.printf("[%d, %d]", x, y);
    }

    public static String getCommand(BufferedReader br) throws IOException {
        return br.readLine();
    }

    public static void swap() {
        temp = x;
        x = y;
        y = temp;
    }
}