package inf101v22.tetris.controller;

import inf101v22.tetris.model.GameScreen;

public interface TetrisControllable {


    public boolean moveFallingPiece(int deltaRow, int deltaCol);
    public boolean rotatePiece();
    public boolean dropPiece();
    public boolean PressP();
    public GameScreen getGameScreen();
}
