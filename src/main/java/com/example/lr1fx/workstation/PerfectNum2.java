package com.example.lr1fx.workstation;
import java.util.ArrayList;
import java.util.List;
public class PerfectNum2 {

    public List<Long> countNum(int number, int numThreads) {
        List<Long> list = new ArrayList<>();
        List<Thread> threadList = new ArrayList<>();

        int workload = number/numThreads;
        int remaining = number%numThreads;

        int start = 2;
        for (int i = 0; i < numThreads; i++){
            int end = start + workload;
            if(i < remaining){
                end++;
            }
            Thread thread = new Thread(new PerfectNumWork(start, end, list));
            thread.start();
            threadList.add(thread);


            start = end;
        }

        for (Thread thread1 : threadList) {
            try {
                thread1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return list;
    }

}

