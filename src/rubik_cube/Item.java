package rubik_cube;

public class Item {
    public int number;
    public Aspect aspect;
    public Aspect currentAspect;
    public Direction dir = Direction.P;

    public Item(int number) {
        this.number = number;
    }

    public Item(int number, Direction dir) {
        this.number = number;
        this.dir = dir;
    }

    public Item(int number, Aspect aspect) {
        this.number = number;
        this.aspect = aspect;
        this.currentAspect = aspect;
    }

    public Item(int number, Aspect aspect, Direction dir) {
        this.number = number;
        this.aspect = aspect;
        this.dir = dir;
    }

    public boolean isPositive(){
        return dir == Direction.P;
    }

    public Direction getNextDir(Operation op){
        return dir.getDirection(op.angle);
    }

    @Override
    public String toString() {
        return "[" + number +","+ aspect.toString() + "," + dir.toString() + "]";
    }
}
