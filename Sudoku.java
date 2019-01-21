import java.util.Random;
import java.util.ArrayList;
public abstract class Sudoku{

  public abstract void createpuzzle(); // used to create the puzzle
  public abstract void InputNums(); // puts initial numbers in puzzle
  public abstract void answer(); // release answer to a puzzle
  public int RandInt(){
    Random randgen = new Random();
    return Math.abs(randgen.nextInt()) % 9 + 1;  // numbers to add to puzzle for StandardSudoku
  }
  public abstract void add(int row, int col, int num); // adding numbers
  public abstract void remove(int row, int col); // removing numbers
  public abstract boolean checkAnswer(); // checking answer of a puzzle
  public abstract boolean Mistake(int row, int col); // checking if a position has a mistake
  public abstract int groupNum(int row, int col); // finding the group number from row and column
  public abstract ArrayList<Integer> rowdir(int row); // a list of numbers in the same row
  public abstract ArrayList<Integer> coldir(int col); // a list of numbers in the same column
  public abstract ArrayList<Integer> groupdir(int groupnum); // a list of numbers in the same group
  public abstract String Markint(int row, int col); 
  public abstract void Markup();
}
