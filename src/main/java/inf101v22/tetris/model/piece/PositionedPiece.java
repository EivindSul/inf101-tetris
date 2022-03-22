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

    public PositionedPiece movedPiece(int deltaRow, int deltaCol){

        int row = this.coord.row + deltaRow;
        int col = this.coord.col + deltaCol;

        Coordinate newCoord = new Coordinate(row, col);
        PositionedPiece newPiece = new PositionedPiece(this.shape, newCoord);

        return newPiece;
    }

    public PositionedPiece rotatePiece(){
        PieceShape rotated = this.shape.createRotated();

        int rotatedHeightAdjusted = -1 + rotated.getHeight() / 2;
        int rotatedWidthAdjusted = -1 + rotated.getWidth() / 2;

        Coordinate newUpperLeftCorner = new Coordinate(this.coord.row + rotatedHeightAdjusted, this.coord.col + rotatedWidthAdjusted);

        PositionedPiece rotatedPositioned = new PositionedPiece(rotated, newUpperLeftCorner);

        return rotatedPositioned;
    }

    public PositionedPiece kuk(){
        PieceShape kuk = this.shape.KUK;
        PositionedPiece PositionedKuk = new PositionedPiece(kuk, this.coord);
        return PositionedKuk;
    }

    @Override
    public Iterator<CoordinateItem<Tile>> iterator() {
        // TODO fiks uoversiktlige navn, x, y, i, j, row, col henger ikke sammen
        ArrayList<CoordinateItem<Tile>> itList = new ArrayList<>();
        int x = this.coord.col;
        int y = this.coord.row;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (this.shape.getShape()[i][j]){
                    Coordinate coor = new Coordinate(x+i, y+j);
                    itList.add(new CoordinateItem<Tile>(coor, this.tile));
                }
            }
        }
        return itList.iterator();
    }
}
