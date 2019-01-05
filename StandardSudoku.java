public class StandardSudoku extends Sudoku{

  private int size;
  private String[][] puzzle;

  public StandardSudoku(int num){
    size = num;
    puzzle = new String[size][size];
    createpuzzle();
    InputNums();
  }

  public void createpuzzle(){
    for(int i = 0; i< size; i++){
      for(int j = 0; j < size; j++){
        puzzle[i][j] = "__";
      }
    }
  }

  public void InputNums(){

  }

  public void answer(){

  }

  public String toString(){
    String result = "";
    for(int i = 0; i < size; i++){
      for(int j = 0; j < size; j++){
        result += puzzle[i][j];
      }
    }
    return result;
  }

}
