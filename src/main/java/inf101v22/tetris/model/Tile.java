package inf101v22.tetris.model;

import java.awt.Color;

public class Tile {
    public final Color farge;
    public final char character;

    public Tile(Color color, char c){
        this.farge = color;
        this.character = c;
    }
}
