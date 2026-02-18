package com.fastcampus.stack;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2_2 {
    public static void main(String[] args) {
        int result = solution(2, 10, new int[]{7,4,5,6});
        System.out.println(result);
    }
    static class Truck{
        int weight;
        int move;
        public Truck(int w){
            this.weight = w;
            this.move = 1;
        }
        public void moving(){
            move++;
        }
    }
    public static int solution(int bridgeLength, int weight, int[] truckWeights){
        Queue<Truck> wait = new LinkedList<>();
        Queue<Truck> move = new LinkedList<>();
        for (int i : truckWeights){
            wait.add(new Truck(i));
        }
        int time = 0;
        int currentWeight = 0;
        while (!wait.isEmpty() || !move.isEmpty()){
            time++;

            if (move.isEmpty()){
                Truck t = wait.poll();
                currentWeight += t.weight;
                move.add(t);
                continue;
            }

            for (Truck t : move){
                t.moving();
            }

            if (move.peek().move > bridgeLength){
                Truck t = move.poll();
                currentWeight -= t.weight;
            }

            if (!wait.isEmpty() && (currentWeight + wait.peek().weight <= weight)){
                Truck t = wait.poll();
                currentWeight += t.weight;
                move.add(t);
            }
        }
        return time;
    }
}

