package adris.altoclef.buildings;

import net.minecraft.block.Block;

public class B extends Building{
    public B(Block blocktype) {
        super(new int[][] {
                {1, 1, 0},
                {1, 0, 1},
                {1, 1, 0},
                {1, 0, 1},
                {1, 1, 0},
        }, blocktype);
    }
}
