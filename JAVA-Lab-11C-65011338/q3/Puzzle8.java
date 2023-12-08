package q3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

public class Puzzle8 {
    int size = 3;
    int[] sequence;
    HashSet<Puzzle8State> explored;
    Stack<Puzzle8State> dfs;

    public Puzzle8(int[] input) {
        sequence = new int[size * size];
        for (int i = 0; i < input.length; i += 3) {
            int value = input[i];
            int row = input[i + 1];
            int col = input[i + 2];
            sequence[row * size + col] = value;
        }
        explored = new HashSet<>();
        dfs = new Stack<>();
    }

    public void generateNextMove(Puzzle8State currentState) {
        int blankPos = -1;
        for (int i = 0; i < currentState.sequence.length; i++) {
            if (currentState.sequence[i] == 9) {
                blankPos = i;
                break;
            }
        }

        if (blankPos == -1)
            return; // Blank not found

        int row = blankPos / size;
        int col = blankPos % size;

        int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // Down, Up, Right, Left
        for (int[] move : moves) {
            int newRow = row + move[0];
            int newCol = col + move[1];
            if (newRow >= 0 && newRow < size && newCol >= 0 && newCol < size) {
                int newPos = newRow * size + newCol;
                int[] newSequence = currentState.sequence.clone();
                newSequence[blankPos] = newSequence[newPos];
                newSequence[newPos] = 9;
                Puzzle8State newState = new Puzzle8State(newSequence);
                if (!explored.contains(newState) && !dfs.contains(newState)) {
                    dfs.push(newState);
                }
            }
        }
    }

    public void nextMoveWithStack() {
        dfs.push(new Puzzle8State(sequence));
        while (!dfs.isEmpty()) {
            Puzzle8State currentState = dfs.pop();
            System.out.println("Popped: " + Arrays.toString(currentState.sequence));
            if (currentState.isGoal()) {
                System.out.println("Goal Found!");
                return;
            }
            explored.add(currentState);
            generateNextMove(currentState);
        }
        System.out.println("No solution found!");
    }

    public static void demo3() {
        System.out.println("================ 65011338 Ko-Kwan Mongkholtham (Demo 3) ================");
        Puzzle8 game = new Puzzle8(new int[]{9, 0, 0, 1, 0, 1, 3, 0, 2, 4, 1, 0, 2, 1, 1, 5, 1, 2, 7, 2, 0, 8, 2, 1, 6, 2, 2});
        game.nextMoveWithStack();

        System.out.println(game.explored.size());
        System.out.println("Partial explored state");
        for (Puzzle8State s : game.explored) {
            if (s.sequence[0] == 1 && s.sequence[1] == 2 && s.sequence[2] == 3 && s.sequence[3] == 4) {
                System.out.println(Arrays.toString(s.sequence));
            }
        }
        System.out.println("Note that the program terminates prior to pushing goal state into explored!");
    }

    public static void main(String[] args) {
        demo3();
    }
}

class Puzzle8State {
    int[] sequence;

    public Puzzle8State(int[] sequence) {
        this.sequence = sequence;
    }

    public boolean isGoal() {
        for (int i = 0; i < sequence.length; i++) {
            if (sequence[i] != (i + 1) % 9) { // NOTE: Goal state is 123456789 where blank is represented as 9
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(sequence);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Puzzle8State that = (Puzzle8State) obj;
        return Arrays.equals(sequence, that.sequence);
    }
}
