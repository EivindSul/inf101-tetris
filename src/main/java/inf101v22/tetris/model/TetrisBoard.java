package inf101v22.tetris.model;

import java.awt.Color;

import inf101v22.grid.Coordinate;
import inf101v22.grid.CoordinateItem;
import inf101v22.grid.Grid;

public class TetrisBoard<flis> extends Grid<Tile> {
    
    public TetrisBoard(int rows, int cols, Tile type) {
        super(rows, cols, type);
    }
    
    public boolean checkForBlackTiles(int row) {
        Tile tile;
        for (int i = 0; i < this.getCols(); i++) {
            tile = new Tile(Color.BLACK, ' ');
            if(this.get(new Coordinate(row, i)) == tile){
                return true;
            }
        }
        return false;
    }

    public void fillRowWithValue(int row, Tile value){
        for (int i = 0; i < this.getCols(); i++) {
            Coordinate coordinate = new Coordinate(row, i);
            this.set(coordinate, value);
        }
    }

    public void dropRow(int deadRow){
        for (int i = 0; i < this.getCols(); i++) {
            Coordinate oldCoordinate = new Coordinate(deadRow - 1, i);
            Coordinate newCoordinate = new Coordinate(deadRow, i);

            Tile value = this.get(oldCoordinate);
            this.set(newCoordinate, value);
        }
    }

    public void removeFullRows(){
        System.out.println("running removeFullRows...");
        for (int row = this.getRows()-1; row > 0; row--) {
            System.out.println("running for loop, i = " + row);
            if(!checkForBlackTiles(row)){

                dropRow(row);
            }
        }
    }




    
}
