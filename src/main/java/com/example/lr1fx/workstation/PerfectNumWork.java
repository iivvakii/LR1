package com.example.lr1fx.workstation;
import java.util.List;

import static java.lang.Math.pow;

public class PerfectNumWork implements Runnable{
    private int start;
    private int end;
    private List<Long> list;

    public PerfectNumWork(int start, int end, List<Long> list) {
        this.start = start;
        this.end = end;
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = start; i < end; i++){
            int s = (int) (pow(2, i) - 1);
            if(isPrimeBruteForce(s)){
                long res = (int) (pow(2, i - 1)*(s));
                if(res%2 == 0){
                    list.add(res);
                }

            }
        }
    }
    private boolean isPrimeBruteForce(int number) {
        for (int i = 2; i < Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

}

