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



    public TetrisModel(){
        final char a = ' ';
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
        return false;
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
    
    
}
