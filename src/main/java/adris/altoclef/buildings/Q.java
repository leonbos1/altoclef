package adris.altoclef.buildings;

import net.minecraft.block.Block;

public class Q extends Building {
    public Q(Block blocktype) {
        super(new int[][]{
                {1, 1, 1, 0},
                {1, 0, 1, 0},
                {1, 0, 1, 0},
                {1, 1, 1, 0},
                {0, 0, 1, 1},
        }, blocktype);
    }
}