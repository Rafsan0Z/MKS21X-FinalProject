import java.util.ArrayList;
public class Driver{

  private String[][] puzzle;
  private ArrayList<Integer> mistakes = new ArrayList<Integer>();
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
    if(puzzle[row][col] == "__"){return false;}
    if(Integer.parseInt(puzzle[row][col]) > 9 || Integer.parseInt(puzzle[row][col]) < 0){return false;}
    int num = Integer.parseInt(puzzle[row][col]);
    for(int i = 0; i < dim[0]; i++){
      ArrayList<Integer> rows = new ArrayList<Integer>();
      for(int j = 0; j < dim[1]; j++){
        if(i != row && j != col && !puzzle[i][j].equals("__")){rows.add(Integer.parseInt(puzzle[i][j]));}
        if(rows.contains(num)){
          mistakes.add(row);
          mistakes.add(col);
          return false;
        }
      }
    }
    return true;
  }

  public boolean remove(int row, int col){
    puzzle[row][col] = "__";
    return true;
  }

  public int levelcounter(String stage){
    if(stage == "E"){return 21;}
    if(stage == "M"){return 19;}
    if(stage == "H"){return 17;}
    return 0;
  }

  public static void main(String[] args){
/*    Scanner input = new Scanner(System.in);
    System.out.println("Welcome to Sudoku!")
    System.out.println("Choose the difficulity: E for Easy, M for Medium and H for Hard");
    String level = input.nextLine(); This will become the final code!
    int count = levelcounter(level);
    input.close();
    */
    StandardSudoku question = new StandardSudoku(17);
    question.add(1,5,0);
    System.out.println(question.PrintPuzzle());
  }

}
