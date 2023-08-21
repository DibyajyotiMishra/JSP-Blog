/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wave.helpers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 *
 * @author dibyajyotimishra
 */
public class FileHandler {
    public static boolean deleteFile(String path) {
        boolean isSuccess = false;
        
        try {
            File file = new File(path);
            isSuccess = file.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return isSuccess;
    }
    
    public static boolean saveFile(InputStream is, String path) {
        boolean isSuccess = false;
         
        try {
            byte[] file = new byte[is.available()];
            is.read(file);
            FileOutputStream fs = new FileOutputStream(path);
            fs.write(file);
            fs.close();
            isSuccess = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return isSuccess;
    }
}
