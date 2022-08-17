package adris.altoclef.buildings;

import net.minecraft.block.Block;

public class X extends Building{
    public X (Block blocktype) {
        super(new int[][] {
                {1, 0, 1},
                {1, 0, 1},
                {0, 1, 0},
                {1, 0, 1},
                {1, 0, 1},
        }, blocktype);
    }
}