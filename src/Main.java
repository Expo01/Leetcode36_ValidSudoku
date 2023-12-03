import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}

// editorial solution uses single pass with crazy memory space. thought they would do somethng more clever...
// only interesting parrt of deerriving corrct cube hashseet. pretty dumb problem
class Solution {
    public boolean isValidSudoku(char[][] board) {
        int N = 9;

        // Use hash set to record the status
        HashSet<Character>[] rows = new HashSet[N];
        HashSet<Character>[] cols = new HashSet[N];
        HashSet<Character>[] boxes = new HashSet[N];
        for (int r = 0; r < N; r++) {
            rows[r] = new HashSet<Character>();
            cols[r] = new HashSet<Character>();
            boxes[r] = new HashSet<Character>();
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                char val = board[r][c];

                // Check if the position is filled with number
                if (val == '.') {
                    continue;
                }

                // Check the row
                if (rows[r].contains(val)) {
                    return false;
                }
                rows[r].add(val);

                // Check the column
                if (cols[c].contains(val)) {
                    return false;
                }
                cols[c].add(val);

                // Check the box
                int idx = (r / 3) * 3 + c / 3;
                if (boxes[idx].contains(val)) {
                    return false;
                }
                boxes[idx].add(val);
            }
        }
        return true;
    }
}

// this is NOT asking to fill the board with correct answer. just to determine
// if start board values are valid for row, col, and square

// huge memory and slow way would be to traverse all rows and check
// for duplicates in a hashset, then do the same for colums with a
// second hash set, then a nested for loop 3x3 and again a third hashset and
// check all squares

// could do a single pass and derive the appropraite hashset for the  row,
// col and square, but would effectively need (given an rc matrix) r
// # of row hashsets, c # of columm hashsets and r/3 cubes which is insanely
// expensive with memory even thohough time would have decreased from
// o(3n) to O(n)


