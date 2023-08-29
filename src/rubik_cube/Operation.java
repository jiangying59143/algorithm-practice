package rubik_cube;

public enum Operation {
    CLOCKWISE(90),
    REVERSE(180),
    ANTI_CLOCKWISE(270);

    public int angle;
    Operation(int i) {
        angle = i;
    }

    public Operation Operation(int angle){
        return Operation.values()[angle/90];
    }

}
