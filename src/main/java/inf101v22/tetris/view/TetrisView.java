package inf101v22.tetris.view;

import javax.swing.JComponent;

import inf101v22.grid.CoordinateItem;
import inf101v22.tetris.model.Tile;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class TetrisView extends JComponent {
    {
        // This code (between curly braces) is executed when an object is
        // created (before the call to the constructor, if one exists). 
        
        // The call to setFocusable enables the panel to receive events from
        // the user, such as key-presses and mouse movements.
        this.setFocusable(true);
    }
    public TetrisViewable viewable;

    public TetrisView(TetrisViewable viewable){
        this.viewable = viewable;
    }

    // The paint method is called by the Java Swing framework every time either
    // -- the window opens or resizes, or
    // -- someone calls .repaint() on this object (note: do NOT call paint
    // directly), or
    // -- for some other reason Java Swing believes it is time for painting the
    // canvas.
    @Override
    public void paint(Graphics canvas) {
        super.paint(canvas);
        this.drawTetrisBoard(canvas, 2, 2, this.getWidth(), this.getHeight(), 2);
    }

    public void drawTetrisBoard(Graphics canvas, int x, int y, int width, int height, int padding){
        drawBoardWithPad(canvas, x, y, width - padding, height - padding, padding); //, this.viewable.TilesOnBoard());
        // drawBoardWithPad(canvas, x, y, width - padding, height - padding, padding, this.viewable.PieceOnBoard());
    }
    // private void drawBoardWithPad(Graphics canvas, int boardX, int boardY, int boardWidth, int boardHeight, int padding, Iterable<CoordinateItem<Tile>> piecePaint) {
    private void drawBoardWithPad(Graphics canvas, int boardX, int boardY, int boardWidth, int boardHeight, int padding) {

        for (CoordinateItem<Tile> coordinateItem : this.viewable.TilesOnBoard()) {
            int row = coordinateItem.coordinate.row;
            int col = coordinateItem.coordinate.col;
            Tile tile = coordinateItem.item;
            Color color;

            if (tile == null) {
                color = Color.BLACK;
            }
            else {
                color  = tile.farge;
            }

            int tileX = boardX + col * boardWidth / this.viewable.getCols();
            int tileY = boardY + row * boardHeight / this.viewable.getRows();
            int nextTileX = boardX + (col + 1) * boardWidth / this.viewable.getCols();
            int nextTileY = boardY + (row + 1) * boardHeight / this.viewable.getRows();
            int tileWidth = nextTileX - tileX;
            int tileHeight = nextTileY - tileY;

            this.drawTileWithRightBottomPadding(canvas, tileX, tileY, tileWidth, tileHeight, padding, color);
        }

    }

    private void drawTileWithRightBottomPadding(Graphics canvas, int x, int y, int width, int height, int padding, Color color) {
        canvas.setColor(color);
        canvas.fillRect(x, y, width - padding, height - padding);
    }




    @Override
    public Dimension getPreferredSize() {
        // This method returns the "preferred" size of the component. However, if 
        // the user resize the window, the values returned here will not matter.
        // Hence, do not use the return value from here to calculate the size of
        // your components; use this.getWidht() and this.getHeight() instead.
        int padding = 20;
        int distance = 30;
        int preferredWidth = (distance+padding) * 10 + padding;
        int preferredHeight = (distance + padding) * 15 + padding;
        return new Dimension(preferredWidth, preferredHeight);
    }
}
