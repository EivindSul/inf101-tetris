package inf101v22.tetris.model.piece;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class RotatePieceTest {

    @Test
    void rotateTest(){

        PieceShape J = PieceShape.J;
        
        boolean[][] rotatedOnce = J.createRotated().getShape();
        boolean[][] rotatedTest = new boolean[][]{
            { false ,true ,},
            { false,true },
            { true, true }
            };
        assertEquals(rotatedOnce, rotatedTest);

        
        
    }
}


