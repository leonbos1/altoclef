package adris.altoclef.buildings;

import net.minecraft.block.Block;

public class D extends Building{
    public D(Block blocktype) {
        super(new int[][] {
                {1, 1, 0},
                {1, 0, 1},
                {1, 0, 1},
                {1, 0, 1},
                {1, 1, 0},
        }, blocktype);
    }
}