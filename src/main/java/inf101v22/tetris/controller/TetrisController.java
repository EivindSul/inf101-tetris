package inf101v22.tetris.controller;

import java.awt.event.KeyEvent;

import inf101v22.tetris.model.GameScreen;
import inf101v22.tetris.view.TetrisView;

public class TetrisController implements java.awt.event.KeyListener{

    TetrisControllable controllable;
    TetrisView view;

    public TetrisController(TetrisControllable controllable, TetrisView view){
        this.controllable = controllable;
        this.view = view;

        this.view.addKeyListener(this);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        if (this.controllable.getGameScreen() != GameScreen.GAME_OVER){

            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                // Left arrow was pressed
                this.controllable.moveFallingPiece(-1, 0);
            }
            else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                // Right arrow was pressed
                this.controllable.moveFallingPiece(1, 0);
            }
            else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                // Down arrow was pressed
                this.controllable.moveFallingPiece(0, 1);
            }
            else if (e.getKeyCode() == KeyEvent.VK_UP) {
                // Up arrow was pressed
                this.controllable.rotatePiece();
            }
            else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                // Spacebar was pressed
                this.controllable.dropPiece();
            }        
            else if (e.getKeyCode() == KeyEvent.VK_P) {
                this.controllable.PressP();
            }
            view.repaint();
        
        }
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
        // TODO Auto-generated method stub
        
    }
    
}
