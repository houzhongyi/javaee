package com.zytec.type.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetPath {
    
    public String getSavePath(){
        InputStream fis = null;
        try{
            Properties pr = new Properties();
            fis = this.getClass().getClassLoader().getResourceAsStream("rs.properties");
            pr.load(fis);
            String savePath = pr.getProperty("savePath").trim();
            return savePath;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }finally{
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public String getReadPath(){
        InputStream fis = null;
        try{
            Properties pr = new Properties();
            fis = this.getClass().getClassLoader().getResourceAsStream("rs.properties");
            pr.load(fis);
            String readPath = pr.getProperty("readPath").trim();
            System.out.println(readPath);
            System.out.println(readPath);
            return readPath;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }finally{
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
}
