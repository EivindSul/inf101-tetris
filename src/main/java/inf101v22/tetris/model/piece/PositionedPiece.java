package inf101v22.tetris.model.piece;

import java.util.ArrayList;
import java.util.Iterator;

import inf101v22.grid.Coordinate;
import inf101v22.grid.CoordinateItem;
import inf101v22.tetris.model.Tile;

public class PositionedPiece implements Iterable<CoordinateItem<Tile>>{

    private int width;
    private int height;
    private Tile tile;
    private Coordinate coord;
    private PieceShape shape;

    /**
     * Constructor for PieceShape. Assigns position on the board to a given shape.
     * @param shape Pieceshape
     * @param coord Coordinate for upper-left tile of piece
     */
    PositionedPiece(PieceShape shape, Coordinate coord){
        this.width = shape.getWidth();
        this.height = shape.getHeight();
        this.tile = shape.getTile();
        this.coord = coord;
        this.shape = shape;
    }

    /**
     * Returns the same piece with new coordinates, moved in the direction specified in arguments.
     * @param deltaRow Movement up or down, down is positive
     * @param deltaCol Movement left or right, right is positive
     * @return PositionedPiece with new coordinates.
     */
    public PositionedPiece movedPiece(int deltaRow, int deltaCol){

        int row = this.coord.row + deltaRow;
        int col = this.coord.col + deltaCol;

        Coordinate newCoord = new Coordinate(row, col);
        PositionedPiece newPiece = new PositionedPiece(this.shape, newCoord);

        return newPiece;
    }

    /**
     * Rotates piece counter-clockwise. Remember to check if legal.
     * @return PositionedPiece that is rotated
    */
    public PositionedPiece rotatePiece(){

        PieceShape rotated = this.shape.createRotated();

        int rotatedHeightAdjusted = -1 + rotated.getHeight() / 2;
        int rotatedWidthAdjusted = -1 + rotated.getWidth() / 2;

        Coordinate newUpperLeftCorner = new Coordinate(this.coord.row + rotatedHeightAdjusted, this.coord.col + rotatedWidthAdjusted);

        PositionedPiece rotatedPositioned = new PositionedPiece(rotated, newUpperLeftCorner);

        return rotatedPositioned;
    }

    /**
     * Changes the active piece to a test shape. Moves the piece slightly to the right, does not rotate properly either. Remember to check if legal.
     * @return PositionedPiece with new shape
     */
    public PositionedPiece test_shape(){
        PieceShape test = PieceShape.test_shape;
        PositionedPiece PositionedShape = new PositionedPiece(test, this.coord);
        return PositionedShape;
    }

    @Override
    public Iterator<CoordinateItem<Tile>> iterator() {
        ArrayList<CoordinateItem<Tile>> itList = new ArrayList<>();
        // HVORFOR ER X COORD.COL I LINJE 60, MEN EG MÅ HA Y+COL FOR Å FÅ BRIKKENE TIL Å FALLE NEDOVER I LINJE 65. FORVIRRET PLEASE IGNORER DET
        int x = this.coord.col;
        int y = this.coord.row;
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (this.shape.getShape()[row][col]){
                    Coordinate coor = new Coordinate(x+row, y+col);
                    itList.add(new CoordinateItem<Tile>(coor, this.tile));
                }
            }
        }
        return itList.iterator();
    }
}
