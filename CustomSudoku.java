public class CustomSudoku extends Sudoku{

  private ArrayList<Integer> break = new ArrayList<Integer>();
  private int length;
  private int width;
  private String[][] puzzle;

  public CustomSudoku(int num, int num2){
    length = num;
    width = num2;
    puzzle = new String[length][width];
    createpuzzle();
    InputNums();
  }

  public void createpuzzle(){
    for(int i = 0; i < width; i++){
      for(int j = 0; j < length; j++){
        puzzle[i][j] = "__";
      }
    }
  }

  public void InputNums(){

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

  public void answer(){
    for(int i = 0; i < width; i++){
      for(int j = 0; j < length; j++){
        if(puzzle[i][j] != "__"){puzzle[i][j] = " " + randInt();}
      }
    }
  }

  public String toString(){
    String result = "-------------------" + "\n";
    for(int i = 0; i < width; i++){
      result += "|";
      for(int j = 0; j < length; j++){
        result += puzzle[i][j];
        if(j == length - 1){result += "\n";}
      }
    }
    return result;
  }

}
