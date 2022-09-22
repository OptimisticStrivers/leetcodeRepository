package edu.cmu.optimisticStrivers.bootcamp.HW3;

/**
 * @ClassName: BoardPosition
 * @Description: todo
 * @Author Yuqi Du
 * @Date 2022/9/18 1:25 PM
 * @Version 1.0
 */

public class BoardPosition {
    int num_rows ;
    int num_columns ;
    int row ;
    int column ;

    BoardPosition(int rows, int columns) {
        num_rows = rows;
        num_columns = columns;
        row = column = 0;
        return;
    }

    BoardPosition(BoardPosition pos) {
        num_rows = pos.num_rows;
        num_columns = pos.num_columns;
        row = pos.row;
        column = pos.column;
        return;
    }

    void check_validity() {
        if (row < 0 || row >= num_rows
                || column < 0 || column >= num_columns) {
            row = column = -1;
        }
        return;
    }

    boolean valid() {
        return row != -1 && column != -1;
    }

    BoardPosition move(char how) {
        BoardPosition new_pos = new BoardPosition(this);
        if (how == 'U') {
            new_pos.row--;
        } else if (how == 'D') {
            new_pos.row++;
        } else if (how == 'L') {
            new_pos.column--;
        } else if (how == 'R') {
            new_pos.column++;
        } else { // how == '*'
            // position is unchanged
        }
        new_pos.check_validity();
        return new_pos.valid() ? new_pos : null;
    }
}
