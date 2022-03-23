package inf101v22.tetris.controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.Timer;

import inf101v22.tetris.midi.TetrisSong;
import inf101v22.tetris.model.GameScreen;
import inf101v22.tetris.view.TetrisView;


public class TetrisController implements java.awt.event.KeyListener, java.awt.event.ActionListener{

    TetrisControllable controllable;
    Timer timer;
    TetrisView view;
    TetrisSong song = new TetrisSong();

    public TetrisController(TetrisControllable controllable, TetrisView view){
        this.controllable = controllable;
        this.view = view;
        this.timer = new Timer(controllable.getInterval(), this);
        this.setDelay();
        this.view.addKeyListener(this);
        this.timer.start();
        this.song.run();
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (this.controllable.getGameScreen() == GameScreen.ACITVE_GAME){

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
                if(this.controllable.moveFallingPiece(0, 1)){
                    timer.restart();
                }
            }
            else if (e.getKeyCode() == KeyEvent.VK_UP) {
                // Up arrow was pressed
                this.controllable.rotatePiece();
                if(!this.controllable.checkLegalBelow()){
                    timer.restart();
                }
            }
            else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                // Spacebar was pressed
                this.controllable.dropPiece();
                timer.restart();
            }        
            else if (e.getKeyCode() == KeyEvent.VK_P) {
                this.controllable.PressP();
            }     
            // Brukte denne til å teste at clockTick funket       
            // else if (e.getKeyCode() == KeyEvent.VK_O) {
            //     this.controllable.clockTick();
            // }
            this.view.repaint();
        
        }
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
        
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (this.controllable.getGameScreen() == GameScreen.ACITVE_GAME){
            this.controllable.clockTick();
            this.view.repaint();
            this.setDelay();
        }
    }

    public void setDelay(){
        int interval = controllable.getInterval();
        timer.setDelay(interval);
        timer.setInitialDelay(interval);
    }
    
}
