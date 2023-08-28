package YAHTZEE_GAME_NEW;

import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;


import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

class BlockCategory {
	  HashSet chosenCategories = new HashSet<>();
	  HashMap <String,Integer> chosenCategoriesWithValues = new HashMap<>();
	 static String category;
	 public static int round=0;
	 DataBase d = new DataBase();
	 
	 
    public  void selectCategory(int flag)
    {
       //System.out.println( Game.categorySums);
    	round++;
    	Scanner scanner = new Scanner(System.in);
    	 for (Entry<String, Integer> entry :Game.categorySums.entrySet())
    	 {
    		 if(entry.getValue()!=0 && !chosenCategories.contains(entry.getKey()))
    		 {
    			 System.out.println(entry.getKey());
    			 
    		 }
    	 }
    	 
    	 	System.out.println(chosenCategories);
        	System.out.println("Score  " + Game.score);

    	 while(true)
    	 {
    		 System.out.println("\nchoose a category");
    		  category = scanner.nextLine();
    		 
    		 if(chosenCategories.contains(category))
    		 {
    			 System.out.println("choose other category");
    		 }
    		 else
    		 {
//    			 System.out.println("choose a category");
//        		 category = scanner.nextLine();
        		 chosenCategories.add(category);
        		 chosenCategoriesWithValues.put(category,Game.categorySums.get(category));
        		 Game.score = Game.score + Game.categorySums.get(category);
        		
        		 d.insertdata(flag);
        		 d.getData(flag);
        		 
        		 }
        		 break;
    		 }
    	 }
    	 
		
    }
    

