package adris.altoclef.buildings;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;

import java.util.Arrays;

public abstract class Building {

    private final int length;
    private final int height;
    private final Block[][] blueprint;
    private final Block blockType;

    public Building(int[][] blueprint, Block blockType) {
        this.blockType = blockType;
        this.blueprint = convertBlueprint(blueprint);
        int blocksNeeded = getBlocksNeeded();
        this.length = this.blueprint[0].length;
        this.height = this.blueprint.length;
    }

    private Block[][] convertBlueprint(int[][] blueprint) {
        Block[][] result = new Block[blueprint.length][blueprint[0].length];

        Block block = this.blockType;

        for (int i = 0; i < blueprint.length; i++) {
            for (int j = 0; j < blueprint[0].length; j++) {

                if (blueprint[i][j] == 0) {
                    result[i][j] = Blocks.AIR;
                }
                else {
                    result[i][j] = block;
                }
            }
        }

        return result;
    }

    public int getBlocksNeeded() {
        int i = 0;
        for (Block[] b : blueprint) {
            for (Block block : b) {
                if (block != Blocks.AIR) {
                    i++;
                }
            }
        }
        return i;
    }

    public int getLength() {
        return this.length;
    }

    public int getHeight() {
        return this.height;
    }

    public Block[][] getBlueprint() {
        return this.blueprint;
    }

    public Block getBlocktype() {
        return this.blockType;
    }

}
