package adris.altoclef.buildings;

import net.minecraft.block.Block;

public class K extends Building{
    public K(Block blocktype) {
        super(new int[][] {
                {1, 0, 1},
                {1, 0, 1},
                {1, 1, 0},
                {1, 0, 1},
                {1, 0, 1},
        }, blocktype);
    }
}
