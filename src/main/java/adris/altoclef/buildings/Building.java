package adris.altoclef.buildings;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

public interface Building {

    int getBlocksNeeded();

    int getLength();

    int getHeight();

    Block[][] getBlueprint();

    Block getBlocktype();

}
