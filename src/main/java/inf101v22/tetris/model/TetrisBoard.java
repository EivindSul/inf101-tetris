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
        //Tile emptyTile = new Tile(Color.BLACK, ' ');
        for (int i = 0; i < this.getCols(); i++) {
            if(this.get(new Coordinate(row, i)).farge == Color.BLACK){
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

    // Skal flytte alle rader over den døde ned en.
    public void dropRow(int deadRow){
        for (int j = deadRow; j > 0; j--) {
            for (int i = 0; i < this.getCols(); i++) {
                Coordinate oldCoordinate = new Coordinate(j - 1, i);
                Coordinate newCoordinate = new Coordinate(j, i);
    
                Tile value = this.get(oldCoordinate);
                this.set(newCoordinate, value);
            }
        }
    }

    public void removeFullRows(){
        // Sjekker alle rows for fulle rader. 
        for (int row = this.getRows()-1; row > 0; row--) {
            if(!checkForBlackTiles(row)){
                dropRow(row);
                row++;
            }
        }
    }




    
}
