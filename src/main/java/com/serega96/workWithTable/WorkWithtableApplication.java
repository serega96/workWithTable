package com.serega96.workWithTable;

import com.serega96.service.ReaderService;
import com.serega96.service.impl.ReaderServiceImpl;
import com.serega96.service.impl.SaveServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.TreeSet;

@SpringBootApplication
public class WorkWithtableApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkWithtableApplication.class, args);


        System.out.println("Welcome, wait few seconds I'm working");
        String nameOfFile = "";
        String find = "";
        String resultFile = "";
        String buf;
        for (int i = 0; i < args.length; i++)
        {
            buf = args[i];

            switch (buf){
                case "-i": nameOfFile = args[i+1]; i++; break;
                case "-q": find = args[i+1]; i++; break;
                case "-o": resultFile = args[i+1]; i++; break;
            }
        }


        ReaderServiceImpl csv = new ReaderServiceImpl();
        ArrayList<String> result;
        result = csv.readFile(nameOfFile, find);

        SaveServiceImpl save = new SaveServiceImpl();
        save.saveFile(result, resultFile);

    }
}
