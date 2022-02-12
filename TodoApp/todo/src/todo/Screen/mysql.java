/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package todo.Screen;
   import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author noman
 */
public class mysql {
    
     int counter=0;
  
   ArrayList<Integer> id = new ArrayList();
   ArrayList<String> subject = new ArrayList();
 ArrayList<String> content = new ArrayList();
 ArrayList<String> date = new ArrayList();
 Connection con; 

public mysql(){
    try {
     con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject", "root", "");
     show();
    } catch (SQLException ex) {
        Logger.getLogger(mysql.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    
    
    public  void show(){
    try {
        String query = "SELECT * FROM notes";

      // create the java statement
      Statement st = con.createStatement();
      
      // execute the query, and get a java resultset
      ResultSet result = st.executeQuery(query);
       
      if(result!=null){
       while (result.next())
      {
        counter++;
         id.add(result.getInt("id"));
        
       subject.add(result.getString("subject"));
         content.add(result.getString("content"));
         date.add(result.getString("date"));
        // print the results
      
      }
      st.close();  
      }
      else{
        System.out.println("failed to get");
      }
        
        
        
    } catch (SQLException ex) {
        Logger.getLogger(mysql.class.getName()).log(Level.SEVERE, null, ex);
    }

    }

public  void add(String Subject,String Content){
     Scanner s=new Scanner(System.in);
         try {
            // Class.forName("com.mysql.jdbc.Driver");
   PreparedStatement pst = con.prepareStatement("insert into notes(subject,content) values(?,?)");
 

  pst.setString(1,Subject);
 
       pst.setString(2, Content);
       
      int i = pst.executeUpdate();
      if(i!=0){
        System.out.println("added");
      }
      else{
        System.out.println("failed to add");
      }
    }
    catch (Exception e){
     System.out.println(e);
    }
}


public void update(String subject,String Content,int id){
             

     String sql = "update notes set subject='"+subject+"',content='"+Content+"' where id="+id+"";

    try { 
        Statement stmt = con.createStatement(); 
      
      stmt.executeUpdate(sql);
      System.out.println("Database updated successfully ");
    } catch (SQLException e) {
      e.printStackTrace();
    }
}


public  void delete(int id){
     Scanner s=new Scanner(System.in);
 String sql = "delete from notes where id="+id+"";

    try {
        Statement stmt = con.createStatement();
      
      stmt.executeUpdate(sql);
      System.out.println("Record deleted successfully");
     
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }


 protected void finalize()
    {
        System.out.println( "Data Reset.");
    } 




} 

 
