/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package glluch.com.moocs;

import com.glluch.utils.Out;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * 
 * @author Guillem LLuch Moll
 */
public class Main {
    public static void main(String[] args) throws IOException, InvocationTargetException, IllegalAccessException {
        GenerateTestResults gtr=new GenerateTestResults();
        //gtr.IObuildMoocFromJsonResult();
        //gtr.MooctestToString();
        //gtr.IOBuildMoocsFromJsons();
        gtr.IOtestWriteMoocs2txt();

    }
    
    protected static void writeTxt() throws IOException{
    IO io=new IO();
        String target="resources/courses/txt-en/";
        
        ArrayList <Mooc> moocs=io.buildMoocsFromJsons();
        
        io.writeMoocs2txt(moocs, target);
    }
    
    
   
}
