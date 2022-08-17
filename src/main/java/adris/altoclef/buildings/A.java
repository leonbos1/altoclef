package adris.altoclef.buildings;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

public class A extends Building {

    public A(Block blocktype) {
        super(new int[][] {
                {0, 1, 0},
                {1, 0, 1},
                {1, 1, 1},
                {1, 0, 1},
                {1, 0, 1},
        }, blocktype);
    }
}
