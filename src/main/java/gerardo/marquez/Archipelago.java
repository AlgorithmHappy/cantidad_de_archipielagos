package gerardo.marquez;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Archipelago {
    private Island one;
    private Island two;
    private Island three;
    private Boolean equalLength;

    public Archipelago(Island one, Island two, Island three) {
        this.one = one;
        this.two = two;
        this.three = three;

        List<Double> length = new ArrayList<>();

        length.add(this.one.lengthBetweenTwoIslands(this.two));
        length.add(this.two.lengthBetweenTwoIslands(this.three));
        length.add(this.three.lengthBetweenTwoIslands(this.one));

        this.equalLength = length.stream().distinct().toList().size() == 2;
    }

    public Island getOne() {
        return this.one;
    }

    public void setOne(Island one) {
        this.one = one;
    }

    public Island getTwo() {
        return this.two;
    }

    public void setTwo(Island two) {
        this.two = two;
    }

    public Island getThree() {
        return this.three;
    }

    public void setThree(Island three) {
        this.three = three;
    }

    public Boolean isEqualLength() {
        return this.equalLength;
    }

    public Boolean getEqualLength() {
        return this.equalLength;
    }

    public void setEqualLength(Boolean equalLength) {
        this.equalLength = equalLength;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Archipelago)) {
            return false;
        }
        Archipelago archipelago = (Archipelago) o;
        return Objects.equals(one, archipelago.one) && Objects.equals(two, archipelago.two) && Objects.equals(three, archipelago.three);
    }

    @Override
    public int hashCode() {
        return Objects.hash(one, two, three);
    }

}
