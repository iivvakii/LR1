package com.example.lr1fx;

import com.example.lr1fx.file.WorkWithFiles;
import com.example.lr1fx.workstation.PerfectNum;
import com.example.lr1fx.workstation.PerfectNum2;

import java.io.IOException;

public class Countable {

    WorkWithFiles workWithFiles = new WorkWithFiles();
    int number;

    public long countNumWithoutThreads(){
        PerfectNum perfectNum = new PerfectNum();
        long time = System.currentTimeMillis();
        perfectNum.countNum(number);
        long end = System.currentTimeMillis() - time;
        return end;
    }

    public long countNumWithThreads(int i){

        PerfectNum2 perfectNum2 = new PerfectNum2();
        System.out.println();
        System.out.println("К-сть потоків: " + i);
        long time2 = System.currentTimeMillis();
        System.out.println(perfectNum2.countNum(number, i));
        long a = System.currentTimeMillis() - time2;
        System.out.println(a);
        return a;
    }
}
