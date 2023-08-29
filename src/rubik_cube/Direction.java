package rubik_cube;

public enum Direction {
    P(0),
    R(90),
    N(180),
    L(270);
    public int angle;
    Direction(int angle) {
        this.angle = angle;
    }

    public Direction getDirection(int angle){
        return Direction.values()[angle % 360 / 90];
    }
}
