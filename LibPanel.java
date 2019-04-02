//Tsotras Stefanos
//icsd13189

package library;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Stefanos
 */
public class LibPanel extends JFrame implements ActionListener{
    
    
    private JPanel insert,search;
    
    //SEARCH TAB 
    private JPanel row1,row2,row3,row4,row5,row6,row7;
    private JLabel Slabel,Tlabel,Alabel,Glabel;
    private JTextField Tfield,Afield,Gfield;
    private JButton Tbutton,Abutton,Gbutton;
    
    //INSERT TAB
    private JPanel irow1,irow2,irow3,irow4,irow5;
    private JLabel S2label,Ilabel,T2label,A2label,G2label,Ylabel;
    private JTextField Ifield,T2field,A2field,G2field,Yfield;
    private JButton insertbutton;
    
    //SEARCH RESULT PANEL AND LABELS 
    private JPanel result;
    private JLabel I3label,T3label,A3label,G3label,Y3label,lalalabel;
    private JLabel lalalabel2,lalalabel3,lalalabel4,lalalabel5;
    private JLabel I,T,A,G,Y;
    
    private boolean written = false;
    
    //CONSTRUCTOR
    public LibPanel(){
        
        
        //GENERAL FRAME SETTINGS
        super("Library");         
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);   //NOW THE FRAME POPS UP TO THE CENTER OF THE SCREEN
        
        
        
        //CREATING SEARCH TAB
        
        //CREATING LABELS,TEXTFIELDS,BUTTONS
        Slabel =new JLabel("Search by :");
        
        Tlabel =new JLabel("Title");
        Tfield =new JTextField(10);
        Tbutton=new JButton("Search");
        
        Alabel =new JLabel("Author");
        Afield =new JTextField(10);
        Abutton=new JButton("Search");
        
        Glabel =new JLabel("Genre");
        Gfield =new JTextField(10);
        Gbutton=new JButton("Search");
        
        
        //SETTING UP THE LAYOUT AND ROWS
        
        search =new JPanel();
        //CREATING A GRIDLAYOUT OBJECT
        GridLayout glayout = new GridLayout(7,1);
        //AND APPLYING IT TO THE MAIN PANELS
        search.setLayout(glayout);
        
        //CREATING A FLOWLAYOUT OBJECT
        FlowLayout soflo = new FlowLayout(FlowLayout.CENTER,20,3);
        FlowLayout soflo2 = new FlowLayout(FlowLayout.LEADING,20,3);
        
        //AND APPLYING IT TO THE ROW PANELS
        row1 =new JPanel();
        row1.setLayout(soflo);
        row1.setBackground(Color.LIGHT_GRAY);
        row2 =new JPanel();
        row2.setLayout(soflo2);
        row2.setBackground(Color.LIGHT_GRAY);
        row3 =new JPanel();
        row3.setLayout(soflo2);
        row3.setBackground(Color.LIGHT_GRAY);
        row4 =new JPanel();
        row4.setLayout(soflo2);
        row4.setBackground(Color.LIGHT_GRAY);
        row5 =new JPanel();
        row5.setLayout(soflo2);
        row5.setBackground(Color.LIGHT_GRAY);
        row6 =new JPanel();
        row6.setLayout(soflo2);
        row6.setBackground(Color.LIGHT_GRAY);
        row7 =new JPanel();
        row7.setLayout(soflo2);
        row7.setBackground(Color.LIGHT_GRAY);
        
        //INSERT COMPONENTS INTO ROWS
        row1.add(Slabel);
        
        row2.add(Tlabel);
        row3.add(Tfield);
        row3.add(Tbutton);
        
        row4.add(Alabel);
        row5.add(Afield);
        row5.add(Abutton);
        
        row6.add(Glabel);
        row7.add(Gfield);
        row7.add(Gbutton);
        
        //INSERT ROWS INTO THE SEARCH PANEL
        search.add(row1);
        search.add(row2);
        search.add(row3);
        search.add(row4);
        search.add(row5);
        search.add(row6);
        search.add(row7);
        
        
        //LISTENER FOR THE SEARCH BY TITLE BUTTON
        Tbutton.addActionListener(this);
        
