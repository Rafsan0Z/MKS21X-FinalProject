public class StandardSudoku extends Sudoku{

  private String[][] puzzle;

  public StandardSudoku(){
    int size = 9;
    puzzle = new String[size][size];
    createpuzzle();
    InputNums();
  }

  public void createpuzzle(){
    for(int i = 0; i< 9; i++){
      for(int j = 0; j < 9; j++){
        puzzle[i][j] = "__";
      }
    }
  }

  public void InputNums(){

  }

  public void answer(){
    for(int i = 0; i < 9; i++){
      for(int j = 0; j < 9; j++){
          if(puzzle[i][j] != "__"){
              puzzle[i][j] = " " + randInt();
          }
      }
    }
  }

  public String toString(){
    String result = "--------------------" + "\n";
    for(int i = 0; i < 9; i++){
      result += "|";
      for(int j = 0; j < 9; j++){
        result += puzzle[i][j];
        if((j+1) % 3 == 0){
          result += "|";
        }
        if(j == 8){
          result += "\n";
        }
      }
    }
    return result;
  }

}
