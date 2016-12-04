/*
 * The MIT License
 *
 * Copyright 2016 Guillem LLuch Moll <guillem72@gmail.com>.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
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
