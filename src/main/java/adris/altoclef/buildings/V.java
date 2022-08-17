package adris.altoclef.buildings;

import net.minecraft.block.Block;

public class V extends Building{
    public V(Block blocktype) {
        super(new int[][] {
                {0, 0, 0},
                {1, 0, 1},
                {1, 0, 1},
                {1, 0, 1},
                {0, 1, 0},
        }, blocktype);
    }
}