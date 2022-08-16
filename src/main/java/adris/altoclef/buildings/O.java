package adris.altoclef.buildings;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

public class O implements Building {

    private final int blocksNeeded = 12;
    private final int length = 3;
    private final int height = 5;
    private final Block c;
    private final Block a = Blocks.AIR;
    private final Block[][] blueprint;


    public O(Block blocktype) {
        c = blocktype;

        blueprint = new Block[][]{
                {c, c, c},
                {c, a, c},
                {c, a, c},
                {c, a, c},
                {c, c, c},
        };
    }

    @Override
    public int getBlocksNeeded() {
        return this.blocksNeeded;
    }

    @Override
    public int getLength() {
        return this.length;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public Block[][] getBlueprint() {
        return this.blueprint;
    }

    @Override
    public Block getBlocktype() {
        return this.c;
    }
}
