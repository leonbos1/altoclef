package adris.altoclef.buildings;

import net.minecraft.block.Block;

public class U extends Building{
    public U(Block blocktype) {
        super(new int[][] {
                {1, 0, 1},
                {1, 0, 1},
                {1, 0, 1},
                {1, 0, 1},
                {1, 1, 1},
        }, blocktype);
    }
}