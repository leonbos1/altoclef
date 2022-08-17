package adris.altoclef.buildings;

import net.minecraft.block.Block;

public class Hakenkruis extends Building {


    public Hakenkruis(Block blocktype) {

        super(new int[][] {
                {1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1},
        }, blocktype);

    }


}
