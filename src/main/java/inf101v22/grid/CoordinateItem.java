package inf101v22.grid;

import java.util.Objects;

public class CoordinateItem <E> {
    public final Coordinate coordinate;
    public final E item;

    public CoordinateItem(Coordinate coordinate, E item){
        this.coordinate = coordinate;
        this.item = item;
    }

    public String toString(){
        return (("{ coordinate=\'" + coordinate.toString() + "\'" + ", item=\'" + item + "\' }"));
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CoordinateItem)) {
            return false;
        }
        CoordinateItem coordinateItem = (CoordinateItem) o;
        return Objects.equals(coordinate, coordinateItem.coordinate) && Objects.equals(item, coordinateItem.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinate, item);
    }


}
