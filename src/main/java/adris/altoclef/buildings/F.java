package adris.altoclef.buildings;

import net.minecraft.block.Block;

public class F extends Building{
    public F(Block blocktype) {
        super(new int[][] {
                {1, 1, 1},
                {1, 0, 0},
                {1, 1, 0},
                {1, 0, 0},
                {1, 0, 0},
        }, blocktype);
    }
}