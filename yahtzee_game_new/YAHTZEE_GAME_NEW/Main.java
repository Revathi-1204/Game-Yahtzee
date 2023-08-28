package YAHTZEE_GAME_NEW;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	
//    	Scanner scanner = new Scanner(System.in);
//    	System.out.println("enter player 1 :");
    	
    	Game g1 = new Game();
    	Game g2 = new Game();
    	
    	System.out.println("player 1");
        Game.play_game(1);
    	System.out.println("player 2");

        Game.play_game(2);
        
    }
}