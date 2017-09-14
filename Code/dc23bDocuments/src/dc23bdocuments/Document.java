/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dc23bdocuments;

/**
 *
 * @author devincargill
 */
public class Document {
    
    private String title;
    private String author;
    private String body;
    private int version;
    
    public Document(String title, String author) {
        this.version = 0;
        this.title = title;
        this.author = author;
    }
    
    public Document(String title, String author, String body) {
        this.version = 1;
        this.title = title;
        this.author = author;
        this.body = body;
    }
    
    public void setTitle(String title){
        this.title = title;
        this.version++;
    }
    
    public void setAuthor(String author){
        this.author = author;
    }
    
    public void setBody(String body){
        this.body = body;
        this.version++;
    }
    
    public String getTitle(){
        return this.title;
    }
    
    public String getAuthor(){
        return this.author;
    }
    
    public String getBody(){
        return this.body;
    }
    
    public int getVersion(){
        return this.version;
    }
}
