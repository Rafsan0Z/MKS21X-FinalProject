import java.util.ArrayList;
public class Driver{

  private String[][] puzzle;
  private int[] dim = new int[2];

  public boolean checkAnswer(){
    for(int i = 0; i < dim[0]; i++){
      for(int j = 0; j < dim[1]; j++){
        if(!Mistake(i,j)){return false;}
      }
    }
    return true;
  }

  public boolean Mistake(int row, int col){
    int num = Integer.parseInt(puzzle[row][col]);
    for(int i = 0; i < dim[0]; i++){
      ArrayList<Integer> row = new ArrayList<Integer>();
      for(int j = 0; j < dim[1]; j++){
        if(i != row && j != col && puzzle[i][j] != "__"){row.add(Integer.parseInt(puzzle[i][j]));}
        if(row.contains(num)){return false;}
      }
    }
    return true;
  }

  public boolean add(int row, int col, int num){
    return true;
  }

  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    System.out.println("Welcome to Sudoku!")
    input.close();
  }

}
