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

import com.glluch.utils.Filename;
import com.glluch.utils.Out;
import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.Validate;

/**
 * This class is for read and write specific files.
 *
 * @author Guillem LLuch Moll
 */
public class IO {

    protected String dirName = "resources/courses/en";

    public String getDirName() {
        return dirName;
    }

    public void setDirName(String dirName) {
        this.dirName = dirName;
    }

    protected transient boolean verbose = true;

    public boolean isVerbose() {
        return verbose;
    }

    public void setVerbose(boolean verbose) {
        this.verbose = verbose;
    }

    protected transient boolean debug = true;

    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    protected transient String csvFieldSep = "\t";

    public String getCsvFieldSep() {
        return csvFieldSep;
    }

    public void setCsvFieldSep(String csvFieldSep) {
        this.csvFieldSep = csvFieldSep;
    }

    /**
     * The header when producing a csv file with the information of the moocs
     * from jsons. This order is related with toCsv() in the Mooc class
     *
     * @see Mooc#toCsv()
     */
    protected transient String csvHeader = "title" + csvFieldSep + "text" + csvFieldSep + "source" + csvFieldSep + "language";

    public String getCsvHeader() {
        return csvHeader;
    }

    public void setCsvHeader(String csvHeader) {
        this.csvHeader = csvHeader;
    }

    /**
     * Reads a json file containing the information of a mooc and return a Mooc
     * instance.
     *
     * @param fileName the name of the json file (with its path).
     * @return Mooc filled with the information provided by the json file.
     * @throws IOException if file is missing, for example.
     */
    public Mooc buildMoocFromJson(String fileName) throws IOException {
        Mooc mooc = null;
        Gson gson = new Gson();
        debug("Reading " + fileName);
        String json = FileUtils.readFileToString(new File(fileName));
        try {
            mooc = gson.fromJson(json, Mooc.class);
        } catch (Exception e) {
            debug("ERROR " + e.getMessage());
        }
        if (StringUtils.isEmpty(mooc.getTitle())) {

            String title = Filename.OnlyName(fileName);
            debug("WARNING: " + fileName + " hasn't any title. Its name will be: " + title);
            mooc.setTitle(title);
        }
        return mooc;
    }

    /**
     * Reads every json in a directory and build a Mooc instance for every one.
     *
     * @return an ArrayList made by the objects create from the json files in a
     * directory
     * @throws IOException
     */
    public ArrayList<Mooc> buildMoocsFromJsons() throws IOException {
        ArrayList<Mooc> moocs = new ArrayList<>();
        SuffixFileFilter jsonsff = new SuffixFileFilter(".json");
        Iterator<File> cfiles = FileUtils.iterateFiles(new File(this.dirName), jsonsff, null);
        show("Reading directory with MOOCs");

        while (cfiles.hasNext()) {
            //Out.p("Cfiles");
            File cf = (File) cfiles.next();
            //Out.p("Reading "+cf.getName());
            String filename = cf.getCanonicalPath();
            Mooc mooc = this.buildMoocFromJson(filename);
            if (mooc != null) {
                moocs.add(mooc);
            }

        }
        show(moocs.size() + " MOOCs retrieved");
        return moocs;
    }

    /**
     * Try to write a list of moocs in a csv file (for use in R quanteda, for example)
     * It doesn't work properly beacuse there are issues with limits of text and tabs. 
     * TODO: use a library as csv commons.
     * @param moocs
     * @param target
     * @return
     * @throws IOException
     */
    public String writeMoocs2csv(List<Mooc> moocs, String target) throws IOException {
        String res = this.csvHeader;
        for (Object mooc0 : moocs) {
            Mooc mooc = (Mooc) mooc0;
            res += System.lineSeparator() + mooc.toCsv();
        }
        FileUtils.write(new File(target), res);
        return res;

    }
    
    /**
     * Writes a txt for every mooc. That txt file contains the fields from Mooc toString() method
     * @param moocs the list of moocs to be written.
     * @param target the directory where the files will be written
     * @throws IOException
     * @see Mooc#toString() 
     */
    public void writeMoocs2txt(List<Mooc> moocs, String target) throws IOException {
        for (Object mooc0 : moocs) {

            Mooc mooc = (Mooc) mooc0;
            String title = mooc.getTitle();
            if (StringUtils.isEmpty(title)) {
                
            }
            FileUtils.write(new File(target + title + ".txt"), mooc.toString());
        }
        show("Txt files written in "+target);

    }

    /**
     * Sent a message to the console depens on the parametre verbose. 
     * If it is true (on), the text is shown.
     * @param text The text to be shown
     */
    protected void show(String text) {
        if (this.verbose) {
            Out.p(text);
        }
    }

    /**
     * Sent a message to the console depens on the parametre debug.
     * If it is true (on), the text is shown.
     * @param text The text to be shown
     */
    protected void debug(String text) {
        if (this.debug) {
            Out.p(text);
        }
    }

}
