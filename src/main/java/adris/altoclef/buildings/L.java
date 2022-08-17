package adris.altoclef.buildings;

import net.minecraft.block.Block;

public class L extends Building{
    public L(Block blocktype) {
        super(new int[][] {
                {1, 0, 0},
                {1, 0, 0},
                {1, 0, 0},
                {1, 0, 0},
                {1, 1, 1},
        }, blocktype);
    }
}