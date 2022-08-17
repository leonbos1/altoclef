package adris.altoclef.buildings;

import net.minecraft.block.Block;

public class R extends Building{
    public R(Block blocktype) {
        super(new int[][] {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1},
        }, blocktype);
    }
}