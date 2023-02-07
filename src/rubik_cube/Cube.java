package rubik_cube;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cube {
    public Item[][][] items = new Item[][][]{
            {//FRONT 0
                    {new Item(1, Aspect.F), new Item(2, Aspect.F), new Item(3, Aspect.F)},
                    {new Item(4, Aspect.F), new Item(5, Aspect.F), new Item(6, Aspect.F)},
                    {new Item(7, Aspect.F), new Item(8, Aspect.F), new Item(9, Aspect.F)},
            },
            {//UP 1
                    {new Item(1, Aspect.U), new Item(2, Aspect.U), new Item(3, Aspect.U)},
                    {new Item(4, Aspect.U), new Item(5, Aspect.U), new Item(6, Aspect.U)},
                    {new Item(7, Aspect.U), new Item(8, Aspect.U), new Item(9, Aspect.U)},
            },
            {//LEFT 2
                    {new Item(1, Aspect.L), new Item(2, Aspect.L), new Item(3, Aspect.L)},
                    {new Item(4, Aspect.L), new Item(5, Aspect.L), new Item(6, Aspect.L)},
                    {new Item(7, Aspect.L), new Item(8, Aspect.L), new Item(9, Aspect.L)},
            },
            {//RIGHT 3
                    {new Item(1, Aspect.R), new Item(2, Aspect.R), new Item(3, Aspect.R)},
                    {new Item(4, Aspect.R), new Item(5, Aspect.R), new Item(6, Aspect.R)},
                    {new Item(7, Aspect.R), new Item(8, Aspect.R), new Item(9, Aspect.R)},
            },
            {//DOWN 4
                    {new Item(1, Aspect.D), new Item(2, Aspect.D), new Item(3, Aspect.D)},
                    {new Item(4, Aspect.D), new Item(5, Aspect.D), new Item(6, Aspect.D)},
                    {new Item(7, Aspect.D), new Item(8, Aspect.D), new Item(9, Aspect.D)},
            },
            {//BACK 5
                    {new Item(1, Aspect.B), new Item(2, Aspect.B), new Item(3, Aspect.B)},
                    {new Item(4, Aspect.B), new Item(5, Aspect.B), new Item(6, Aspect.B)},
                    {new Item(7, Aspect.B), new Item(8, Aspect.B), new Item(9, Aspect.B)},
            }
    };

    public List[][][] dependencies = new List[][][]{
            {
                    {Arrays.asList(new Position(2, 0, 2), new Position(1, 2, 0)),
                            Arrays.asList(new Position(1, 2, 1)),
                            Arrays.asList(new Position(1, 2, 2), new Position(3, 0, 0))},
                    {Arrays.asList(new Position(2, 1, 2)),
                            new ArrayList(),
                            Arrays.asList(new Position(3, 1, 0))},
                    {Arrays.asList(new Position(2, 0, 2), new Position(4, 2, 0)),
                            Arrays.asList(new Position(1, 2, 1)),
                            Arrays.asList(new Position(1, 2, 2), new Position(3, 0, 0))},
            },
            {
                    {Arrays.asList(new Position(2, 0, 1), new Position(5, 0, 2)),
                            Arrays.asList(new Position(5, 0, 1)),
                            Arrays.asList(new Position(5, 0, 2), new Position(3, 0, 2))},
                    {Arrays.asList(new Position(2, 0, 1)),
                            new ArrayList(),
                            Arrays.asList(new Position(3, 0, 1))},
                    {Arrays.asList(new Position(2, 0, 2), new Position(0, 0, 0)),
                            Arrays.asList(new Position(0, 0, 1)),
                            Arrays.asList(new Position(0, 0, 2), new Position(3, 0, 0))},
            },
            {
                    {Arrays.asList(new Position(5, 0, 2), new Position(1, 0, 0)),
                            Arrays.asList(new Position(1, 1, 0)),
                            Arrays.asList(new Position(1, 2, 0), new Position(0, 0, 0))},
                    {Arrays.asList(new Position(5, 1, 2)),
                            new ArrayList(),
                            Arrays.asList(new Position(0, 1, 0))},
                    {Arrays.asList(new Position(5, 2, 2), new Position(4, 2, 0)),
                            Arrays.asList(new Position(4, 1, 0)),
                            Arrays.asList(new Position(4, 0, 0), new Position(0, 2, 0))},
            },
            {
                    {Arrays.asList(new Position(0, 0, 2), new Position(1, 2, 2)),
                            Arrays.asList(new Position(1, 1, 2)),
                            Arrays.asList(new Position(1, 0, 2), new Position(5, 0, 0))},
                    {Arrays.asList(new Position(0, 1, 2)),
                            new ArrayList(),
                            Arrays.asList(new Position(5, 1, 0))},
                    {Arrays.asList(new Position(0, 2, 2), new Position(4, 0, 2)),
                            Arrays.asList(new Position(4, 1, 2)),
                            Arrays.asList(new Position(4, 2, 2), new Position(5, 2, 0))},
            },
            {
                    {Arrays.asList(new Position(0, 2, 0), new Position(1, 2, 2)),
                            Arrays.asList(new Position(0, 2, 1)),
                            Arrays.asList(new Position(0, 2, 2), new Position(3, 2, 0))},
                    {Arrays.asList(new Position(2, 2, 1)),
                            new ArrayList(),
                            Arrays.asList(new Position(3, 2, 1))},
                    {Arrays.asList(new Position(2, 2, 0), new Position(5, 2, 2)),
                            Arrays.asList(new Position(5, 2, 1)),
                            Arrays.asList(new Position(5, 2, 1), new Position(3, 2, 2))},
            },
            {
                    {Arrays.asList(new Position(1, 0, 2), new Position(3, 0, 2)),
                            Arrays.asList(new Position(1, 0, 1)),
                            Arrays.asList(new Position(1, 0, 0), new Position(1, 0, 0))},
                    {Arrays.asList(new Position(3, 1, 2)),
                            new ArrayList(),
                            Arrays.asList(new Position(2, 1, 0))},
                    {Arrays.asList(new Position(4, 2, 2), new Position(3, 2, 2)),
                            Arrays.asList(new Position(4, 2, 1)),
                            Arrays.asList(new Position(4, 2, 0), new Position(2, 2, 0))},
            }
    };

    public boolean isCompleted(){
        for (int i = 0; i < items.length; i++) {
            for (int j = 0; j < items[i].length; j++) {
                for (int k = 0; k < items[i][j].length; k++) {
                    if(!(items[i][j][k].currentAspect.index == items[i][j][k].aspect.index
//                            && items[i][j][k].isPositive()
                    )){
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
