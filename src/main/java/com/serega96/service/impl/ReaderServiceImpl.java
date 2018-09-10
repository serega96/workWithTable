package com.serega96.service.impl;

import com.serega96.service.ReaderService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeSet;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public ArrayList<String> readFile(String name, String find) {
        String line;
        String cvsSplitBy = ",";
        TreeSet<Integer> colNumber = new TreeSet<Integer>();
        ArrayList<String> result = new ArrayList<String>();

        try (BufferedReader br = new BufferedReader(new FileReader(name))){

            while ((line = br.readLine()) != null) {

                String[] str = line.split(cvsSplitBy);

                for (int i = 0; i < str.length; i++) {
                    if(str[i].equals(find)){
                        colNumber.add(i);
                    }
                }
            }
        } catch(IOException ex){
            ex.printStackTrace();
        }

        ArrayList<Integer> col = new ArrayList<Integer>(colNumber);
        try  {
            if (col.size() != 0) {
                for (int i = 0; i < col.size(); i++) {
                    BufferedReader br = new BufferedReader(new FileReader(name));
                    while ((line = br.readLine()) != null) {
                        String[] str = line.split(cvsSplitBy);
                        result.add(str[col.get(i)]);
                    }
                }
            } else{
                result.add("No match");
            }
        } catch(IOException ex){
            ex.printStackTrace();
        }

        return result;
    }
}
