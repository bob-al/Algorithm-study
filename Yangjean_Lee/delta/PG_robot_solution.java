package com.algorithm.assignment.robot;
/**
 * 테스트 케이스
 * "GRGLGRG" -> [2, 2]
 * "GRGRGRB" -> [2, 0]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    static int x= 0, y = 0, dir = 1_000_000;  // 좌푯값
    static int[] dx = {0, 1, 0, -1};  // x 좌표 이동량
    static int[] dy = {1, 0, -1, 0};  // y 좌표 이동량
    static String command;  // 명령어
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        getCommand();

        for (int i = 0; i < command.length(); i++) {

            String operation = String.valueOf(command.charAt(i));

            if (operation.equals("L") || operation.equals("R")) {
                dir = getDirection(dir, operation);

            } else {
                moveRobot(operation, dir);
            }
        }

        System.out.printf("[%d, %d]", x, y);
    }

    /* 명령어 입력 받기 */
    private static void getCommand() throws IOException {
        command = br.readLine().toUpperCase();
    }
    /* 방향값 얻기 */
    private static int getDirection(int dir, String operation) {

        if (operation.equals("L")) {
            dir = (dir - 1) % 4;  // 왼쪽으로 90도 회전

        } else {
            dir = (dir + 1) % 4;  // 오른쪽으로 90도 회전
        }

        return dir;
    }
    /* 이동량 계산 */
    private static void moveRobot(String operation, int dir) {
        if (operation.equals("G")) {
            x += dx[dir]; // x 좌표 이동
            y += dy[dir]; // y 좌표 이동

        } else {
            x -= dx[dir]; // x 좌표 후진
            y -= dy[dir]; // y 좌표 후진
        }
    }
}