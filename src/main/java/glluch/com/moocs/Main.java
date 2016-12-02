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
        //Iterator<File> imoocsFiles=FileUtils.iterateFiles(null, args, true);
        IO io=new IO();
        //String one="resources/courses/en/Automata.json";
        String source="resources/courses/en/";
        //String target="resources/courses/coursesEn.csv"; //for csv
        String target="resources/courses/txt-en/";
        //String target="resources/csv/courses/en/Automata.txt";
        //Mooc automata=io.buildMoocFromJson(one);
        //io.writeMoocs2csv(automata, target);
        //Out.p(automata.toCsv());
        ArrayList <Mooc> moocs=io.buildMoocsFromJsons();
        //io.writeMoocs2csv(moocs, target); //No funciona, deixa cursos malament.
        io.writeMoocs2txt(moocs, target);
        

    }
    
    
    
   
}
