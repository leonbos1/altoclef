package adris.altoclef.buildings;

import net.minecraft.block.Block;

public class Y extends Building{
    public Y (Block blocktype) {
        super(new int[][] {
                {1, 0, 1},
                {1, 0, 1},
                {0, 1, 0},
                {0, 1, 0},
                {0, 1, 0},
        }, blocktype);
    }
}