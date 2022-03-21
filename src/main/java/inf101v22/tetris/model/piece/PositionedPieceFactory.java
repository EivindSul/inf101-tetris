package inf101v22.tetris.model.piece;

import java.util.Random;

import inf101v22.grid.Coordinate;

public class PositionedPieceFactory {
    
    int centerCol;

    // Dette er litt forskjellig i forhold til hva oppgaven ber om, men det var forvirrende beskrivelse, så eg bare lagde det eg syntes var logisk.
    public void setCenterColumn(int center){
        // TODO add check if within board
        this.centerCol = center;
    }

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
