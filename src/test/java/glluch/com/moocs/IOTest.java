package glluch.com.moocs;

import com.glluch.utils.Filename;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author root
 */
public class IOTest {

    protected String dirMoocs= "tests/in/moocs/";
    protected String moocsIn="tests/in/moocsTxt/";
    protected String moocsOut="tests/out/moocsTxt/";
    
    public IOTest() {
    }

    /**
     * Test of buildMoocFromJson method, of class IO.
     * @throws java.lang.Exception
     */
    @Test
    public void testBuildMoocFromJson() throws Exception {
        System.out.println("IO buildMoocFromJson");
        String fileName = "tests/in/Data Mining Capstone.json";
        IO instance = new IO();
        File target = new File("tests/IObuildMoocFromJsonResult.txt");
        String expResult=FileUtils.readFileToString(target);
        Mooc mresult = instance.buildMoocFromJson(fileName);
        String result=mresult.toStringTest();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

   

    
    

 
    /**
     * Test of buildMoocsFromJsons method, of class IO.
     */
    @Test
    public void testBuildMoocsFromJsons() throws Exception {
        System.out.println("OI buildMoocsFromJsons");
        IO io = new IO();
        String result0="";
        io.setDirName(this.dirMoocs);
        File res=new File("tests/IOBuildMoocsFromJsonsResult.int");
       
        String expResult = FileUtils.readFileToString(res);
        ArrayList<Mooc> moocs = io.buildMoocsFromJsons();
        for (Mooc mooc:moocs){
           result0+=mooc.toString();
        }
        int result1=result0.hashCode();
        String result=String.valueOf(result1);
        assertEquals(expResult, result);
        
    }

    /*
     * The refered method doesn't work at that time 
     * Test of writeMoocs2csv method, of class IO.
    
    @Test
    public void testWriteMoocs2csv() throws Exception {
        System.out.println("IO writeMoocs2csv");
        List<Mooc> moocs = null;
        String target = "";
        IO io = new IO();
        String expResult = "";
        String result = io.writeMoocs2csv(moocs, target);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    * 
    */
    /**
     * Test of writeMoocs2txt method, of class IO.
     * @throws java.lang.Exception
     */
    @Test
    public void testWriteMoocs2txt() throws Exception {
        System.out.println("IO writeMoocs2txt");
        
        IO io = new IO();
        String [] ext = new String[1];
        ext[0]="txt";
        io.setDirName(this.dirMoocs);
        ArrayList<Mooc> moocs = io.buildMoocsFromJsons();
        io.writeMoocs2txt(moocs, this.moocsOut);        
        Collection<File> originals0= FileUtils.listFiles(new File(this.moocsIn), ext, false);
        Collection<File> created0= FileUtils.listFiles(new File(this.moocsOut), ext, false);
        Collection<String> originals1=Filename.onlyNames(originals0);
        Collection<String> created1=Filename.onlyNames(created0);
        Object[] original= originals1.toArray();
        Object[] created= created1.toArray();
        FileUtils.cleanDirectory(new File(this.moocsOut));
        
        
        assertArrayEquals("ERROR: The list of files are not equals",original,created);
    }

    
   

    

}
