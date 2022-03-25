package inf101v22.tetris.view;

import inf101v22.grid.CoordinateItem;
import inf101v22.tetris.model.GameScreen;
import inf101v22.tetris.model.Tile;

public interface TetrisViewable {
    /**
     * 
     * @return Height of board
     */
    int getRows();

    /**
     * 
     * @return Width of board
     */
    int getCols();

    /**
     * 
     * @return Iterable containing all static tiles and empty tiles
     */
    Iterable<CoordinateItem<Tile>> TilesOnBoard();

    /**
     * 
     * @return Iterable containing the tile in play
     */
    Iterable<CoordinateItem<Tile>> PieceOnBoard();

    /**
     * Whether or not a game is active or game over.
     * @return Game status
     */
    GameScreen getGameScreen();

    /**
     * 
     * @return Current score
     */
    int getScore(); 
}
