package rubik_cube;

public class Item {
    public int number;
    public Aspect aspect;
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
        switch (dir) {
            case P:
                switch (op) {
                    case CLOCKWISE:
                        return Direction.R;
                    case ANTI_CLOCKWISE:
                        return Direction.L;
                    case REVERSE:
                        return Direction.N;
                }
            case N:
                switch (op) {
                    case CLOCKWISE:
                        return Direction.L;
                    case ANTI_CLOCKWISE:
                        return Direction.R;
                    case REVERSE:
                        return Direction.P;
                }
            case R:
                switch (op) {
                    case CLOCKWISE:
                        return Direction.N;
                    case ANTI_CLOCKWISE:
                        return Direction.P;
                    case REVERSE:
                        return Direction.R;
                }
            case L:
                switch (op) {
                    case CLOCKWISE:
                        return Direction.P;
                    case ANTI_CLOCKWISE:
                        return Direction.N;
                    case REVERSE:
                        return Direction.L;
                }
        }

        return dir;
    }

    @Override
    public String toString() {
        return "[" + number +","+ aspect.toString() + "," + dir.toString() + "]";
    }
}
