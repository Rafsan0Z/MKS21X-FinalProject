public class StandardSudoku extends Sudoku{

  private String[][] puzzle;
  private int count;

  public StandardSudoku(int dif){
    int size = 9;
    puzzle = new String[size][size];
    createpuzzle();
    InputNums();
    count = dif;
  }

  public void createpuzzle(){
    for(int i = 0; i< 9; i++){
      for(int j = 0; j < 9; j++){
        puzzle[i][j] = "__";
      }
    }
  }

  public void InputNums(){
    for(int i = 0; i < 9; i++){
      for(int j = 0; j < 9; j++){
        if(count == 0){break;}
        else{
          puzzle[i][j] = " " + 0;
          count--;
        }
      }
    }
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
