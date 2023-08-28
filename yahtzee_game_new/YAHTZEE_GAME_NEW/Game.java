package YAHTZEE_GAME_NEW;
import java.util.*;

public class Game {
    public static final int max_round = 3;
    public int round;
    public static int res1;
    public static int res2;
    public int score_arr[];
    public static int score;
    public static Map<String, Integer> categorySums = new HashMap<>();
    public static String arr[] = {"Three of a Kind", "Four of a kind", "Full house",
            "Small Straight", "Large Straight", "YAHTZEE", "Choice"};
    public static String nums[] = {"one", "two", "three", "four", "five", "six"};
    static BlockCategory b = new BlockCategory();

    public static void play_game(int flag) {
    	
    	
        for (int i = 1; i <= max_round; i++) {
            play_round(i , flag);
        }
        System.out.println("Player " + flag + " score" + score);

        b.chosenCategories.clear();;
        b.chosenCategoriesWithValues.clear();
        score=0;
 
    }

    public static void play_round(int round_number , int flag)
    {
        Dice dice = new Dice();
        dice.roll_dice();
        Lowerpart.choose_category(dice.dice_map);
        UpperPart.upper_part(dice.dice_map);
        System.out.println(categorySums);

        b.selectCategory(flag);

        
        categorySums.clear();
    }

	
}