        //LISTENER FOR THE SEARCH BY AUTHOR BUTTON
        Abutton.addActionListener(this);
        
        //LISTENER FOR THE SEARCH BY GENRE BUTTON
        Gbutton.addActionListener(this);
        
        
        //CREATING INSERT TAB
        
        //CREATING LABELS,TEXTFIELDS,BUTTONS
        S2label =new JLabel("Insert a book into the library");
        
        Ilabel =new JLabel("ISBN   ");
        Ifield = new JTextField(10);
        
        T2label =new JLabel("Title    ");
        T2field =new JTextField(10);
        
        A2label =new JLabel("Author");
        A2field =new JTextField(10);
        
        G2label =new JLabel("Genre");
        G2field =new JTextField(10);
        
        Ylabel =new JLabel("Year of publication");
        Yfield =new JTextField(4);
        
        insertbutton =new JButton("Insert");
        
        
        insert =new JPanel();
        //CREATING A GRIDLAYOUT OBJECT
        GridLayout glayout2 = new GridLayout(5,1);
        //AND APPLYING IT TO THE MAIN PANELS
        insert.setLayout(glayout2);
        
        
        //AND APPLYING IT TO THE ROW PANELS
        irow1 =new JPanel();
        irow1.setLayout(soflo);
        irow1.setBackground(Color.LIGHT_GRAY);
        irow2 =new JPanel();
        irow2.setLayout(soflo2);
        irow2.setBackground(Color.LIGHT_GRAY);
        irow3 =new JPanel();
        irow3.setLayout(soflo2);
        irow3.setBackground(Color.LIGHT_GRAY);
        irow4 =new JPanel();
        irow4.setLayout(soflo2);
        irow4.setBackground(Color.LIGHT_GRAY);
        irow5 =new JPanel();
        irow5.setLayout(soflo);
        irow5.setBackground(Color.LIGHT_GRAY);
        
        //INSERT COMPONENTS INTO ROWS
        irow1.add(S2label);
        
        irow2.add(Ilabel);
        irow2.add(Ifield);
        
        irow2.add(T2label);
        irow2.add(T2field);
        
        irow3.add(A2label);
        irow3.add(A2field);
        
        irow3.add(G2label);
        irow3.add(G2field);
        
        irow4.add(Ylabel);
        irow4.add(Yfield);
        
        irow5.add(insertbutton);
        
