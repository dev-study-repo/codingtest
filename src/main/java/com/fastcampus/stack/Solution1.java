package com.fastcampus.stack;

import java.util.*;

public class Solution1 {
    public static void main(String[] args) {
        int[] result_1 = solution(new int[]{93, 30, 55},new int[]{1,30,5});
        System.out.println(Arrays.toString(result_1));
    }
    public static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++){
            int day = (100 - progresses[i] + speeds[i] - 1)/speeds[i];
            queue.offer(day);
        }
        while (!queue.isEmpty()){
            int current = queue.poll();
            int count = 1;
            while (!queue.isEmpty() && queue.peek() <= current){
                queue.poll();
                count++;
            }
            result.add(count);
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}
