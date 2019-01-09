import java.util.ArrayList;
public class StandardSudoku extends Sudoku{

  private String[][] puzzle;
  private int count;

  public StandardSudoku(int dif){ // The constructor creates a 9 by 9 puzzle and Puts initial numbers to it based on difficulity
    int size = 9;
    puzzle = new String[size][size];
    createpuzzle();
    InputNums();
  //  answer();
    count = dif;
  }

  public void createpuzzle(){ // Puts blank spaces in place of the numbers
    for(int i = 0; i< 9; i++){
      for(int j = 0; j < 9; j++){
        puzzle[i][j] = "__";
      }
    }
  }

  public ArrayList<Integer> rowdir(int row){
    ArrayList<Integer> dir = new ArrayList<Integer>();
    for(int i = 0; i < 9; i++){
      if(puzzle[row][i] != "__"){
      int num = Integer.parseInt(puzzle[row][i].substring(1));
      dir.add(num);
    }
    }
    return dir;
  }

  public ArrayList<Integer> coldir(int col){
    ArrayList<Integer> dir = new ArrayList<Integer>();
    for(int i = 0; i < 9; i++){
      if(puzzle[i][col] != "__"){
      int num = Integer.parseInt(puzzle[i][col].substring(1));
      dir.add(num);
    }
    }
    return dir;
  }

  public ArrayList<Integer> groupdir(){
    
  }

  public void InputNums(){ // puts a chosen number of integers from 1 to 9 (inclusive) in the puzzle in random order
    for(int i = 0; i < 9; i++){
      for(int j = 0; j < 9; j++){
        int num = RandInt();
        ArrayList<Integer> down = rowdir(i);
        ArrayList<Integer> up = coldir(j);
        if(RandInt() < 5 && !down.contains(num) && !up.contains(num)) {
          puzzle[i][j] = " " + num;
          count--;
        }
          if(count == 0){break;}
      }
    }
  }

  public void answer(){
    for(int i = 0; i < 9; i++){
      for(int j = 0; j < 9; j++){
          if(puzzle[i][j] == "__"){
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
