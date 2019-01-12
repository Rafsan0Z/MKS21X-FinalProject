import java.util.ArrayList;
public class StandardSudoku extends Sudoku{

  private String[][] puzzle;
  private String[][] answer;
  private int count;

  public StandardSudoku(int dif){ // The constructor creates a 9 by 9 puzzle and Puts initial numbers to it based on difficulity
    int size = 9;
    puzzle = new String[size][size];
    createpuzzle();
    InputNums();
    count = dif;
  }

  public void add(int row, int col, int num){
    if(puzzle[i][j] != "__"){
      System.out.println("Error! A number exists! Please Remove first!");
    }
    else{
    puzzle[row][col] = " " + num;
  }
  }

  public void remove(int row, int col){
    if(puzzle[row][col == "__"]){
      System.out.println("Error! There are no numbers there!");
    }
    else{
    puzzle[row][col] = "__";
  }
  }

  public void createpuzzle(){ // Puts blank spaces in place of the numbers
    for(int i = 0; i< 9; i++){
      for(int j = 0; j < 9; j++){
        puzzle[i][j] = "__";
      }
    }
  }


  public boolean checkAnswer(){
    for(int i = 0; i < 9; i++){
      for(int j = 0; j < 9; j++){
        if(!Mistake(i,j)){return false;}
      }
    }
    return true;
  }

  public boolean Mistake(int row, int col){
    ArrayList<Integer> mistakes = new ArrayList<Integer>();
    if(puzzle[row][col] == "__"){return false;}
    if(Integer.parseInt(puzzle[row][col].substring(1)) > 9 || Integer.parseInt(puzzle[row][col].substring(1)) < 0){return false;}
    int num = Integer.parseInt(puzzle[row][col].substring(1));
    for(int i = 0; i < 9; i++){
      ArrayList<Integer> rows = new ArrayList<Integer>();
      for(int j = 0; j < 9; j++){
        if(i != row && j != col && !puzzle[i][j].equals("__")){rows.add(Integer.parseInt(puzzle[i][j].substring(1)));}
        if(rows.contains(num)){
          mistakes.add(row);
          mistakes.add(col);
          return false;
        }
      }
    }
    return true;
  }

  public void Markup(){
    String[][] answer = new String[9][9];
    for(int i = 0; i < 9; i++){
      for(int j = 0; j < 9; j++){
        if(puzzle[i][j] != "__"){
          answer[i][j] = puzzle[i][j].substring(1);
        }
        else{
          answer[i][j] = Markint(i,j);
        }
      }
    }
  }
  public String Markint(int row, int col){
    String result = "";
    ArrayList<Integer> rowInts = rowdir(row);
    ArrayList<Integer> colInts = coldir(col);
    ArrayList<Integer> groupInts = groupdir(groupNum(row,col));
    for(int i = 1; i <= 9; i++){
      if(!rowInts.contains(i) && !colInts.contains(i) && !groupInts.contains(i)){
        result += "" + i;
      }
    }
    return result;
  }

  public String[][] getPuzzle(){
    return puzzle;
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

  public ArrayList<Integer> groupdir(int groupnum){
    ArrayList<Integer> dir = new ArrayList<Integer>();
    if(groupnum >= 1 && groupnum <= 3){
    for(int i = 0; i < 3; i++){
      if(groupnum == 1){
      for(int j = 0; j < 3; j++){
        dir.add(Integer.parseInt(puzzle[i][j].substring(1)));
      }
      return dir;
    }
    if(groupnum == 2){
    for(int j = 3; j < 6; j++){
      dir.add(Integer.parseInt(puzzle[i][j].substring(1)));
    }
    return dir;
  }
  if(groupnum == 3){
  for(int j = 6; j < 9; j++){
    dir.add(Integer.parseInt(puzzle[i][j].substring(1)));
  }
  return dir;
}
    }
  }
  }

  public int groupNum(int row, int col){
    if(row >= 0 && row <= 2){
      if(col >= 0 && col <= 2){return 1;}
      if(col >= 3 && col <= 5){return 2;}
      else{return 3;}
    }
    else if(row >= 3 && row <= 5){
      if(col >= 0 && col <= 2){return 4;}
      if(col >= 3 && col <= 5){return 5;}
      else{return 6;}
    }
    else{
      if(col >= 0 && col <= 2){return 7;}
      if(col >= 3 && col <= 5){return 8;}
      else{return 9;}
    }
  }

  public void InputNums(){ // puts a chosen number of integers from 1 to 9 (inclusive) in the puzzle in random order
    for(int i = 0; i < 9; i++){
      for(int j = 0; j < 9; j++){
        int num = RandInt();
        int location = groupNum(i,j);
        ArrayList<Integer> down = rowdir(i);
        ArrayList<Integer> up = coldir(j);
        ArrayList<Integer> group = groupdir(location);
        if(RandInt() < 5 && !down.contains(num) && !up.contains(num) && !group.contains(num)) {
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

}
