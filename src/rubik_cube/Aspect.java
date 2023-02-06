package rubik_cube;

public enum Aspect {
    F(0),
    U(1),
    L(2),
    R(3),
    D(4),
    B(5);

    public int index;

    Aspect(int i) {
        this.index = i;
    }
}
