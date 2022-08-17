package adris.altoclef.buildings;

import net.minecraft.block.Block;

public class H extends Building{
    public H(Block blocktype) {
        super(new int[][] {
                {1, 0, 1},
                {1, 0, 1},
                {1, 1, 1},
                {1, 0, 1},
                {1, 0, 1},
        }, blocktype);
    }
}