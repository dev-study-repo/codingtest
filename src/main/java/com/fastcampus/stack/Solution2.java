package com.fastcampus.stack;

import java.util.*;

public class Solution2 {
    public static void main(String[] args) {
        int result = solution(2, 10, new int[]{7,4,5,6});
        System.out.println(result);
    }
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        int time = 0;
        int current_weight = 0;
        int index = 0;
        for (int i = 0; i < bridge_length; i++){
            queue.add(0);
        }
        while(index < truck_weights.length){
            time++;
            current_weight -= queue.poll();
            if(current_weight + truck_weights[index] <= weight){
                queue.add(truck_weights[index]);
                current_weight += truck_weights[index++];
            }else queue.add(0);
        }
        return time + bridge_length;
    }
}
