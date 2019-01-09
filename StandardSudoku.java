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

  public ArrayList<Integer> rowdir(int row){
    ArrayList<Integer> dir = new ArrayList<Integer>();
    for(int i = 0; i < 9; i++){
      int num = Integer.parseInt(puzzle[row][i]);
      dir.add(num);
    }
    return dir;
  }

  public ArrayList<Integer> coldir(int col){
    ArrayList<Integer> dir = new ArrayList<Integer>();
    for(int i = 0; i < 9; i++){
      int num = Integer.parseInt(puzzle[i][col]);
      dir.add(num);
    }
    return dir;
  }

  public void InputNums(){
    for(int i = 0; i < 9 && count != 0; i++){
      for(int j = 0; j < 9; j++){
        int num = RandInt();
//        ArrayList<Integer> down = rowdir(i);
//        ArrayList<Integer> up = coldir(j);
          puzzle[i][j] = " " + num;
          count--;
      }
    }
    puzzle[2][2] = " " + RandInt();
  }

  public void answer(){
    for(int i = 0; i < 9; i++){
      for(int j = 0; j < 9; j++){
          if(puzzle[i][j] != "__"){
              puzzle[i][j] = " " + RandInt();
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
