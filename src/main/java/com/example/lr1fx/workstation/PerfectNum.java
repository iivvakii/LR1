package com.example.lr1fx.workstation;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.pow;

public class PerfectNum {
    public List<Long> countNum(int number){
        List<Long> list = new ArrayList<>();
        long res;
        int s;
        for (int i = 1; i < number; i++){
            s = (int) (pow(2, i) - 1);
            if(isPrimeBruteForce(s)){
                res = (int) (pow(2, i - 1)*(s));
                if(res%2 == 0){
                    list.add(res);
                }

            }

        }

        return list;
    }

    public static boolean isPrimeBruteForce(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
