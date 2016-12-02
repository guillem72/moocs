package glluch.com.moocs;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author root
 */
public class IOTest {

    public IOTest() {
    }

    /**
     * Test of buildMoocFromJson method, of class IO.
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

}
