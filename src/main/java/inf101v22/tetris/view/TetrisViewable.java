package inf101v22.tetris.view;

import inf101v22.grid.CoordinateItem;
import inf101v22.grid.Coordinate;
import inf101v22.tetris.model.Tile;

public interface TetrisViewable {
    
    int getRows();
    int getCols();
    Iterable<CoordinateItem<Tile>> TilesOnBoard();

    Iterable<CoordinateItem<Tile>> PieceOnBoard();


}