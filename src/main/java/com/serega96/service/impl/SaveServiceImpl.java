package com.serega96.service.impl;

import com.serega96.service.SaveService;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SaveServiceImpl implements SaveService {
    @Override
    public void saveFile(ArrayList<String> str, String resultFile) {

        try(FileWriter writer = new FileWriter(resultFile, false))
        {
            for (int t = 0; t < str.size(); t++)
            {
                // запись строки
                writer.write(str.get(t));
                writer.write("\r\n");

            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
