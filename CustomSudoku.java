public class CustomSudoku extends Sudoku{

  private ArrayList<Integer> break = new ArrayList<Integer>();
  private int length;
  private int width;
  private int count;
  private String[][] puzzle;

  public CustomSudoku(int num, int num2){
    length = num;
    width = num2;
    puzzle = new String[length][width];
    createpuzzle();
    countfinder(length,width);
    InputNums();
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
      break.add(second);
      break.add((int)counter);
    }
    else{

    }
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
