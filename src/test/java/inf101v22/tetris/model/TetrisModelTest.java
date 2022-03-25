package inf101v22.tetris.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

// Jobbet litt med Brage Aasen her. Han har forskjellig struktur på konstruktør, men eg kjører ganske like tester her. 
public class TetrisModelTest {
    
    // Sjekker at model lager riktig størrelse brett. 
    @Test
    void ModelTest(){
        TetrisModel model = new TetrisModel();
        assertEquals(10, model.getCols());
        assertEquals(15, model.getRows());
    }

    @Test
    void moveFallingPiece() {
        TetrisModel model = new TetrisModel();

        boolean resultat;

        resultat = model.moveFallingPiece(1, 1);
        assertTrue(resultat);

        model.newFallingPiece();
        resultat = model.moveFallingPiece(100, 1500);
        assertFalse(resultat);

        model.newFallingPiece();
        resultat = model.moveFallingPiece(15, 0);
        assertFalse(resultat);

        model.newFallingPiece();
        resultat = model.moveFallingPiece(0, 8);
        assertTrue(resultat);

        assertEquals(4, model.piecesSpawned);
        
        assertEquals(0, model.getScore());

    }
}


