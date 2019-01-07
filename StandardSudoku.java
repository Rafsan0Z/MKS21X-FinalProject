import java.util.ArrayList;
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
      ArrayList<Integer> rowInts = new ArrayList<Integer>();
      for(int j = 0; j < 9; j++){
        int num = randInt();
        ArrayList<Integer> colInts = new ArrayList<Integer>();
        if(count == 0){break;}
        else if(!rowInts.contains(num) && !colInts.contains(num)) {
          puzzle[i][j] = " " + randInt();
          colInts.add(num);
          rowInts.add(num);
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

  public String PrintPuzzle(){
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
