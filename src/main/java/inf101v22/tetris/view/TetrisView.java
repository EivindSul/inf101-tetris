package inf101v22.tetris.view;

import javax.swing.JComponent;

import inf101v22.grid.CoordinateItem;
import inf101v22.tetris.model.GameScreen;
import inf101v22.tetris.model.Tile;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class TetrisView extends JComponent {
    {
        this.setFocusable(true);
    }
    private TetrisViewable viewable;

    public TetrisView(TetrisViewable viewable){
        this.viewable = viewable;
    }

    @Override
    public void paint(Graphics canvas) {
        super.paint(canvas);
        this.drawTetrisBoard(canvas, 2, 2, this.getWidth(), this.getHeight(), 2);
    }

    private void drawTetrisBoard(Graphics canvas, int x, int y, int width, int height, int padding){
        drawBoardWithPad(canvas, x, y, width - padding, height - padding, padding, this.viewable.TilesOnBoard());
        drawBoardWithPad(canvas, x, y, width - padding, height - padding, padding, this.viewable.PieceOnBoard());
        if (viewable.getGameScreen() == GameScreen.GAME_OVER){
            drawGameOverScreen(canvas);
        }
    }
    // Denne er sterkt inspirert, kanskje helt lik Magnus Brørby sin. Han hjalp meg her, siden eg forsto ikke oppgaveteksten i det hele tatt. 
    private void drawBoardWithPad(Graphics canvas, int boardX, int boardY, int boardWidth, int boardHeight, int padding, Iterable<CoordinateItem<Tile>> piecePaint) {

        for (CoordinateItem<Tile> coordinateItem : piecePaint) {
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

    private void drawGameOverScreen(Graphics canvas){
        canvas.setColor(new Color(0, 0, 0, 128));
        canvas.fillRect(0, 0, this.getWidth(), this.getHeight());

        Font myFont = new Font("SansSerif", Font.BOLD, 20);
        canvas.setFont(myFont);
        canvas.setColor(Color.WHITE);

        int width = this.getWidth();
        int height = (this.getHeight()/3)*2;

        // Skulle gjerne gjort begge disse samtidig, men linjeskift ville absolutt ikke fungere
        GraphicHelperMethods.drawCenteredString(canvas, "GAME OVER", 0, 0, width, height);
        GraphicHelperMethods.drawCenteredString(canvas, "SCORE: " + viewable.getScore(), 0, 0, width, height + 75);
    }


    @Override
    public Dimension getPreferredSize() {
        // This method returns the "preferred" size of the component. However, if 
        // the user resize the window, the values returned here will not matter.
        // Hence, do not use the return value from here to calculate the size of
        // your components; use this.getWidht() and this.getHeight() instead.
        int padding = 20;
        int distance = 30;
        int preferredWidth = (distance+padding) * viewable.getCols() + padding;
        int preferredHeight = (distance + padding) * viewable.getRows() + padding;
        return new Dimension(preferredWidth, preferredHeight);
    }
}
