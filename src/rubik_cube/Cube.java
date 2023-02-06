package rubik_cube;

public class Cube {
    public Item[][][] items = new Item[][][]{
            {//FRONT
                    {new Item(1, Aspect.F), new Item(2, Aspect.F), new Item(3, Aspect.F)},
                    {new Item(4, Aspect.F), new Item(5, Aspect.F), new Item(6, Aspect.F)},
                    {new Item(7, Aspect.F), new Item(8, Aspect.F), new Item(9, Aspect.F)},
            },
            {//UP
                    {new Item(1, Aspect.U), new Item(2, Aspect.U), new Item(3, Aspect.U)},
                    {new Item(4, Aspect.U), new Item(5, Aspect.U), new Item(6, Aspect.U)},
                    {new Item(7, Aspect.U), new Item(8, Aspect.U), new Item(9, Aspect.U)},
            },
            {//LEFT
                    {new Item(1, Aspect.L), new Item(2, Aspect.L), new Item(3, Aspect.L)},
                    {new Item(4, Aspect.L), new Item(5, Aspect.L), new Item(6, Aspect.L)},
                    {new Item(7, Aspect.L), new Item(8, Aspect.L), new Item(9, Aspect.L)},
            },
            {//RIGHT
                    {new Item(1, Aspect.R), new Item(2, Aspect.R), new Item(3, Aspect.R)},
                    {new Item(4, Aspect.R), new Item(5, Aspect.R), new Item(6, Aspect.R)},
                    {new Item(7, Aspect.R), new Item(8, Aspect.R), new Item(9, Aspect.R)},
            },
            {//DOWN
                    {new Item(1, Aspect.D), new Item(2, Aspect.D), new Item(3, Aspect.D)},
                    {new Item(4, Aspect.D), new Item(5, Aspect.D), new Item(6, Aspect.D)},
                    {new Item(7, Aspect.D), new Item(8, Aspect.D), new Item(9, Aspect.D)},
            },
            {//BACK
                    {new Item(1, Aspect.B), new Item(2, Aspect.B), new Item(3, Aspect.B)},
                    {new Item(4, Aspect.B), new Item(5, Aspect.B), new Item(6, Aspect.B)},
                    {new Item(7, Aspect.B), new Item(8, Aspect.B), new Item(9, Aspect.B)},
            }
    };

    public Cube() {

    }

    public boolean isCompleted(){
        for (int i = 0; i < items.length; i++) {
            for (int j = 0; j < items[i].length; j++) {
                for (int k = 0; k < items[i][j].length; k++) {
                    if(!(items[i][j][k].aspect.index == i && items[i][j][k].isPositive())){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void print(){
        for (int line = 0; line < 3; line++) {
            for (int i = 0; i < items.length; i++) {
                for (int j = 0; j < items[i][line].length; j++) {
                    System.out.print(items[i][line][j] + " ");
                }
                System.out.print("   ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Cube cube = new Cube();
        cube.print();
        System.out.println(cube.isCompleted());
    }
}
