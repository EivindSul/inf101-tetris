package inf101v22.tetris.model.piece;

import java.util.ArrayList;
import java.util.Iterator;

import inf101v22.grid.Coordinate;
import inf101v22.grid.CoordinateItem;
import inf101v22.tetris.model.Tile;

public class PositionedPiece implements Iterable<CoordinateItem<Tile>>{

    int width;
    int height;
    Tile tile;
    Coordinate coord;
    PieceShape shape;

    PositionedPiece(PieceShape shape, Coordinate coord){
        this.width = shape.getWidth();
        this.height = shape.getHeight();
        this.tile = shape.getTile();
        this.coord = coord;
        this.shape = shape;
    }

    @Override
    public Iterator<CoordinateItem<Tile>> iterator() {
        ArrayList<CoordinateItem<Tile>> itList = new ArrayList<>();
        int x = this.coord.col;
        int y = this.coord.row;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (this.shape.bul[i][j]){
                    Coordinate coor = new Coordinate(x+i, y+j);
                    itList.add(new CoordinateItem<Tile>(coor, this.tile));
                }
            }
        }
        return itList.iterator();
    }
    // public Iterator<CoordinateItem<Tile>> iterator() {
    //     ArrayList<CoordinateItem<Tile>> itList = new ArrayList<>();
    //     int x = this.coord.col;
    //     int y = this.coord.row;
    //     for (int i = 0; i < width; i++) {
    //         for (int j = 0; j < height; j++) {
    //             if (this.shape.bul[j][i]){
    //                 Coordinate coor = new Coordinate(x+i, y+j);
    //                 itList.add(new CoordinateItem<Tile>(coor, this.tile));
    //             }
    //         }
    //     }
    //     return itList.iterator();
    // }
}
