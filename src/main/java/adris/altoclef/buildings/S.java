package adris.altoclef.buildings;

import net.minecraft.block.Block;

public class S extends Building{
    public S(Block blocktype) {
        super(new int[][] {
                {1, 1, 1},
                {1, 0, 0},
                {1, 1, 1},
                {0, 0, 1},
                {1, 1, 1},
        }, blocktype);
    }
}