//Tsotras Stefanos
//icsd13189
package library;

import java.io.Serializable;

/**
 *
 * @author Stefanos
 */
public class Book implements Serializable{
    
    //DHLWSH IDIOTHTWN
    int ISBN;
    String title;
    String author;
    String genre;
    int year;
    
    
    //CONSTRUCTOR VIVLIOU
    public Book(int ISBN,String title,String author,String genre,int year){
        
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.year = year;
        
    }
    
    //GETS TWN IDIOTHTWN
    public int getISBN(){
        return ISBN;
    }
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public String getGenre(){
        return genre;
    }
    public int getYear(){
        return year;
    }
            
    
}
