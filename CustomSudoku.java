import java.util.ArrayList;
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
              int position = num - 9;
            }
            puzzle[i][j] = " " + num;
            count--;
          }
          if(count == 0){break;}
      }
    }
  }

  public void add(int row, int col, int num){}

  public void remove(int row, int col){}

  public boolean checkAnswer(){
    return true;
  }

  public boolean Mistake(int row, int col){
    return true;
  }

  public void Partitions(){
      double counter = (double)size;
      int second = 1;
      while(counter % 2 == 0.0){
        second = second*2;
        counter = counter / 2;
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
    return 0;
  }

  public ArrayList<Integer> rowdir(int row){
    ArrayList<Integer> dir = new ArrayList<Integer>();
    for(int i = 0; i < size; i++){
      if(puzzle[row][i] != "__"){
      int num = Integer.parseInt(puzzle[row][i].substring(1));
      dir.add(num);
    }
    }
    return dir;
  }

  public ArrayList<Integer> coldir(int col){
    ArrayList<Integer> dir = new ArrayList<Integer>();
    for(int i = 0; i < size; i++){
      if(puzzle[i][col] != "__"){
      int num = Integer.parseInt(puzzle[i][col].substring(1));
      dir.add(num);
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
