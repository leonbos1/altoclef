package adris.altoclef.tasks.construction;

import adris.altoclef.AltoClef;
import adris.altoclef.TaskCatalogue;
import adris.altoclef.buildings.Building;
import adris.altoclef.commandsystem.CommandException;
import adris.altoclef.tasks.construction.compound.ConstructRonTask;
import adris.altoclef.tasksystem.Task;
import adris.altoclef.util.helpers.WorldHelper;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;

import net.minecraft.util.math.BlockPos;

import java.util.ArrayList;

public class build2DBuildingTask extends Task {

    private final BlockPos _position;
    private Task _collectingTask;
    private final Building _building;
    private final ArrayList<Task> _tasksToDo;
    private final Item BuildingItem;
    private final Block BuildingBlock;

    public build2DBuildingTask(AltoClef mod, Building building) {
        _position = mod.getPlayer().getBlockPos();
        _building = building;
        _tasksToDo = new ArrayList<>();
        BuildingBlock = _building.getBlocktype();
        BuildingItem = BuildingBlock.asItem();
    }

    @Override
    protected void onStart(AltoClef mod) {
        mod.getBehaviour().push();
        mod.getBehaviour().addProtectedItems(BuildingItem);
        mod.getClientBaritoneSettings().blocksToDisallowBreaking.value.add(BuildingBlock);
        makeTasks(mod);
    }


    @Override
    protected Task onTick(AltoClef mod) {

        if (!mod.getItemStorage().hasItem(BuildingItem)) {
            _collectingTask = TaskCatalogue.getItemTask(BuildingItem, this.getBlocksLeft(mod));
        }

        if (mod.getItemStorage().getItemCountInventoryOnly(BuildingItem) >= getBlocksLeft(mod)) {
            for (Task task : _tasksToDo) {
                if (!task.isFinished(mod)) {
                    return task;
                }
            }
        }
        if (getBlocksLeft(mod) == 0) {
            _collectingTask = removeHelperBlocks(mod);
        }

        return _collectingTask;
    }


    @Override
    protected void onStop(AltoClef mod, Task interruptTask) {
        mod.getClientBaritoneSettings().blocksToAvoidBreaking.value.remove(Blocks.COBBLESTONE);
        mod.getBehaviour().pop();
    }

    @Override
    protected boolean isEqual(Task other) {
        return other instanceof ConstructRonTask;
    }

    @Override
    public boolean isFinished(AltoClef mod) {
        for (int i = _building.getHeight(); i > 0; i--) {
            for (int j = 0; j < _building.getLength(); j++) {

                BlockPos pos = new BlockPos(_position.up(_building.getHeight() - i).north(j));

                if (!WorldHelper.isBlock(mod, pos, _building.getBlueprint()[i - 1][j])) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    protected String toDebugString() {
        return "Building something";
    }

    private Task removeHelperBlocks(AltoClef mod) {
        for (int i = _building.getHeight(); i > 0; i--) {
            for (int j = 0; j < _building.getLength(); j++) {

                BlockPos pos = new BlockPos(_position.up(_building.getHeight() - i).north(j));

                if (_building.getBlueprint()[i - 1][j] == Blocks.AIR) {
                    if (!WorldHelper.isBlock(mod, pos, Blocks.AIR)) {
                        return new DestroyBlockTask(pos);
                    }
                }
            }
        }
        return TaskCatalogue.getItemTask(BuildingItem, this.getBlocksLeft(mod));
    }

    private int getBlocksLeft(AltoClef mod) {
        int amount = 0;
        for (int i = _building.getHeight(); i > 0; i--) {
            for (int j = 0; j < _building.getLength(); j++) {

                BlockPos pos = new BlockPos(_position.up(_building.getHeight() - i).north(j));

                if (_building.getBlueprint()[i - 1][j] == BuildingBlock) {
                    if (!WorldHelper.isBlock(mod, pos, BuildingBlock)) {
                        amount++;
                    }
                }
            }
        }
        return amount;
    }

    private void makeTasks(AltoClef mod) {
        ;
        for (int i = _building.getHeight(); i > 0; i--) {
            for (int j = 0; j < _building.getLength(); j++) {

                BlockPos pos = new BlockPos(_position.up(_building.getHeight() - i).north(j));

                if (_building.getBlueprint()[i - 1][j] == BuildingBlock) {
                    if (!WorldHelper.isBlock(mod, pos, BuildingBlock)) {
                        if (WorldHelper.isBlock(mod, pos, Blocks.AIR)) {
                            _tasksToDo.add(new PlaceBlockTask(pos, BuildingBlock));
                        } else {
                            _tasksToDo.add(new DestroyBlockTask(pos));
                        }
                    }
                }
            }
        }
    }
}
