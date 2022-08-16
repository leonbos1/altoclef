package adris.altoclef.buildings;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

public class Hakenkruis implements Building{

    private final int blocksNeeded = 37;
    private final int length = 11;
    private final int height = 11;
    private final Block c;
    private final Block a = Blocks.AIR;
    private final Block[][] blueprint;



    public Hakenkruis(Block blocktype) {
        c = blocktype;
         blueprint = new Block[][] {
                {c,a,a,a,a,c,c,c,c,c,c},
                {c,a,a,a,a,c,a,a,a,a,a},
                {c,a,a,a,a,c,a,a,a,a,a},
                {c,a,a,a,a,c,a,a,a,a,a},
                {c,a,a,a,a,c,a,a,a,a,a},
                {c,c,c,c,c,c,c,c,c,c,c},
                {a,a,a,a,a,c,a,a,a,a,c},
                {a,a,a,a,a,c,a,a,a,a,c},
                {a,a,a,a,a,c,a,a,a,a,c},
                {a,a,a,a,a,c,a,a,a,a,c},
                {c,c,c,c,c,c,a,a,a,a,c},
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
