package adris.altoclef.buildings;

import net.minecraft.block.Block;

public class J extends Building{
    public J(Block blocktype) {
        super(new int[][] {
                {0, 0, 1},
                {0, 0, 1},
                {0, 0, 1},
                {1, 0, 1},
                {1, 1, 1},
        }, blocktype);
    }
}