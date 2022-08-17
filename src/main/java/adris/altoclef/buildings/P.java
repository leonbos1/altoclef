package adris.altoclef.buildings;

import net.minecraft.block.Block;

public class P extends Building{
    public P(Block blocktype) {
        super(new int[][] {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1},
                {1, 0, 0},
                {1, 0, 0},
        }, blocktype);
    }
}