package q2;

import java.util.HashSet;
import java.util.Stack;

public class Puzzle8 {

  int size = 3;
  int[] sequence;
  HashSet<String> explored;
  Stack<int[]> dfs;

  public Puzzle8(int[] input) {
    sequence = new int[size * size];
    explored = new HashSet<>();
    dfs = new Stack<>();
    for (int i = 0; i < input.length; i += 3) {
      int value = input[i];
      int row = input[i + 1];
      int col = input[i + 2];
      sequence[row * size + col] = value;
    }
  }

  public void generateNextMove() {
    int blankPos = -1;
    for (int i = 0; i < sequence.length; i++) {
      if (sequence[i] == 9) {
        blankPos = i;
        break;
      }
    }
    if (blankPos == -1)
      return; // Blank not found

    int row = blankPos / size;
    int col = blankPos % size;

    int[][] moves = { { 1, 0, 5 }, { -1, 0, 3 }, { 0, 1, 3 }, { 0, -1, 1 } }; // south, north, east, west
    String[] moveNames = { "south", "north", "east", "west" };

    for (int i = 0; i < moves.length; i++) {
      int newRow = row + moves[i][0];
      int newCol = col + moves[i][1];
      if (newRow >= 0 && newRow < size && newCol >= 0 && newCol < size) {
        int newPos = newRow * size + newCol;
        swap(blankPos, newPos);
        String stateKey = getStateKey(sequence);
        if (!explored.contains(stateKey)) {
          System.out.println("pushing " + moveNames[i] + " " + moves[i][2] + " " + sequenceToString());
          dfs.push(sequence.clone());
          explored.add(stateKey);
        }
        swap(blankPos, newPos); // swap back to original state
      }
    }
  }

  private void swap(int pos1, int pos2) {
    int tmp = sequence[pos1];
    sequence[pos1] = sequence[pos2];
    sequence[pos2] = tmp;
  }

  private String getStateKey(int[] sequence) {
    StringBuilder key = new StringBuilder();
    for (int j : sequence) {
      key.append(j).append(",");
    }
    return key.toString();
  }

  private String sequenceToString() {
    StringBuilder sb = new StringBuilder("[");
    for (int value : sequence) {
      sb.append(value).append(", ");
    }
    sb.setLength(sb.length() - 2);
    sb.append("]");
    return sb.toString();
  }

  private int countInversions() {
    int invCount = 0;
    for (int i = 0; i < sequence.length - 1; i++) {
      for (int j = i + 1; j < sequence.length; j++) {
        // NOTE TO PROFESSOR: Value 9 is used to represent the blank tile becuase the output in the example is
        if (sequence[i] > sequence[j] && sequence[i] != 9 && sequence[j] != 9)
          invCount++;
      }
    }
    return invCount;
  }

  public boolean isSolvable() {
    int invCount = countInversions();
    int blankRow = -1;
    for (int i = 0; i < sequence.length; i++) {
      if (sequence[i] == 9) {
        blankRow = i / size;
        break;
      }
    }

    // NOTE: If grid is odd, return true if inversion count is even.
    if (size % 2 == 1)
      return (invCount % 2 == 0);

    // NOTE: If grid is even, return true if the blank is on an odd row counting from the
    // bottom
    // and the number of inversions is even.
    if (blankRow % 2 == 0)
      return (invCount % 2 == 0);

    // NOTE: If grid is even, return true if the blank is on an even row counting from the
    // bottom
    // and the number of inversions is odd.
    return (invCount % 2 == 1);
  }

  public static void demo2() {
    System.out.println("================ 65011338 Ko-Kwan Mongkholtham (Demo 2) ================");
    Puzzle8 game = new Puzzle8(
        new int[] { 9, 0, 0, 1, 0, 1, 3, 0, 2, 4, 1, 0, 2, 1, 1, 5, 1, 2, 7, 2, 0, 8, 2, 1, 6, 2, 2 });
    game.generateNextMove();
    System.out.println("Is Solvable? " + game.isSolvable() + "!");
  }

  public static void main(String[] args) {
    demo2();
  }
}
