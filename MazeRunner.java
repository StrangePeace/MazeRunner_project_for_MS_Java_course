import java.util.*;
public class MazeRunner {
    public static Maze myMap = new Maze();
    public static final Scanner input = new Scanner(System.in);

    public static void main (String[] args){
        //establishing variables
        String direction = "";
        intro();
        int moves = 0;
        while(!myMap.didIWin()) {
            userMover();
            moves++;
            movesMessage(moves);
            if (myMap.didIWin()) {
                System.out.println("Congratulations, you made it out alive! And you did it in " + moves + " moves");

            }
        }
    }

    public static void intro(){
        //Welcomes user and prints new map
        System.out.println("Welcome to Maze Runner!");
        System.out.println("Here is your current position:");
        myMap.printMap();

    }

    public static void userMover(){
        //takes in desired direction for move and verifies if that direction is valid and possible.
            System.out.println("Where would you like to move? Please choose (R)ight, (L)eft, (U)p, or (D)own ");
            String move = input.next();

            while (!"RLUD".contains(move)) {
                System.out.println("Where would you like to move? Please choose (R)ight, (L)eft, (U)p, or (D)own ");
                move = input.next();
            }

            if (move.equals("R") && (myMap.canIMoveRight())) {
                myMap.moveRight();
            } else if (move.equals("L") && myMap.canIMoveLeft()) {
                myMap.moveLeft();
            } else if (move.equals("U") && myMap.canIMoveUp()) {
                myMap.moveUp();
            } else if (move.equals("D") && myMap.canIMoveDown()) {
                myMap.moveDown();
            } else if (myMap.isThereAPit(move)) {
                navigatePit(move);
            } else {
                System.out.println("Sorry, you’ve hit a wall.");
            }

            myMap.printMap();
            }


    public static void navigatePit(String userChoice){
        Scanner input = new Scanner(System.in);
        System.out.print("Watch out! There's a pit ahead, jump it? (Y/N) ");
        String option = input.next();
        if(option.equalsIgnoreCase("y")) {
            myMap.jumpOverPit(userChoice);
        }
    }

    public static void movesMessage(int moveCount){
        //This method prints warning messages to console depending on the number of moves the user has made.
        if (moveCount == 50) {
        System.out.println("Warning: You have made 50 moves, you have 50 remaining before the maze exit closes");
        } else if (moveCount == 75) {
        System.out.println("Alert! You have made 75 moves, you only have 25 moves left to escape.");
        } else if (moveCount == 90) {
        System.out.println("DANGER! You have made 90 moves, you only have 10 moves left to escape!!");
        } else if (moveCount == 100) {
        System.out.println("Oh no! You took too long to escape, and now the maze exit is closed FOREVER >:[");
        }
        }

    }




