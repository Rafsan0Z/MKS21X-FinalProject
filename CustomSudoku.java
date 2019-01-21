import java.util.ArrayList;
import java.util.Random;
public class CustomSudoku extends Sudoku{

  private ArrayList<Integer> division;
  private int size;
  private int count;
  private String[][] puzzle;

  public CustomSudoku(int num){
    size = num;
    division = new ArrayList<Integer>();
    puzzle = new String[size][size];
    createpuzzle();
    Partitions();
    countfinder(size);
    InputNums();
  }

// RandInt override
  public int RandInt(){
    Random randgen = new Random();
    return (Math.abs(randgen.nextInt()) % size) + 1;
  }

  public String[][] getPuzzle(){
    return puzzle;
  }

  public int getSize(){
    return size;
  }

  public ArrayList<Integer> getdims(){
    return division;
  }

  public void countfinder(int num){
    if(num == 12){count = 26;}
    else if(num == 16){count = 0;}
    else{}
  }

  public void createpuzzle(){
    for(int i = 0; i < size; i++){
      for(int j = 0; j < size; j++){
        puzzle[i][j] = "__";
      }
    }
  }

  public void InputNums(){
    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    for(int i = 0; i < size; i++){
      for(int j = 0; j < size; j++){
          int num = RandInt();
          int location = groupNum(i,j);
          ArrayList<Integer> down = rowdir(i);
          ArrayList<Integer> up = coldir(j);
          ArrayList<Integer> group = groupdir(location);
          if(RandInt() < 5 && !down.contains(num) && !up.contains(num) && !group.contains(num)) {
            if(num > 9){
              int position = num - 10;
              String letter = alphabet.substring(position,position + 1);
              puzzle[i][j] = " " + letter;
            }
            else{
            puzzle[i][j] = " " + num;
            count--;
          }
          }
          if(count == 0){break;}
      }
    }
  }

  public void add(int row, int col, int num){
    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    if(num > 9){
      int position = num - 10;
      String letter = alphabet.substring(position,position+1);
      puzzle[row][col] = " " + letter;
    }
    else{
      puzzle[row][col] = " " + num;
    }
  }

  public void remove(int row, int col){
    puzzle[row][col] = "__";
  }

  public boolean checkAnswer(){
    for(int i = 0; i < size; i++){
      for(int j = 0; j < size; j++){
        if(Mistake(i,j)){return false;}
      }
    }
    return true;
  }

  public boolean Mistake(int row, int col){
    ArrayList<Integer> mistakes = new ArrayList<Integer>();   // a list of mistakes
    if(puzzle[row][col] == "__"){return true;} // is empty we know its a mistake
    int num = Integer.parseInt(puzzle[row][col].substring(1));
    ArrayList<Integer> rows = rowdir(row,col);
    ArrayList<Integer> cols = coldir(col,row);       // create three list to keep track of row, column and group
    ArrayList<Integer> groups = groupdir(groupNum(row,col),row,col);
    if(rows.contains(num) || cols.contains(num) || groups.contains(num)){return true;} // check if there is a similarity
    else{return false;}
  }

  public void Partitions(){
      double counter = (double)size;
      int second = 1;
      if((int)Math.sqrt(size) == Math.sqrt(size)){
        division.add((int)Math.sqrt(size));
        division.add((int)Math.sqrt(size));
      }
      else{
      while(counter % 2 == 0.0){
        second = second*2;
        counter = counter / 2;
      }
    }
      division.add(second);
      division.add((int)counter);
  }

  public void Markup(){
    String[][] answer = new String[size][size];
    for(int i = 0; i < size; i++){
      for(int j = 0; j < size; j++){
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
    for(int i = 1; i <= size; i++){
      if(!rowInts.contains(i) && !colInts.contains(i) && !groupInts.contains(i)){
        result += "" + i;
      }
    }
    return result;
  }

  public int groupNum(int row, int col){
    int horz = (int)Math.ceil((row+1)/(division.get(1)));
    int vert = (int)Math.ceil((col+1)/(division.get(1)));
    return division.get(0)*(vert - 1) + horz;
  }

  public ArrayList<Integer> rowdir(int row, int col){
    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    ArrayList<Integer> dir = new ArrayList<Integer>();
    for(int i = 0; i < size; i++){
      if(puzzle[row][i] != "__" && i != col){
      if(size <= 9){
      int num = Integer.parseInt(puzzle[row][i].substring(1));
      dir.add(num);
    }
    else{
      String letter = puzzle[row][i];
      int position = alphabet.indexOf(letter);
      dir.add(position+1);
    }
    }
    }
    return dir;
  }

  public ArrayList<Integer> coldir(int col, int row){
    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    ArrayList<Integer> dir = new ArrayList<Integer>();
    for(int i = 0; i < size; i++){
      if(puzzle[i][col] != "__" && i != row){
      if(size <= 9){
      int num = Integer.parseInt(puzzle[i][col].substring(1));
      dir.add(num);
    }
    else{
      String letter = puzzle[i][col];
      int position = alphabet.indexOf(letter);
      dir.add(position+1);
    }
    }
    }
    return dir;
  }

  public ArrayList<Integer> groupdir(int groupnum){
    ArrayList<Integer> dir = new ArrayList<Integer>();
    return dir;
  }

  public void answer(){
    for(int i = 0; i < size; i++){
      for(int j = 0; j < size; j++){
        if(puzzle[i][j] != "__"){puzzle[i][j] = " " + RandInt();}
      }
    }
  }

}
