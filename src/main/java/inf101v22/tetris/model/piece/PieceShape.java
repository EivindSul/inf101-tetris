package inf101v22.tetris.model.piece;

import java.awt.Color;
import java.lang.reflect.Array;

import inf101v22.tetris.model.Tile;


public class PieceShape {


    public Tile rute;
    public boolean[][] bul;

    private PieceShape(Tile tile, boolean[][] bool){
        this.rute = tile;
        this.bul = bool;
    }

    public Tile getTile(){
        return this.rute;
    }

    public int getWidth(){
        return bul[0].length;
    }

    public int getHeight(){
        return bul.length;
    }

    public boolean[][] getShape(){
        return bul;
    }

    // public PieceShape createRotated(){
    //     boolean[][] shape = this.getShape();
    //     boolean[][] newShape = new boolean[][]{};
    //     PieceShape rotated;

    //     for (int i = 0; i < this.getHeight(); i++) {
    //         boolean[] row = new boolean[]{};
    //         for (int j = 0; j < this.getWidth(); j++) {
    //             row[j] = shape[j][this.getWidth()-i-1];
    //         }
    //         newShape[i] = (row);
    //     }
    //     rotated = new PieceShape(this.getTile(), newShape);
    //     return rotated;
    // }
    public PieceShape createRotated(){
        boolean[][] shape = this.getShape();
        boolean[][] newShape = new boolean[this.getWidth()][this.getHeight()];
        PieceShape rotated;

        for (int i = 0; i < this.getWidth(); i++) {
            boolean[] row = new boolean[this.getHeight()];
            for (int j = 0; j < this.getHeight(); j++) {
                row[j] = shape[j][this.getWidth()-i-1];
            }
            newShape[i] = (row);
        }
        rotated = new PieceShape(this.getTile(), newShape);
        return rotated;
    }


    static final PieceShape T = new PieceShape(new Tile(Color.magenta, 'T'), new boolean[][] {
        { true ,  true , true  },
        { false,  true , false }
        });
    
    static final PieceShape S = new PieceShape(new Tile(Color.green, 'S'), new boolean[][] {
        { false,  true , true  },
        { true ,  true , false }
        });
    
    static final PieceShape Z = new PieceShape(new Tile(Color.red, 'Z'), new boolean[][] {
        { true ,  true , false },
        { false,  true , true  }
        });
        
    static final PieceShape I = new PieceShape(new Tile(Color.cyan, 'I'), new boolean[][] {
        {  true,  true,  true, true }
        });
        
    static final PieceShape J = new PieceShape(new Tile(Color.blue, 'J'), new boolean[][] {
        { true ,  false, false },
        { true ,  true , true  }
        });
        
    static final PieceShape L = new PieceShape(new Tile(Color.orange, 'L'), new boolean[][] {
        { true ,  true , true  },
        { true ,  false, false }
        });
        
    static final PieceShape O = new PieceShape(new Tile(Color.yellow, 'O'), new boolean[][] {
        { true ,  true },
        { true ,  true }
        });

    static final PieceShape KUK = new PieceShape(new Tile(Color.pink, 'K'), new boolean[][]{
        {false, true, false},
        {false, true, false},
        {false, true, false},
        {true, true, true}
    });

    static final PieceShape[] STANDARD_TETRIS_PIECES = { T, S, Z, I, J, L, O };
            



}
