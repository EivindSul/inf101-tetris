package inf101v22.grid;

import java.util.ArrayList;
import java.util.Iterator;

public class Grid<E> implements IGrid<E>{

    ArrayList<ArrayList<E>> grid;
    public final int rows;
    public final int cols;
    public E item;

    public Grid(int rows, int cols){
        this(rows,cols,null);
    }

    public Grid(int rows, int cols,E type){
        this.rows = rows;
        this.cols = cols;
        this.item = type;
        this.grid = new ArrayList<>(rows);
        for (int i = 0; i < rows; i++) {
            ArrayList<E> row = new ArrayList<E>(cols);
            for (int j = 0; j < cols; j++) {
                row.add(item);
            }
            this.grid.add(row);
        }
    }

    @Override
    public Iterator<CoordinateItem<E>> iterator() {
        ArrayList<CoordinateItem<E>> iteratorList = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Coordinate coord = new Coordinate(i,j);
                iteratorList.add(new CoordinateItem<>(coord, this.get(coord)));   
            }     
        }
        return iteratorList.iterator();
    }

    @Override
    public int getRows() {
        return this.rows;
    }

    @Override
    public int getCols() {
        return this.cols;
    }

    @Override
    public void set(Coordinate coordinate, E value) {
        int y = coordinate.row;
        int x = coordinate.col;

        if (!coordinateIsOnGrid(coordinate)) {
            throw new IndexOutOfBoundsException("Coordinates are out bounds");
        }
        grid.get(y).set(x, value);

        
    }

    @Override
    public E get(Coordinate coordinate) {
        int y = coordinate.row;
        int x = coordinate.col;

        if (!coordinateIsOnGrid(coordinate)) {
            throw new IndexOutOfBoundsException("Coordinates are out bounds");
        }
        return grid.get(y).get(x);

    }

    @Override
    public boolean coordinateIsOnGrid(Coordinate coordinate) {
        final int row = coordinate.row;
        final int col = coordinate.col;

        //Sjekker om koordinaten er negativ
        if (row < 0 || col < 0){
            return false;
        }
        //Sjekker om koordinaten er høyere eller lik størrelsen til brettet. 
        if ((row >= this.getRows()) || (col >= this.getCols())){
            return false;
        }
        //Dette blir som å ha en else statement, bare at det ville vært unødvendig, siden metoden breaker uansett før den kommer her om det er false. 
        return true;
    }
    
}
