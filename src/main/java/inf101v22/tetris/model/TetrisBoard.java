package inf101v22.tetris.model;

import java.awt.Color;

import inf101v22.grid.Coordinate;
import inf101v22.grid.Grid;

public class TetrisBoard<flis> extends Grid<Tile> {

    private int score = 0;
    
    public TetrisBoard(int rows, int cols, Tile type) {
        super(rows, cols, type);
    }
    /**
     * Checks if a row has any black tiles in it.
     * @param row 
     * @return True if row includes a black tile. False if no black tiles
     */
    // Sjekker ikke etter tomme ruter, men heller etter svarte. Det er i praksis det samme, siden min default-verdi er en svart Tile. 
    private boolean checkForBlackTiles(int row) {
        // Sjekker hver rute i rekken. Hvis det finnes en eneste svart, så trenger vi ikke å vite mer, så den returnerer true.
        for (int i = 0; i < this.getCols(); i++) {
            if(this.get(new Coordinate(row, i)).farge == Color.BLACK){
                return true;
            }
        }
        return false;
    }

    public int getScore(){
        return this.score;
    }

    // Ubrukt, men ble foreslått i oppgaveteksten å lage denne som hjelpemetode. 
    // Kan kanskje være nyttig i gamemodes eller noe sånn? 
    private void fillRowWithValue(int row, Tile value){
        for (int i = 0; i < this.getCols(); i++) {
            Coordinate coordinate = new Coordinate(row, i);
            this.set(coordinate, value);
        }
    }
    
    /**
     * Removes a row, moves all above rows 1 down
     * @param deadRow Row
     */
    // Skal flytte alle rader over den døde ned med en.
    private void killRow(int deadRow){
        for (int j = deadRow; j > 0; j--) {
            for (int i = 0; i < this.getCols(); i++) {
                Coordinate oldCoordinate = new Coordinate(j - 1, i);
                Coordinate newCoordinate = new Coordinate(j, i);
    
                Tile value = this.get(oldCoordinate);
                this.set(newCoordinate, value);
            }
        }
    }
    /**
     * Removes all rows not containing a black tile, i.e. all full rows. Adds these to score. 
     */
    public void removeFullRows(){
        // Sjekker alle rows for fulle rader. Hvis BlackTiles metoden returnerer false, er rekken full.
        int streak = 0;
        for (int row = this.getRows()-1; row > 0; row--) {
            if(!checkForBlackTiles(row)){
                // Hvis rekken blir fjernet, og alle rekkene faller, sjekk samme rekke igjen. Derfor row++
                killRow(row);
                row++;
                streak++;
            }
        }
        score += streak * streak;
    }
}
