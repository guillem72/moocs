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

import com.glluch.utils.CsvWriter;
import com.glluch.utils.Out;
import org.apache.commons.lang.StringUtils;

/**
 * This class contain a MOOC.
 * @author Guillem LLuch Moll
 */
public class Mooc {

    
    private String source;
    

    public String getSource() {
        return this.source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    private String description;

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String contents;

    public String getContents() {
        return this.contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    private String requirements;

    public String getRequirements() {
        return this.requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    private String effort;

    public String getEffort() {
        return this.effort;
    }

    public void setEffort(String effort) {
        this.effort = effort;
    }

    private String language;

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    private String url;

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private String title;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String courseraId;

    public String getCourseraId() {
        return this.courseraId;
    }

    public void setCourseraId(String courseraId) {
        this.courseraId = courseraId;
    }

    private String subjects;

    public String getSubjects() {
        return this.subjects;
    }

    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }

   
    //TODO handle this, because it could be a valuable metadata.
    private  transient String instructors;

    public String getInstructors() {
        return instructors;
    }

    public void setInstructors(String instructors) {
        this.instructors = instructors;
    }
    
    
    
    protected  transient boolean debug=true;
    
    protected transient String emptySymbol="\"\"";
   
    public String getEmptySymbol() {
        return emptySymbol;
    }

    public void setEmptySymbol(String emptySymbol) {
        this.emptySymbol = emptySymbol;
    }
    
    protected transient String csvFieldSep="\t";

    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public String getCsvFieldSep() {
        return csvFieldSep;
    }

    public void setCsvFieldSep(String csvFieldSep) {
        this.csvFieldSep = csvFieldSep;
    }
    
    
    
    
    public Mooc() {
        
    }    
  
    
    
   //End declarations, setter and getters
    
    @Override
    public String toString(){
     String info="";
     if (StringUtils.isEmpty(this.title)){
      debug("There is a mooc without title");
     }
     
        if (StringUtils.isNotEmpty(this.getSubjects()))
        {
            
            info+=StringUtils.normalizeSpace(this.getSubjects())+" ";
        }
          if (StringUtils.isNotEmpty(this.contents))
        {
            info+=StringUtils.normalizeSpace(this.contents)+" ";
        }
              if (StringUtils.isNotEmpty(this.description))
        {
            info+=StringUtils.normalizeSpace(this.description);
        }       
          
     return info;
    }
    
    /**
     * Creates a line to put in a convinient csv. More precisely 
     * title, text, source, language
     * @return a line for a csv file with the order  title, text, source, language
     * @see IO#csvHeader
     */
    public String toCsv(){
       
        String res="";
        
         if (StringUtils.isNotEmpty(this.title))
        {
            res+="\""+CsvWriter.csvText(this.title.trim())+"\""+this.csvFieldSep;
        }
         else {
             debug("There is a mooc without title");
             res+=this.emptySymbol+this.csvFieldSep;
         }
         
         res+="\""+this.toString()+"\" ,";
         
         if (StringUtils.isNotEmpty(this.source))
        {
            res+="\""+CsvWriter.csvText(this.source)+"\""+this.csvFieldSep;
        }
          else {
             res+=this.emptySymbol+this.csvFieldSep;
         }
        
        if (StringUtils.isNotEmpty(this.language))
        {
            res+="\""+CsvWriter.csvText(this.language)+"\""+this.csvFieldSep;
        }
         else {
             res+=this.emptySymbol+this.csvFieldSep;
         }
        
        
        
        return res;
    }
    
      /**
     * A method for serizalize the object as an String.
     * @return an string as a result of concatenate all the fields.
     */    
    public String toStringTest(){
    String res=null;
    res+=this.title+" "+this.description+" "+this.contents+" "+this.source+" ";
    res+=this.effort+" "+this.language+" "+this.url+" "+this.subjects;
    return res;
    }
    
      protected void debug(String text){
        if (this.debug){
        Out.p(text);
        }
    }
}
