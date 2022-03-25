package inf101v22.tetris.model;

import java.awt.Color;

import inf101v22.grid.Coordinate;
import inf101v22.grid.CoordinateItem;
import inf101v22.tetris.controller.TetrisControllable;
import inf101v22.tetris.model.piece.PositionedPiece;
import inf101v22.tetris.model.piece.PositionedPieceFactory;
import inf101v22.tetris.view.TetrisViewable;

public class TetrisModel implements TetrisViewable, TetrisControllable{

    private TetrisBoard<Tile> brett;
    private PositionedPiece posPiece;
    private PositionedPieceFactory posFac;
    private int startInterval = 1000; // Intervallet imellom flytting i starten er 1 sekund
    private int piecesSpawned = 1;
    public int score;
    public GameScreen GameScreen;

    public TetrisModel(){
        this.GameScreen = inf101v22.tetris.model.GameScreen.ACITVE_GAME;
        this.brett = new TetrisBoard<Tile>(15, 10, new Tile(Color.black, ' '));
        this.posFac = new PositionedPieceFactory();
        this.posFac.setCenterColumn(brett.getCols() / 2);
        this.posPiece = posFac.getNextPositionedPiece();

        // brett.set(new Coordinate(0,0), new Tile(Color.red, 'a'));
        // brett.set(new Coordinate(14,0), new Tile(Color.blue, 'a'));
        // brett.set(new Coordinate(0,9), new Tile(Color.yellow, 'a'));
        // brett.set(new Coordinate(14,9), new Tile(Color.green, 'a'));
    }

    @Override
    public int getRows() {
        return this.brett.getRows();
    }

    @Override
    public int getCols() {
        return this.brett.getCols();
    }

    @Override
    public Iterable<CoordinateItem<Tile>> TilesOnBoard() {
        return this.brett;
    }

    @Override
    public Iterable<CoordinateItem<Tile>> PieceOnBoard() {
        return this.posPiece;
    }

    /**
     * Moves a piece, changes its coordinates.
     * @return True if move is successful.
     */
    @Override
    public boolean moveFallingPiece(int deltaRow, int deltaCol) {
        PositionedPiece movedPiece = posPiece.movedPiece(deltaRow, deltaCol);
        boolean returnValue = this.legalMove(movedPiece);
        if (returnValue){
            this.posPiece = movedPiece;
        }
        return returnValue;
    }
    /**
     * Rotates piece counter-clockwise.
     */
    @Override
    public boolean rotatePiece() {
        PositionedPiece rotatedPiece = posPiece.rotatePiece();
        boolean returnValue = this.legalMove(rotatedPiece);
        if (returnValue){
            this.posPiece = rotatedPiece;
        }
        return returnValue;
    }

    public boolean PressP() {
        PositionedPiece P = posPiece.test_shape();
        boolean returnValue = this.legalMove(P);
        if (returnValue){
            this.posPiece = P;
        }
        return returnValue;
    }

    private boolean legalMove(PositionedPiece piece){
        for (CoordinateItem<Tile> coordinateItem : piece) {
            Coordinate kord = coordinateItem.coordinate;
            if (!brett.coordinateIsOnGrid(kord)){
                return false;
            }
            if (brett.get(kord).farge != Color.black){
                return false;
            }
        }
        return true;
    }

    /**
     * Drops current piece to bottom
     * @return Always true.
     */
    @Override
    public boolean dropPiece() {
        while (true){
            if(!this.moveFallingPiece(0, 1)){
                break;
            }
        }
        this.gluePiece();
        return true;
    }

    /**
     * Creates new piece, increments piecesSpawned to reduce timer, checks if game is lost. 
     * @return True if new piece is allowed to spawn. False if spot is taken.
     */
    private boolean newFallingPiece() {
        PositionedPiece newPiece = posFac.getNextPositionedPiece();
        if (!this.legalMove(newPiece)){
            this.GameScreen = inf101v22.tetris.model.GameScreen.GAME_OVER;
            return false;
        }
        else{
            posPiece = newPiece;
            this.piecesSpawned++;
            return true;
        }
    }
    /**
     * Removes piece from posPiece, adds it to brett. Creates new falling piece.
     */
    private void gluePiece(){
        for (CoordinateItem<Tile> coordinateItem : this.posPiece) {
            Coordinate coordinate = coordinateItem.coordinate;
            Tile value = coordinateItem.item;
            this.brett.set(coordinate, value);
        }
        brett.removeFullRows();
        this.newFallingPiece();
    }

    @Override
    public inf101v22.tetris.model.GameScreen getGameScreen() {
        return this.GameScreen;
    }

    /**
     * @return The interval between tile drop, based on amount of tiles spawned total.
     */
    @Override
    public int getInterval() {
        int interval =(int)Math.round(this.startInterval * (Math.pow(0.99, piecesSpawned)));
        return interval; 
    }

    /**
     * Moves current piece one tile down. If unable to move, glue piece.
     */
    @Override
    public void clockTick() {
        if(!this.moveFallingPiece(0, 1)){
            this.gluePiece();
        }
    }

    /**
     * @return True if tile is allowed to move down one tile. 
     */
    @Override
    public boolean checkLegalBelow() {
        PositionedPiece checkPiece = posPiece;
        return (this.legalMove(checkPiece.movedPiece(0, 1)));
    }

    @Override
    public int getScore() {
        return brett.getScore();
    }
}
