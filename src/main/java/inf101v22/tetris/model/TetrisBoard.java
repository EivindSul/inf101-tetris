package inf101v22.tetris.model;

import inf101v22.grid.Grid;

public class TetrisBoard<Tile> extends Grid<Tile> {

    public TetrisBoard(int rows, int cols, Tile type) {
        super(rows, cols, type);
    }
    
    
}
