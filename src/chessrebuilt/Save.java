/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessrebuilt;

import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author GrayHat
 */
public class Save {
    public static boolean Save(char grid[][],File ff)
    {
        boolean saved=true;
        try {
            FileWriter fw = new FileWriter(ff);
            String out="";
            for(int i=0;i<64;i++)
            {
                out+=grid[i/8][i%8];
            }
            fw.write(out);
            fw.close();
        } catch (Exception error) {
            System.out.println(error);
            saved=false;
        }
        return saved;
    }
}
