package adris.altoclef.buildings;

import net.minecraft.block.Block;

public class M extends Building {
    public M(Block blocktype) {
        super(new int[][]{
                {1, 0, 0, 0, 1},
                {1, 1, 0, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 0, 0, 1},
                {1, 0, 0, 0, 1},
        }, blocktype);
    }
}