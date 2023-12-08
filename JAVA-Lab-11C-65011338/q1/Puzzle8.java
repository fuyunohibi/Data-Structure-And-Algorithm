package q1;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Stack;

public class Puzzle8 {

  int size = 3;
  int[] sequence;
  ArrayList<Puzzle8State> explored;
  Stack<Puzzle8State> dfs;

  public Puzzle8(int[] input) {
    sequence = Arrays.copyOf(input, input.length);
  }

  public void displayBoard() {
    String[][] board = new String[size][size];
    for (int i = 0; i < sequence.length; i += 3) {
      int value = sequence[i];
      int row = sequence[i + 1];
      int col = sequence[i + 2];
      if (value == 9) {
        board[row][col] = "empty";
      } else {
        board[row][col] = Integer.toString(value);
      }
    }
    for (int row = 0; row < size; row++) {
      for (int col = 0; col < size; col++) {
        System.out.print(board[row][col] + "\t");
      }
      System.out.println();
    }
  }

  public static void demo1() {
    System.out.println("================ 65011338 Ko-Kwan Mongkholtham (Demo 1) ================");
    Puzzle8 game = new Puzzle8(new int[] { 9, 0, 0, 1, 0, 1, 3, 0, 2, 4, 1, 0, 2, 1, 1, 5, 1, 2, 7, 2, 0, 8, 2, 1, 6, 2, 2 });
    game.displayBoard();
  }

  public static void main(String[] args) {
    demo1();
  }
}

class Puzzle8State {
  int row, col, value;

  public Puzzle8State(int row, int col, int value) {
    this.row = row;
    this.col = col;
    this.value = value;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Puzzle8State other = (Puzzle8State) obj;
    return row == other.row && col == other.col && value == other.value;
  }

  @Override
  public String toString() {
    return "Puzzle8State{" +
        "row=" + row +
        ", col=" + col +
        ", value=" + value +
        '}';
  }
}
