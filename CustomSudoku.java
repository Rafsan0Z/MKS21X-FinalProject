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
    for(int i = 0; i < width; i++){
      for(int j = 0; j < length; j++){
        puzzle[i][j] = "__";
      }
    }
  }

  public void InputNums(){

  }

  public void answer(){

  }

  public String toString(){
    String result = "-------------------" + "\n";
    for(int i = 0; i < width; i++){
      result += "|";
      for(int j = 0; j < length; j++){
        result += puzzle[i][j];
        if(j == length - 1){result += "\n";}
      }
    }
    return result;
  }

}
