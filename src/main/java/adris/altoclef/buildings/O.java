package adris.altoclef.buildings;

import net.minecraft.block.Block;

public class O extends Building {

    public O(Block blocktype) {
        super(new int[][] {
                {1, 1, 1},
                {1, 0, 1},
                {1, 0, 1},
                {1, 0, 1},
                {1, 1, 1},
        }, blocktype);
    }


}