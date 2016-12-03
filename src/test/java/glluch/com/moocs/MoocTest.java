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

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;


/**
 *
 * @author Guillem LLuch Moll <guillem72@gmail.com>
 */
public class MoocTest {
 
    protected String textFileName="tests/in/Data Mining Capstone.json";
    
    public MoocTest() {
        
    }

    
    
    /**
     * Test of toString method, of class Mooc.
     * @throws java.io.IOException
     */
    @Test
    public void testToString() throws IOException {
        System.out.println("Mooc.toString");
        IO io = new IO();
        Mooc mooc = io.buildMoocFromJson(this.textFileName);
        File target = new File("tests/MooctestToStringResult.txt");
        String expResult=FileUtils.readFileToString(target);
        String result = mooc.toString();
        assertEquals(expResult, result);
        
    }

    /*
     * Test of toCsv method, of class Mooc.
    
    @Test
    public void testToCsv() {
        System.out.println("toCsv");
        Mooc instance = new Mooc();
        String expResult = "";
        String result = instance.toCsv();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
     
    }
     */

  
  
    
}
