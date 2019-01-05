public class CustomSudoku extends Sudoku{

  private int length;
  private int width;
  private String[][] puzzle;

  public CustomSudoku(int num, int num2){
    length = num;
    width = num2;
    puzzle = new String[length][width];
    createpuzzle();
    InputNums();
  }

  public void createpuzzle(){

  }

  public void InputNums(){

  }

  public void answer(){

  }

  public String toString(){
    String result = "";
    return result;
  }

}