        //INSERT ROWS INTO THE INSERT PANEL
        insert.add(irow1);
        insert.add(irow2);
        insert.add(irow3);
        insert.add(irow4);
        insert.add(irow5);
        
        
        //INSERT BUTTON ACTION LISTENER
        insertbutton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                //CREATING BOOK OBJECT WITH GIVEN TEXTFIELD INFO
                Book bobj = new Book(Integer.valueOf(Ifield.getText()), T2field.getText(),A2field.getText(),G2field.getText(),Integer.valueOf(Yfield.getText()));
                
                
                //CREATING A FILEOUTPUTSTREAM TO WRITE THE OBJECT TO A FILE
                try (ObjectOutputStream objout = new ObjectOutputStream(new FileOutputStream("books.txt",written))) {
                    
                    //WRITING OBJECT
                    objout.writeObject(bobj);
                    objout.flush();
                    
                    written = true;
                    
                    //CLOSING STREAM
                    objout.close();
                    
                    //
                    JOptionPane.showMessageDialog(insert, "Book inserted into the library");
                    
                } catch (IOException ex) {
                    Logger.getLogger(LibPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                //CLEARING THE FIELDS
                refresh();
            }
            
        });
        
        
        //CREATING A TABBEDPANE OBJECT
        JTabbedPane tab =new JTabbedPane();
        
        //ADDING PANELS TO TAB CONTAINER
        tab.add("Insert Book",insert);
        tab.add("Search",search);
        
        //ADDING TABPANE TO JFRAME AND PACKING
        add(tab);
        pack();
        
        
    }
    
    //CLEARING TEXTFIELD
    public void refresh(){
        Ifield.setText("");
        T2field.setText("");
        A2field.setText("");
        G2field.setText("");
        Yfield.setText("");
    }
    
    public void viewBook(Book book){
        
        //CREATING PANEL TO SHOW BOOKS INFO
        result = new JPanel();
        //CREATING A GRIDLAYOUT OBJECT
        GridLayout glayout3 = new GridLayout(5,3);
        result.setLayout(glayout3);
        result.setBackground(Color.LIGHT_GRAY);
        
        I = new JLabel(String.valueOf(book.getISBN()));
        T = new JLabel(book.getTitle());
        A = new JLabel(book.getAuthor());
        G = new JLabel(book.getGenre());
        Y = new JLabel(String.valueOf(book.getYear()));
        
        I3label =new JLabel("ISBN");
        T3label =new JLabel("Title");
        A3label =new JLabel("Author");
        G3label =new JLabel("Genre");
        Y3label =new JLabel("Published");
        
        lalalabel =new JLabel(":");
        lalalabel2 =new JLabel(":");
        lalalabel3 =new JLabel(":");
        lalalabel4 =new JLabel(":");
        lalalabel5 =new JLabel(":");
        
        
        result.add(I3label);
        result.add(lalalabel);
        result.add(I);
        result.add(T3label);
        result.add(lalalabel2);
        result.add(T);
        result.add(A3label);
        result.add(lalalabel3);
        result.add(A);
        result.add(G3label);
        result.add(lalalabel4);
        result.add(G);
        result.add(Y3label);
        result.add(lalalabel5);
        result.add(Y);
        
        
        JOptionPane.showMessageDialog(this, result, "Search Result", JOptionPane.PLAIN_MESSAGE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        //BOOK OBJECT HELPING COMPARE THE CURRENT READ BOOK
        //OBJECT WITH THE STRING GIVEN
        Book curbook;
        boolean flag = false;
        
        try {
            
            //CREATING INPUTSTREAM TO READ FROM THE TXT 
            ObjectInputStream objin = new ObjectInputStream(new FileInputStream("books.txt"));
            
                try{
                
                //CURRENT OBJECT READ INSERTED TO CURBOOK
                //curbook =(Book) objin.readObject();
                
                //CHECKING WHICH BUTTON WAS PRESSED
                if(e.getSource() == Tbutton){
                    
                    //WHILE THE OBJECT READ IS NOT NULL
                    while((curbook =(Book) objin.readObject()) != null){
                    
                        //IF THE TITLE CONTAINED ON THE CURRENT BOOK OBJECT THAT WAS READ
                        //EQUALS THE ONE THE USER ENTERED 
                        if(curbook.title.equals(Tfield.getText())){

                            //THEN CALL VIEWBOOK AND SHOW 
                            //BOOK INFO
                            viewBook(curbook);
                            flag = true;
                        }
                        
                    }
                    
                    //IF LOOP ENDS 
                    if(!flag){
                        JOptionPane.showMessageDialog(this, "Book's title not found");
                    }
                    //CLEARING THE TEXTFIELD
                    Tfield.setText("");
                }
                
                else if(e.getSource() == Abutton){
                    
                    while((curbook =(Book) objin.readObject()) != null){
                    
                        if(curbook.author.equals(Afield.getText())){

                            viewBook(curbook);
                            flag = true;
                        }
                    
                    }
                    
                    if(!flag){
                        JOptionPane.showMessageDialog(this, "Author not found");
                    }
                    
                    Afield.setText("");
                }
                
                else if(e.getSource() == Gbutton){
                    
                    while((curbook =(Book) objin.readObject()) != null){
                    
                        if(curbook.genre.equals(Gfield.getText())){

                            viewBook(curbook);
                            flag = true;
                        }
                       
                    }
                    
                    if(!flag){
                        JOptionPane.showMessageDialog(this, "Genre not found");
                    }
                    
                    Gfield.setText("");
                }


                }
                //WHEN THE THE FILE REACH THE END IT TRIGGERS
                catch(EOFException ex){
                    System.out.println("File end");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(LibPanel.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("Error");
                }
            
            
            //CLOSING THE STREAM
            objin.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LibPanel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error2");
        } catch (IOException ex) {
            System.out.println("Error3");
            Logger.getLogger(LibPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }

    
}
