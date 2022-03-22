package inf101v22.tetris.view;

import inf101v22.grid.CoordinateItem;
import inf101v22.tetris.model.GameScreen;
import inf101v22.tetris.model.Tile;

public interface TetrisViewable {
    
    public int getRows();
    public int getCols();

    Iterable<CoordinateItem<Tile>> TilesOnBoard();
    Iterable<CoordinateItem<Tile>> PieceOnBoard();

    public GameScreen getGameScreen();

}
