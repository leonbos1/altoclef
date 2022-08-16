package adris.altoclef.buildings;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

public class StringToBlock {

    public static Block stringToBlock(String str) {
        switch (str) {
            case "cobblestone":
                return Blocks.COBBLESTONE;
            case "stone":
                return Blocks.STONE;
            case "diamond_block":
                return Blocks.DIAMOND_BLOCK;
            case "dirt":
                return Blocks.DIRT;
            case "oak_planks":
                return Blocks.OAK_PLANKS;
            case "gold_block":
                return Blocks.GOLD_BLOCK;
            case "emerald_block":
                return Blocks.EMERALD_BLOCK;
            case "oak_log":
                return Blocks.OAK_LOG;


            default:
                return Blocks.DIRT;
        }
    }

}
