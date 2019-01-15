import java.util.ArrayList;
public class CustomSudoku extends Sudoku{

  private ArrayList<Integer> division;
  private int length;
  private int width;
  private int count;
  private String[][] puzzle;

  public CustomSudoku(int num, int num2){
    length = num;
    width = num2;
    division = new ArrayList<Integer>();
    puzzle = new String[length][width];
    createpuzzle();
    countfinder(length,width);
    InputNums();
  }

  public String[][] getPuzzle(){
    return puzzle;
  }

  public int countfinder(int num, int num2){
    return 0;
  }

  public void createpuzzle(){
    for(int i = 0; i < width; i++){
      for(int j = 0; j < length; j++){
        puzzle[i][j] = "__";
      }
    }
  }

  public void InputNums(){
    for(int i = 0; i < width; i++){
      for(int j = 0; j < length; j++){

      }
    }
  }

  public boolean checkAnswer(){
    return true;
  }

  public boolean Mistake(int row, int col){
    return true;
  }

  public void Partitions(){
    if(length == width){
      double counter = (double)length;
      int second = 1;
      while(counter % 2 == 0.0){
        second = second*2;
        counter = counter / 2;
      }
      division.add(second);
      division.add((int)counter);
    }
    else{

    }
  }

  public void Markup(){
    String[][] answer = new String[width][length];
    for(int i = 0; i < width; i++){
      for(int j = 0; j < length; j++){
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

  public int groupNum(int row, int col){
    return 0;
  }

  public ArrayList<Integer> rowdir(int row){
    ArrayList<Integer> dir = new ArrayList<Integer>();
    return dir;
  }

  public ArrayList<Integer> coldir(int col){
    ArrayList<Integer> dir = new ArrayList<Integer>();
    return dir;
  }

  public ArrayList<Integer> groupdir(int groupnum){
    ArrayList<Integer> dir = new ArrayList<Integer>();
    return dir;
  }

  public void answer(){
    for(int i = 0; i < width; i++){
      for(int j = 0; j < length; j++){
        if(puzzle[i][j] != "__"){puzzle[i][j] = " " + RandInt();}
      }
    }
  }

}
