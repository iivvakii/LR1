package com.example.lr1fx.file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WorkWithFiles {
    public void write() throws IOException {
        String filename = "test";
        BufferedWriter outputWriter = new BufferedWriter(new FileWriter(filename));
        Random random = new Random();
        int randomNumber = random.nextInt(100);
        outputWriter.write(Integer.toString(randomNumber));
        outputWriter.flush();
        outputWriter.close();

    }

}
