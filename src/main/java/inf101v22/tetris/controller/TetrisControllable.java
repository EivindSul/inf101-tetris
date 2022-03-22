package inf101v22.tetris.controller;

public interface TetrisControllable {


    public boolean moveFallingPiece(int deltaRow, int deltaCol);
    public boolean rotatePiece();
    public boolean dropPiece();
    public boolean PressP();
}
