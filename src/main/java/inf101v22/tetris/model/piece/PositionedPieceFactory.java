package inf101v22.tetris.model.piece;

import java.util.Random;

public class PositionedPieceFactory {
    


    int setCenterColumn(){
        return 0;
    }

    public PositionedPiece getNextPositionedPiece(){
        PieceShape piece;

        // Hjelp herfra https://www.codegrepper.com/code-examples/java/how+to+select+a+random+element+from+an+array+in+java
        Random r = new Random();
        int randNo = r.nextInt(PieceShape.STANDARD_TETRIS_PIECES.length);
        piece = PieceShape.STANDARD_TETRIS_PIECES[randNo];
    }
}
