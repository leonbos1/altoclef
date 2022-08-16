package adris.altoclef.commands;

import adris.altoclef.AltoClef;
import adris.altoclef.buildings.Building;
import adris.altoclef.buildings.Hakenkruis;
import adris.altoclef.buildings.O;
import adris.altoclef.buildings.StringToBlock;
import adris.altoclef.commandsystem.*;
import adris.altoclef.tasks.construction.build2DBuildingTask;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import java.util.Objects;

public class BuildCommand extends Command {

    public BuildCommand() throws CommandException {
        super("build", "build a 2d structure",
                new Arg(String.class, "structure"),
                new Arg(String.class, "blocktype")
        );

    }

    private boolean isValidBuilding(String building) {

        if (Objects.equals(building, "O")) {
            return true;
        }
        if (Objects.equals(building, "hakenkruis")) {
            return true;
        }

        return false;

    }

    private Building getBuilding(String building, Block blocktype) {

        return switch (building) {
            case "O" -> new O(blocktype);
            case "hakenkruis" -> new Hakenkruis(blocktype);
            default -> new O(blocktype);
        };
    }

    @Override
    protected void call(AltoClef mod, ArgParser parser) throws CommandException {

        String structure = parser.get(String.class);
        String blockString = parser.get(String.class);
        Block block = StringToBlock.stringToBlock(blockString);

        if (!isValidBuilding(structure)) return;

        Building building = getBuilding(structure, block);

        mod.runUserTask(new build2DBuildingTask(mod, building), this::finish);

    }
}
