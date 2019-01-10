import java.util.Random;
public abstract class Sudoku{

  public abstract void createpuzzle();
  public abstract void InputNums();
  public abstract void answer();
  public int RandInt(){
    Random randgen = new Random();
    return Math.abs(randgen.nextInt()) % 9 + 1;
  }
  public abstract void add(int row, int col, int num);
  public abstract void remove(int row, int col);
  public abstract boolean checkAnswer();
  public abstract boolean Mistake(int row, int col);
  public abstract int groupNum(int row, int col);
  public abstract ArrayList<Integer> rowdir(int row);
  public abstract ArrayList<Integer> coldir(int col);
  public abstract ArrayList<Integer> groupdir(int groupnum);
}
