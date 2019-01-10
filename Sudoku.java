import java.util.Random;
public abstract class Sudoku{

  public abstract void createpuzzle();
  public abstract void InputNums();
  public abstract void answer();
  public int RandInt(){
    Random randgen = new Random();
    return Math.abs(randgen.nextInt()) % 9 + 1;
  }
  public abstract void add(int row, int col);
  public abstract void remove(int col, int col);

}
