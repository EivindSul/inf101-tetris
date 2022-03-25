package inf101v22.tetris.model.piece;

import java.util.Random;

import inf101v22.grid.Coordinate;

public class PositionedPieceFactory {
    
    int centerCol;

    /**
     * 
     * @param center - The x-value that the pieces will spawn at.
     */
    public void setCenterColumn(int center){
        this.centerCol = center;
    }

    /**
     * Gets a new random piece, gives it coordinates to the top middle of board. 
     * @return A random PositionedPiece form the list of available pieces.
     */
    public PositionedPiece getNextPositionedPiece(){
        PieceShape piece;
        PositionedPiece posPiece;

        // Hjelp herfra https://www.codegrepper.com/code-examples/java/how+to+select+a+random+element+from+an+array+in+java
        Random r = new Random();
        int randNo = r.nextInt(PieceShape.STANDARD_TETRIS_PIECES.length);
        piece = PieceShape.STANDARD_TETRIS_PIECES[randNo];

        int pieceCenter = this.centerCol - (piece.getWidth() / 2);
        posPiece = new PositionedPiece(piece, new Coordinate(pieceCenter, 0));

        return posPiece;
    }
}
