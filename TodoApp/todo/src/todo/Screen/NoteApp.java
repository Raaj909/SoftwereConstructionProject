/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package todo.Screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author noman
 */
public class NoteApp extends JFrame implements FocusListener,ActionListener {
    
    
    JTextField search;
     JButton add,delete,edit,searchbutton;
   mysql s; 
   int index;
    JFrame frame;
            
    NoteApp(){
        
       s = new mysql();
      
        
          JScrollBar vbar=new JScrollBar(JScrollBar.VERTICAL, 30, 40, 0, 500);
         vbar.addAdjustmentListener((AdjustmentEvent e) -> {
             NoteApp.this.repaint();
          });
         
         frame = new JFrame();
        frame.setSize(600,700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(123,50,250));
        frame.setTitle("Notes Keeper");
        frame.setLayout(new BorderLayout());
        frame.add(header(),BorderLayout.NORTH);
        frame.add(center(),BorderLayout.CENTER);
        frame.add(add(),BorderLayout.SOUTH);
    //    this.add(vbar,BorderLayout.EAST);
        frame.setVisible(true);
           
    }
    
    public JPanel header(){
    
        JLabel heading = new JLabel("My Notes "); 
        heading.setFont(new Font("Verdana", Font.PLAIN, 28));
        
        
    JPanel header = new JPanel();
      Border border = BorderFactory.createLineBorder(Color.black,2);
      header.setBorder(border);
    header.setBackground(new Color(123,50,250));
    header.add(heading);
    header.add(search());
    header.add(searchbutton());
    
    
    return header;
    }
    
  
    
    
    
    public JPanel center(){
            
    JPanel center = new JPanel();
      Border border = BorderFactory.createLineBorder(Color.black,2);
      center.setBorder(border);
    center.setBackground(new Color(123,50,250));
   
   // center.setPreferredSize(new Dimension(35, 19));
    center.add(loop());
    return center;
    }
    
    public JPanel loop(){
        JPanel allNotes = new JPanel();
         allNotes.setLayout(new GridLayout(500,1));
        allNotes.setBackground(new Color(123,50,250)); 
        for(index=0;index<s.counter;index++){
        allNotes.add(noteDetail(index));
        }
        return allNotes;
    }
    
    public JPanel noteDetail(int i){
          
        JPanel note = new JPanel();
          Border border = BorderFactory.createLineBorder(Color.black,1);
      note.setBorder(border);
        note.setLayout(new GridLayout(2,2));
         note.setBackground(new Color(123,50,250));  
          
          JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(123,50,250));
        JLabel subject = new JLabel(i+" Suject : "+s.subject.get(i));
         subject.setFont(new Font("Verdana", Font.PLAIN, 16));
       topPanel.add(subject);
         JPanel sidePanel = new JPanel();
        sidePanel.setBackground(new Color(123,50,250));
        sidePanel.add(deletebutton());
        
        JPanel downPanel = new JPanel();
        downPanel.setBackground(new Color(123,50,250));
        JLabel date = new JLabel("Date : "+s.date.get(i));
        date.setFont(new Font("Verdana", Font.PLAIN, 14));
      
        downPanel.add(editbutton());
        downPanel.add(date);
        
         
        note.add(topPanel);
        note.add(sidePanel);
        note.add(downPanel);
       
//      topPanel.setLayout(new BorderLayout());
//        topPanel.add(subject,BorderLayout.NORTH);
//        topPanel.add(sidePanel,BorderLayout.EAST);
//        
    
    return note;
    
    }
    
    
    
    public JPanel add(){       
    JPanel add = new JPanel();
    Border border = BorderFactory.createLineBorder(Color.black,5);
    add.setBorder(border);
    add.setBackground(new Color(123,50,250));
   add.add(addbutton());
    //add.setPreferredSize(new Dimension(35, 19));
    return add;
    }
       
    
    
    
    public JTextField search(){
         search = new JTextField("Search Note",15);
         search.setForeground(Color.GRAY);
         search.addFocusListener(this);
         
         return search;
    }
    
    public JButton searchbutton(){
    
        searchbutton = new JButton("Search");
        searchbutton.addActionListener(this);
        return searchbutton;
    
    }
    
    public JButton editbutton(){
    
         edit = new JButton("Edit");
        edit.addActionListener(new editing(index));
        return edit;
    
    }
    public JButton deletebutton(){
    
         delete = new JButton("Delete");
        delete.addActionListener(new deleting(index));
        return delete;
    
    }
    public JButton addbutton(){
    
         add = new JButton("Add NEW Note");
        add.addActionListener(this);
        return add;
    
    }
    
    
    
    
    
    
    
 @Override
    public void focusGained(FocusEvent e) {
        if (search.getText().equals("Search Note")) {
            search.setText("");
            search.setForeground(Color.BLACK);
        }
    } 
         
     
    

    @Override
    public void focusLost(FocusEvent e) {
        if (search.getText().isEmpty()) {
            search.setForeground(Color.GRAY);
            search.setText("Search Note");
        }
    }
    

    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==searchbutton){
        System.out.println("Searching ");//To change body of generated methods, choose Tools | Templates.
       }else if(e.getSource()==add){
        System.out.println("adding ");
       new AddNotes();
        frame.dispose();
       }
       else if(e.getSource()==delete){
        System.out.println("deleting "+e.getID());
       }
       else if(e.getSource()==edit){
        
       }
       else if(e.getSource()==search){
        System.out.println("Searching ");
       }
       
       
           }

     public class deleting implements ActionListener{
         int val;  
         public deleting(int i){
                 this.val =i;  
         }
        @Override
        public void actionPerformed(ActionEvent e) {
           System.out.println("Delete "+s.id.get(val));
          
           s.delete(s.id.get(val));
           s = null;
           s.counter = 0;
          System.gc();
           new NoteApp();
           frame.dispose();
           
        }
    }
    
    
    public class editing implements ActionListener{
        int val; 
        
        public editing(int i){
        this.val =i; 
       
        }
        @Override
        public void actionPerformed(ActionEvent e) {
           System.out.println("edit "+s.id.get(val));
         System.out.println(s.subject.get(val)) ;
      System.out.println(s.content.get(val));
           new AddNotes(s.subject.get(val),s.content.get(val),s.id.get(val));
         
//           s = null;
//           s.counter = 0;
//          System.gc();
           frame.dispose();
        
        }
    }
    
}
