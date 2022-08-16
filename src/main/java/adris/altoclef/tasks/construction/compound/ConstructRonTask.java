package adris.altoclef.tasks.construction.compound;

import adris.altoclef.AltoClef;
import adris.altoclef.tasks.construction.DestroyBlockTask;
import adris.altoclef.tasks.construction.PlaceBlockTask;
import adris.altoclef.tasks.resources.MineAndCollectTask;
import adris.altoclef.tasksystem.Task;
import adris.altoclef.util.ItemTarget;
import adris.altoclef.util.MiningRequirement;
import adris.altoclef.util.helpers.WorldHelper;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;

public class ConstructRonTask extends Task {
    private BlockPos _position;
    private boolean _canBeFinished = false;
    private int c = 0;
    private int counter = 0;
    private Task task;

    public ConstructRonTask(AltoClef mod) {
        _position = mod.getPlayer().getBlockPos();
    }

    @Override
    protected void onStart(AltoClef mod) {
        mod.getBehaviour().push();
        mod.getBehaviour().addProtectedItems(Items.COBBLESTONE);
        mod.getClientBaritoneSettings().blocksToDisallowBreaking.value.add(Blocks.COBBLESTONE);
    }

    @Override
    protected Task onTick(AltoClef mod) {

        setDebugState("Getting cobblestone");

        if (!mod.getItemStorage().hasItem(Items.COBBLESTONE)) {

            this.task = new MineAndCollectTask(Items.COBBLESTONE, 38, new Block[]{Blocks.STONE, Blocks.COBBLESTONE}, MiningRequirement.WOOD);
        }

        if (this.task == null) {

            //clear floor
            if (WorldHelper.isBlock(mod, _position.down(), Blocks.AIR)) {
                return new PlaceBlockTask(_position.down(), Blocks.COBBLESTONE);
            }
            if (WorldHelper.isBlock(mod, _position.down().north(), Blocks.AIR)) {
                return new PlaceBlockTask(_position.down().north(), Blocks.COBBLESTONE);
            }
            if (WorldHelper.isBlock(mod, _position.down().north(2), Blocks.AIR)) {
                return new PlaceBlockTask(_position.down().north(2), Blocks.COBBLESTONE);
            }
            if (WorldHelper.isBlock(mod, _position.down().north(3), Blocks.AIR)) {
                return new PlaceBlockTask(_position.down().north(3), Blocks.COBBLESTONE);
            }
            if (WorldHelper.isBlock(mod, _position.down().north(4), Blocks.AIR)) {
                return new PlaceBlockTask(_position.down().north(4), Blocks.COBBLESTONE);
            }
            if (WorldHelper.isBlock(mod, _position.down().north(5), Blocks.AIR)) {
                return new PlaceBlockTask(_position.down().north(5), Blocks.COBBLESTONE);
            }
            if (WorldHelper.isBlock(mod, _position.down().north(6), Blocks.AIR)) {
                return new PlaceBlockTask(_position.down().north(6), Blocks.COBBLESTONE);
            }
            if (WorldHelper.isBlock(mod, _position.down().north(7), Blocks.AIR)) {
                return new PlaceBlockTask(_position.down().north(7), Blocks.COBBLESTONE);
            }
            if (WorldHelper.isBlock(mod, _position.down().north(8), Blocks.AIR)) {
                return new PlaceBlockTask(_position.down().north(8), Blocks.COBBLESTONE);
            }
            if (WorldHelper.isBlock(mod, _position.down().north(9), Blocks.AIR)) {
                return new PlaceBlockTask(_position.down().north(9), Blocks.COBBLESTONE);
            }
            if (WorldHelper.isBlock(mod, _position.down().north(10), Blocks.AIR)) {
                return new PlaceBlockTask(_position.down().north(10), Blocks.COBBLESTONE);
            }
            if (WorldHelper.isBlock(mod, _position.down().north(11), Blocks.AIR)) {
                return new PlaceBlockTask(_position.down().north(11), Blocks.COBBLESTONE);
            }
            if (WorldHelper.isBlock(mod, _position.down().north(12), Blocks.AIR)) {
                return new PlaceBlockTask(_position.down().north(12), Blocks.COBBLESTONE);
            }


            //R
            if (WorldHelper.isBlock(mod, _position, Blocks.AIR)) {
                return new PlaceBlockTask(_position, Blocks.COBBLESTONE);
            }
            if (!WorldHelper.isBlock(mod, _position, Blocks.AIR)) {
                return new DestroyBlockTask(_position);
            }


            if (WorldHelper.isBlock(mod, _position.up(), Blocks.AIR)) {
                return new PlaceBlockTask(_position.up(), Blocks.COBBLESTONE);
            }
            if (!WorldHelper.isBlock(mod, _position.up(), Blocks.AIR)) {
                return new DestroyBlockTask(_position.up());
            }


            if (WorldHelper.isBlock(mod, _position.up(2), Blocks.AIR)) {
                return new PlaceBlockTask(_position.up(2), Blocks.COBBLESTONE);
            }
            if (!WorldHelper.isBlock(mod, _position.up(2), Blocks.AIR)) {
                return new DestroyBlockTask(_position.up(2));
            }


            if (WorldHelper.isBlock(mod, _position.up(3), Blocks.AIR)) {
                return new PlaceBlockTask(_position.up(3), Blocks.COBBLESTONE);
            }
            if (!WorldHelper.isBlock(mod, _position.up(3), Blocks.AIR)) {
                return new DestroyBlockTask(_position.up(3));
            }


            if (WorldHelper.isBlock(mod, _position.up(4), Blocks.AIR)) {
                return new PlaceBlockTask(_position.up(4), Blocks.COBBLESTONE);
            }
            if (!WorldHelper.isBlock(mod, _position.up(4), Blocks.AIR)) {
                return new DestroyBlockTask(_position.up(4));
            }


            if (WorldHelper.isBlock(mod, _position.up(4).north(), Blocks.AIR)) {
                return new PlaceBlockTask(_position.up(4).north(), Blocks.COBBLESTONE);
            }
            if (!WorldHelper.isBlock(mod, _position.up(4).north(), Blocks.AIR)) {
                return new DestroyBlockTask(_position.up(4).north());
            }


            if (WorldHelper.isBlock(mod, _position.up(4).north(2), Blocks.AIR)) {
                return new PlaceBlockTask(_position.up(4).north(2), Blocks.COBBLESTONE);
            }
            if (!WorldHelper.isBlock(mod, _position.up(4).north(2), Blocks.AIR)) {
                return new DestroyBlockTask(_position.up(4).north(2));
            }


            if (WorldHelper.isBlock(mod, _position.up(3).north(2), Blocks.AIR)) {
                return new PlaceBlockTask(_position.up(3).north(2), Blocks.COBBLESTONE);
            }
            if (!WorldHelper.isBlock(mod, _position.up(3).north(2), Blocks.AIR)) {
                return new DestroyBlockTask(_position.up(3).north(2));
            }


            if (WorldHelper.isBlock(mod, _position.up(2).north(2), Blocks.AIR)) {
                return new PlaceBlockTask(_position.up(2).north(2), Blocks.COBBLESTONE);
            }
            if (!WorldHelper.isBlock(mod, _position.up(2).north(2), Blocks.AIR)) {
                return new DestroyBlockTask(_position.up(2).north(2));
            }


            if (WorldHelper.isBlock(mod, _position.up(2).north(), Blocks.AIR)) {
                return new PlaceBlockTask(_position.up(2).north(), Blocks.COBBLESTONE);
            }
            if (!WorldHelper.isBlock(mod, _position.up(2).north(), Blocks.AIR)) {
                return new DestroyBlockTask(_position.up(2).north());
            }


            if (WorldHelper.isBlock(mod, _position.up().north(2), Blocks.AIR)) {
                return new PlaceBlockTask(_position.up().north(2), Blocks.COBBLESTONE);
            }
            if (!WorldHelper.isBlock(mod, _position.up().north(2), Blocks.AIR)) {
                return new DestroyBlockTask(_position.up().north(2));
            }


            if (WorldHelper.isBlock(mod, _position.north(3), Blocks.AIR)) {
                return new PlaceBlockTask(_position.north(3), Blocks.COBBLESTONE);
            }
            if (!WorldHelper.isBlock(mod, _position.north(3), Blocks.AIR)) {
                return new DestroyBlockTask(_position.north(3));
            }


            // O
            if (WorldHelper.isBlock(mod, _position.north(5), Blocks.AIR)) {
                return new PlaceBlockTask(_position.north(5), Blocks.COBBLESTONE);
            }
            if (!WorldHelper.isBlock(mod, _position.north(5), Blocks.AIR)) {
                return new DestroyBlockTask(_position.north(5));
            }


            if (WorldHelper.isBlock(mod, _position.north(6), Blocks.AIR)) {
                return new PlaceBlockTask(_position.north(6), Blocks.COBBLESTONE);
            }
            if (!WorldHelper.isBlock(mod, _position.north(6), Blocks.AIR)) {
                return new DestroyBlockTask(_position.north(6));
            }


            if (WorldHelper.isBlock(mod, _position.north(7), Blocks.AIR)) {
                return new PlaceBlockTask(_position.north(7), Blocks.COBBLESTONE);
            }
            if (!WorldHelper.isBlock(mod, _position.north(7), Blocks.AIR)) {
                return new DestroyBlockTask(_position.north(7));
            }


            if (WorldHelper.isBlock(mod, _position.north(5).up(), Blocks.AIR)) {
                return new PlaceBlockTask(_position.north(5).up(), Blocks.COBBLESTONE);
            }
            if (!WorldHelper.isBlock(mod, _position.north(5).up(), Blocks.AIR)) {
                return new DestroyBlockTask(_position.north(5).up());
            }


            if (WorldHelper.isBlock(mod, _position.north(5).up(2), Blocks.AIR)) {
                return new PlaceBlockTask(_position.north(5).up(2), Blocks.COBBLESTONE);
            }
            if (!WorldHelper.isBlock(mod, _position.north(5).up(2), Blocks.AIR)) {
                return new DestroyBlockTask(_position.north(5).up(2));
            }


            if (WorldHelper.isBlock(mod, _position.north(5).up(3), Blocks.AIR)) {
                return new PlaceBlockTask(_position.north(5).up(3), Blocks.COBBLESTONE);
            }
            if (!WorldHelper.isBlock(mod,  _position.north(5).up(3), Blocks.AIR)) {
                return new DestroyBlockTask( _position.north(5).up(3));
            }


            if (WorldHelper.isBlock(mod, _position.north(5).up(4), Blocks.AIR)) {
                return new PlaceBlockTask(_position.north(5).up(4), Blocks.COBBLESTONE);
            }
            if (!WorldHelper.isBlock(mod, _position.north(5).up(4), Blocks.AIR)) {
                return new DestroyBlockTask(_position.north(5).up(4));
            }


            if (WorldHelper.isBlock(mod, _position.north(6).up(4), Blocks.AIR)) {
                return new PlaceBlockTask(_position.north(6).up(4), Blocks.COBBLESTONE);
            }
            if (!WorldHelper.isBlock(mod, _position.north(6).up(4), Blocks.AIR)) {
                return new DestroyBlockTask(_position.north(6).up(4));
            }

            if (WorldHelper.isBlock(mod, _position.north(7).up(4), Blocks.AIR)) {
                return new PlaceBlockTask(_position.north(7).up(4), Blocks.COBBLESTONE);
            }
            if (!WorldHelper.isBlock(mod, _position.north(7).up(4), Blocks.AIR)) {
                return new DestroyBlockTask(_position.north(7).up(4));
            }


            if (WorldHelper.isBlock(mod, _position.north(7).up(3), Blocks.AIR)) {
                return new PlaceBlockTask(_position.north(7).up(3), Blocks.COBBLESTONE);
            }
            if (!WorldHelper.isBlock(mod, _position.north(7).up(3), Blocks.AIR)) {
                return new DestroyBlockTask(_position.north(7).up(3));
            }


            if (WorldHelper.isBlock(mod, _position.north(7).up(2), Blocks.AIR)) {
                return new PlaceBlockTask(_position.north(7).up(2), Blocks.COBBLESTONE);
            }
            if (!WorldHelper.isBlock(mod, _position.north(7).up(2), Blocks.AIR)) {
                return new DestroyBlockTask(_position.north(7).up(2));
            }


            if (WorldHelper.isBlock(mod, _position.north(7).up(), Blocks.AIR)) {
                return new PlaceBlockTask(_position.north(7).up(), Blocks.COBBLESTONE);
            }
            if (!WorldHelper.isBlock(mod, _position.north(7).up(), Blocks.AIR)) {
                return new DestroyBlockTask(_position.north(7).up());
            }


            //N
            if (WorldHelper.isBlock(mod, _position.north(9), Blocks.AIR)) {
                return new PlaceBlockTask(_position.north(9), Blocks.COBBLESTONE);
            }
            if (!WorldHelper.isBlock(mod, _position.north(9), Blocks.AIR)) {
                return new DestroyBlockTask(_position.north(9));
            }


            if (WorldHelper.isBlock(mod, _position.north(9).up(), Blocks.AIR)) {
                return new PlaceBlockTask(_position.north(9).up(), Blocks.COBBLESTONE);
            }
            if (!WorldHelper.isBlock(mod, _position.north(9).up(), Blocks.AIR)) {
                return new DestroyBlockTask(_position.north(9).up());
            }


            if (WorldHelper.isBlock(mod, _position.north(9).up(2), Blocks.AIR)) {
                return new PlaceBlockTask(_position.north(9).up(2), Blocks.COBBLESTONE);
            }
            if (!WorldHelper.isBlock(mod, _position.north(9).up(2), Blocks.AIR)) {
                return new DestroyBlockTask(_position.north(9).up(2));
            }


            if (WorldHelper.isBlock(mod, _position.north(9).up(3), Blocks.AIR)) {
                return new PlaceBlockTask(_position.north(9).up(3), Blocks.COBBLESTONE);
            }
            if (!WorldHelper.isBlock(mod, _position.north(9).up(3), Blocks.AIR)) {
                return new DestroyBlockTask(_position.north(9).up(3));
            }


            if (WorldHelper.isBlock(mod, _position.north(9).up(4), Blocks.AIR)) {
                return new PlaceBlockTask(_position.north(9).up(4), Blocks.COBBLESTONE);
            }
            if (!WorldHelper.isBlock(mod,  _position.north(9).up(4), Blocks.AIR)) {
                return new DestroyBlockTask( _position.north(9).up(4));
            }


            if (WorldHelper.isBlock(mod, _position.north(10).up(2), Blocks.AIR)) {
                return new PlaceBlockTask(_position.north(10).up(2), Blocks.COBBLESTONE);
            }
            if (!WorldHelper.isBlock(mod, _position.north(10).up(2), Blocks.AIR)) {
                return new DestroyBlockTask(_position.north(10).up(2));
            }


            if (WorldHelper.isBlock(mod, _position.north(10).up(3), Blocks.AIR)) {
                return new PlaceBlockTask(_position.north(10).up(3), Blocks.COBBLESTONE);
            }
            if (!WorldHelper.isBlock(mod, _position.north(10).up(3), Blocks.AIR)) {
                return new DestroyBlockTask(_position.north(10).up(3));
            }


            if (WorldHelper.isBlock(mod, _position.north(11), Blocks.AIR)) {
                return new PlaceBlockTask(_position.north(11), Blocks.COBBLESTONE);
            }
            if (!WorldHelper.isBlock(mod, _position.north(11), Blocks.AIR)) {
                return new DestroyBlockTask(_position.north(11));
            }


            if (WorldHelper.isBlock(mod, _position.north(11).up(), Blocks.AIR)) {
                return new PlaceBlockTask(_position.north(11).up(), Blocks.COBBLESTONE);
            }
            if (!WorldHelper.isBlock(mod, _position.north(11).up(), Blocks.AIR)) {
                return new DestroyBlockTask(_position.north(11).up());
            }


            if (WorldHelper.isBlock(mod, _position.north(12), Blocks.AIR)) {
                return new PlaceBlockTask(_position.north(12), Blocks.COBBLESTONE);
            }
            if (!WorldHelper.isBlock(mod, _position.north(12), Blocks.AIR)) {
                return new DestroyBlockTask(_position.north(12));
            }


            if (WorldHelper.isBlock(mod, _position.north(12).up(), Blocks.AIR)) {
                return new PlaceBlockTask(_position.north(12).up(), Blocks.COBBLESTONE);
            }
            if (!WorldHelper.isBlock(mod,  _position.north(12).up(), Blocks.AIR)) {
                return new DestroyBlockTask( _position.north(12).up());
            }


            if (WorldHelper.isBlock(mod, _position.north(12).up(2), Blocks.AIR)) {
                return new PlaceBlockTask(_position.north(12).up(2), Blocks.COBBLESTONE);
            }
            if (!WorldHelper.isBlock(mod,  _position.north(12).up(2), Blocks.AIR)) {
                return new DestroyBlockTask( _position.north(12).up(2));
            }


            if (WorldHelper.isBlock(mod, _position.north(12).up(3), Blocks.AIR)) {
                return new PlaceBlockTask(_position.north(12).up(3), Blocks.COBBLESTONE);
            }
            if (!WorldHelper.isBlock(mod, _position.north(12).up(3), Blocks.AIR)) {
                return new DestroyBlockTask(_position.north(12).up(3));
            }


            if (WorldHelper.isBlock(mod, _position.north(12).up(4), Blocks.AIR)) {
                return new PlaceBlockTask(_position.north(12).up(4), Blocks.COBBLESTONE);
            }
            if (!WorldHelper.isBlock(mod,  _position.north(12).up(4), Blocks.AIR)) {
                return new DestroyBlockTask( _position.north(12).up(4));
            }

            else {
                _position = new BlockPos(_position.getX() + 30, _position.getY(), _position.getZ());
                this.task = null;
                return this.task;
            }

        }

        if (this.task.isFinished(mod)) {
            this.task = null;
        }

        return this.task;

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
        return false;
    }

    @Override
    protected String toDebugString() {
        return "Construct ron";
    }

}
