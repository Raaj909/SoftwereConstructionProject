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
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author noman
 */
public class AddNotes extends JFrame implements FocusListener,ActionListener{
    
    
    JTextField subject;
    JTextArea content;
    JButton back,addNew,update;
       mysql s; 
    String Stext="",Ctext="";
    int id;
public AddNotes(){
    
       s = new mysql();
     this.setSize(600,700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(123,50,250));
        this.setTitle("New Notes");
       this.setLayout(new BorderLayout(10,30));
        //this.setLayout(new GridLayout(1,2));
        this.add(subject(),BorderLayout.PAGE_START);
        this.add(label("Subject"),BorderLayout.NORTH);
       
        this.add(label("Subject"),BorderLayout.NORTH);
        this.add(label("Description"),BorderLayout.CENTER);
       this.add(content(),BorderLayout.CENTER);
       this.add(button(),BorderLayout.SOUTH);
       this.add(back(),BorderLayout.WEST);
        this.setVisible(true);
           
    }   
public AddNotes(String Subject,String Content,int i){
    id = i;
     
       s = new mysql();
    Ctext = Content;
    Stext  = Subject;
       System.out.println(i+"\n"+Subject+"\n"+Content);
    
     this.setSize(500,700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(123,50,250));
        this.setTitle("New Notes");
       this.setLayout(new BorderLayout(10,30));
        //this.setLayout(new GridLayout(1,2));
        this.add(subject(),BorderLayout.PAGE_START);
        this.add(label("Subject"),BorderLayout.NORTH);
       
        this.add(label("Subject"),BorderLayout.NORTH);
        this.add(label("Description"),BorderLayout.CENTER);
       this.add(content(),BorderLayout.CENTER);
       this.add(button(),BorderLayout.SOUTH);
       this.add(back(),BorderLayout.WEST);
        this.setVisible(true);
        
        
 }
 
 

 public JPanel subject(){
          JPanel subjectPanel = new JPanel(); 
          subjectPanel.setBackground(new Color(123,50,250));
         subjectPanel.setBorder(BorderFactory.createEmptyBorder(30, 20, 30, 20));
          subject = new JTextField("Subject",25);
         // subject.setBackground(new Color(123,50,250));
         subject.setForeground(Color.GRAY);
          JLabel title = new JLabel("Subject");
          title.setFont(new Font("Verdana", Font.PLAIN, 18));
          subjectPanel.add(title);
         subjectPanel.add(subject);
         //subject.setBounds(20, 20, 100, 20);
        // subject.setMaximumSize(new Dimension(10,20));
        subject.addFocusListener(this);
         return subjectPanel;
    }
    
   public JPanel content(){
       JPanel contentPanel = new JPanel(); 
            contentPanel.setLayout(new BorderLayout());
          contentPanel.setBackground(new Color(123,50,250));
         contentPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 10, 20));
          content = new JTextArea("\t\tNote Description");
         content.setForeground(Color.WHITE);
         JLabel title = new JLabel("Note Description : ");
          title.setFont(new Font("Verdana", Font.PLAIN, 18));
          content.addFocusListener(this);
          //content.setMinimumSize(new Dimension(370,500));
        
          contentPanel.add(title,BorderLayout.NORTH);
          contentPanel.add(content,BorderLayout.CENTER);
         //content.setBounds(80, 80, 370, 500);
         //content.setPreferredSize(new Dimension(370,500));
         
         return contentPanel;
    }
   

 public JPanel button(){
            if(Stext=="")
            {
                JPanel buttonPanel = new JPanel(); 
          buttonPanel.setBackground(new Color(123,50,250));
         buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
       addNew = new JButton("Add Note");
     addNew.addActionListener(this);
       //subject.setBounds(20, 20, 100, 20);
        // subject.setMaximumSize(new Dimension(10,20));
        buttonPanel.add(addNew);
         return buttonPanel;
            }
            else{
            JPanel buttonPanel = new JPanel(); 
          buttonPanel.setBackground(new Color(123,50,250));
         buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
       update = new JButton("Update Note");
     update.addActionListener(this);
       //subject.setBounds(20, 20, 100, 20);
        // subject.setMaximumSize(new Dimension(10,20));
        buttonPanel.add(update);
         return buttonPanel;
            
            }
    }

 public JPanel back(){
          JPanel buttonPanel = new JPanel(); 
          buttonPanel.setBackground(new Color(123,50,250));
       //  buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
       back = new JButton("Back");
       back.addActionListener(this); 
       //subject.setBounds(20, 20, 100, 20);
        // subject.setMaximumSize(new Dimension(10,20));
     
        buttonPanel.add(back);
         return buttonPanel;
    }
   
   
   
   
   public JLabel label(String name){
   JLabel label = new JLabel(name);
   return label;
   }
    
    
 @Override
    public void focusGained(FocusEvent e) {
        if(e.getSource()==subject){
        if (subject.getText().equals("Subject")) {
            subject.setText(Stext);
      
            subject.setForeground(Color.BLACK);
    
        }}
        if(e.getSource()==content){
        if (content.getText().equals("\t\tNote Description")) {
            content.setText(Ctext);
            content.setForeground(Color.BLACK);
        }}
    } 
         
     
    

    @Override
    public void focusLost(FocusEvent e) {
       if(e.getSource()==subject){
        if (subject.getText().isEmpty()) {
            subject.setForeground(Color.WHITE);
            subject.setText("Subject");
        }}
        if(e.getSource()==content){
         if (content.getText().isEmpty()) {
            content.setForeground(Color.WHITE);
            content.setText("\t\tNote Description");
        }}
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    if(e.getSource()==back){
     new NoteApp();
        this.dispose();
    } 
    else if(e.getSource()==addNew){
        String Subject = subject.getText();
        String Content = content.getText();
        s.add(Subject,Content);
        new NoteApp();
        this.dispose();
    
    }
     else if(e.getSource()==update){
        String Subject = subject.getText();
        String Content = content.getText();
        s.update(Subject,Content,id);
        new NoteApp();
        this.dispose();
    
    }
    
    }
}
