package com.example.lr1fx;

import com.example.lr1fx.file.WorkWithFiles;
import com.example.lr1fx.workstation.PerfectNum;
import com.example.lr1fx.workstation.PerfectNum2;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {



    @FXML
    BarChart<?,?> barChar;

    @FXML
    BarChart<?,?> barChar2;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



        XYChart.Series series = new XYChart.Series();
        XYChart.Series series2 = new XYChart.Series();

        System.out.println(countNumWithoutThreads(read()));
        int a = (int)countNumWithoutThreads(read());
        series2.getData().add(new XYChart.Data("Послідовний алгоритм", a));

        for (int i = 2; i < 11; i++){
            series.getData().add(new XYChart.Data(Integer.toString(i), countNumWithThreads(read(),i)));
        }
        barChar.getData().addAll(series);
        barChar2.getData().addAll(series2);
    }



    public long countNumWithoutThreads(int number){
        PerfectNum perfectNum = new PerfectNum();
        long time = System.currentTimeMillis();
        perfectNum.countNum(number);
        long end = System.currentTimeMillis() - time;
        return end;
    }

    public long countNumWithThreads(int number, int i){

        PerfectNum2 perfectNum2 = new PerfectNum2();
        System.out.println();
        System.out.println("К-сть потоків: " + i);
        long time2 = System.currentTimeMillis();
        System.out.println(perfectNum2.countNum(number, i));
        long a = System.currentTimeMillis() - time2;
        System.out.println(a);
        return a;
    }

    public int read(){
        BufferedReader bf = null;
        int number = 0;
        try {
            bf = new BufferedReader(new FileReader("test"));
            String line = bf.readLine();
            number = Integer.parseInt(line);
            bf.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return number;
    }

}