package gerardo.marquez;

import java.util.Objects;

public class Island {
    private Integer x;
    private Integer y;

    public Island(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return this.x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return this.y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Double lengthBetweenTwoIslands(Island island){
        return Math.sqrt(Math.pow(this.x - island.x, 2) + Math.pow(this.y - island.y, 2));
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Island)) {
            return false;
        }
        Island island = (Island) o;
        return Objects.equals(x, island.x) && Objects.equals(y, island.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

}
