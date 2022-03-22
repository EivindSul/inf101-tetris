package inf101v22.tetris.model;

import java.awt.Color;

import inf101v22.grid.Coordinate;
import inf101v22.grid.CoordinateItem;
import inf101v22.tetris.controller.TetrisControllable;
import inf101v22.tetris.model.piece.PositionedPiece;
import inf101v22.tetris.model.piece.PositionedPieceFactory;
import inf101v22.tetris.view.TetrisViewable;

public class TetrisModel implements TetrisViewable, TetrisControllable{

    public TetrisBoard<Tile> brett;
    public PositionedPiece posPiece;
    public PositionedPieceFactory posFac;

    public GameScreen GameScreen;



    public TetrisModel(){
        final char a = ' ';
        this.GameScreen = GameScreen.ACITVE_GAME;
        this.brett = new TetrisBoard<Tile>(15, 10, new Tile(Color.black, a));
        this.posFac = new PositionedPieceFactory();
        posFac.setCenterColumn(brett.getCols() / 2);
        posPiece = posFac.getNextPositionedPiece();

        brett.set(new Coordinate(0,0), new Tile(Color.red, 'a'));
        brett.set(new Coordinate(14,0), new Tile(Color.blue, 'a'));
        brett.set(new Coordinate(0,9), new Tile(Color.yellow, 'a'));
        brett.set(new Coordinate(14,9), new Tile(Color.green, 'a'));
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

    @Override
    public boolean moveFallingPiece(int deltaRow, int deltaCol) {
        PositionedPiece movedPiece = posPiece.movedPiece(deltaRow, deltaCol);
        if (this.legalMove(movedPiece)){
            this.posPiece = movedPiece;
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean rotatePiece() {
        PositionedPiece rotatedPiece = posPiece.rotatePiece();
        if(this.legalMove(rotatedPiece)){
            this.posPiece = rotatedPiece;
            return true;
        }
        else{
            return false;
        }

    }

    public boolean PressP() {
        PositionedPiece P = posPiece.kuk();
        if(this.legalMove(P)){
            this.posPiece = P;
            return true;
        }
        else{
            return false;
        }
    }

    public boolean legalMove(PositionedPiece piece){
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

    @Override
    public boolean dropPiece() {
        while (true){
            if(!this.moveFallingPiece(0, 1)){
                break;
            }
        }
        this.gluepiece();
        return true;
    }

    public boolean newFallingPiece() {
        
        PositionedPiece newPiece = posFac.getNextPositionedPiece();
        if (!this.legalMove(newPiece)){
            this.GameScreen = GameScreen.GAME_OVER;
            return false;
        }
        else{
            posPiece = newPiece;
            return true;
        }
        
        
    }

    public void gluepiece(){
        for (CoordinateItem<Tile> coordinateItem : this.posPiece) {
            Coordinate coordinate = coordinateItem.coordinate;
            Tile value = coordinateItem.item;
            this.brett.set(coordinate, value);
        }
        this.newFallingPiece();
    }



    @Override
    public inf101v22.tetris.model.GameScreen getGameScreen() {
        return this.GameScreen;
    }





    
    
}
