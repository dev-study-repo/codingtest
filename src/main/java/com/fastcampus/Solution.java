package com.fastcampus;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        int result_1 = solution(5,4,new int[]{2,3,6});
        System.out.println(result_1);
    }
    public static int solution(int n, int m, int[] section) {
        int count = 0; //룰러 횟수
        int last = 1; //마지막으로 칠해진 영역 번호(젤 오른쪽)
        for (int s : section) {
            if (s > last){
                count++;
                last = s + m -1;
            }
        }
        return count;
    }
}