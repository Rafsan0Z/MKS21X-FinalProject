import java.util.Random;
import java.util.ArrayList;
public abstract class Sudoku{

  public abstract void createpuzzle();
  public abstract void InputNums();
  public abstract void answer();
  public int RandInt(){
    Random randgen = new Random();
    return Math.abs(randgen.nextInt()) % 9 + 1;
  }
  public void add(int row, int col, int num){
    puzzle[row][col] = " " + num;
  }

  public void remove(int row, int col){
    puzzle[row][col] = "__";
  }
  public abstract boolean checkAnswer();
  public abstract boolean Mistake(int row, int col);
  public abstract int groupNum(int row, int col);
  public abstract ArrayList<Integer> rowdir(int row);
  public abstract ArrayList<Integer> coldir(int col);
  public abstract ArrayList<Integer> groupdir(int groupnum);
  public abstract String Markint(int row, int col);
  public abstract void Markup();
}
