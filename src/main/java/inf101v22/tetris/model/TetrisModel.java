package inf101v22.tetris.model;

import java.awt.Color;

import inf101v22.grid.Coordinate;
import inf101v22.grid.CoordinateItem;
import inf101v22.tetris.view.TetrisViewable;

public class TetrisModel implements TetrisViewable{

    public TetrisBoard<Tile> brett;

    public TetrisModel(){
        final char a = ' ';
        this.brett = new TetrisBoard<Tile>(15, 10, new Tile(Color.black, a));

        brett.set(new Coordinate(0,0), new Tile(Color.red, 'a'));
        brett.set(new Coordinate(14,0), new Tile(Color.blue, 'a'));
        brett.set(new Coordinate(0,9), new Tile(Color.yellow, 'a'));
        brett.set(new Coordinate(14,9), new Tile(Color.green, 'a'));
    }



    @Override
    public int getRows() {
        // TODO Auto-generated method stub
        return this.brett.getRows();
    }

    @Override
    public int getCols() {
        // TODO Auto-generated method stub
        return this.brett.getCols();
    }

    @Override
    public Iterable<CoordinateItem<Tile>> TilesOnBoard() {
        // TODO Auto-generated method stub
        return this.brett;
    }



    @Override
    public Iterable<CoordinateItem<Tile>> PieceOnBoard() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
