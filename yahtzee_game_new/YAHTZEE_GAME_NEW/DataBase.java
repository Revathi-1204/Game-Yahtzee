package YAHTZEE_GAME_NEW;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;



public class DataBase {

	
	public void insertdata(int flag) {
	Connection cnx = null;
	 PreparedStatement stmt = null;
	 
	 try {
		 String insert;
		 if(flag==1)
		  insert ="insert into yahtzeeScoreBoard1 (round,score,category) values(?,?,?)";
		 
		 else
			 insert ="insert into yahtzeeScoreBoard2 (round,score,category) values(?,?,?)";
		 cnx=DriverManager.getConnection("jdbc:mysql://localhost:3306/yahtzee","saisidharthak","root");
		
		 
		 stmt= cnx.prepareStatement(insert);
		 stmt.setInt(1, BlockCategory.round);
		 stmt.setInt(2,Game.score);
		 stmt.setString(3, BlockCategory.category);
		 stmt.executeUpdate();
		 System.out.println("Data Inserted successfully!!");
		 stmt.close();
		 cnx.close();
		}
	 catch(Exception e) {
		 e.printStackTrace();
	 }
	
	}
	
	
	
	
	
	
	public void getData(int flag){
		Connection cnx = null;
		 Statement stmt = null;
		 ResultSet rs= null;
		 
		 try {
			 cnx=DriverManager.getConnection("jdbc:mysql://localhost:3306/yahtzee","saisidharthak","root");
			 stmt =cnx.createStatement();
			 if(flag==1)
				 rs=stmt.executeQuery("select * from yahtzeeScoreBoard1");			 
			 else
				 rs=stmt.executeQuery("select * from yahtzeeScoreBoard2");			 
			 System.out.println("|round | score  |category   |");
			 while(rs.next()) {
				 int round= rs.getInt("round");
				 int score = rs.getInt("score");
				 String category = rs.getString("category");
				 System.out.println("|"+round+" | "+score+"  |"+category+"   |");
			 }
			 stmt.close();
			 cnx.close();
			}
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		
	}
	
	public static void TruncateData(){
		Connection cnx = null;
		 Statement stmt = null;
		 ResultSet rs= null;
		 
		 try {
			 cnx=DriverManager.getConnection("jdbc:mysql://localhost:3306/yahtzee","saisidharthak","root");
			 stmt =cnx.createStatement();
			 rs=stmt.executeQuery("Truncate table yahtzeeScoreBoard");
			 System.out.println("round,score,category");
			 while(rs.next()) {
				 int round= rs.getInt("round");
				 int score = rs.getInt("score");
				 String category = rs.getString("category");
				 System.out.println(round+","+score+","+category);
			 }
			 stmt.close();
			 cnx.close();
			}
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		
	}


}
