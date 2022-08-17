package adris.altoclef.buildings;

import net.minecraft.block.Block;

public class T extends Building{
    public T(Block blocktype) {
        super(new int[][] {
                {1, 1, 1},
                {0, 1, 0},
                {0, 1, 0},
                {0, 1, 0},
                {0, 1, 0},
        }, blocktype);
    }
}