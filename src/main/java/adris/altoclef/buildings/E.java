package adris.altoclef.buildings;

import net.minecraft.block.Block;

public class E extends Building{
    public E(Block blocktype) {
        super(new int[][] {
                {1, 1, 1},
                {1, 0, 0},
                {1, 1, 0},
                {1, 0, 0},
                {1, 1, 1},
        }, blocktype);
    }
}