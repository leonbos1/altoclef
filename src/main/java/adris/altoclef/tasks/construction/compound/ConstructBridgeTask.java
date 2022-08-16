package adris.altoclef.tasks.construction.compound;

import adris.altoclef.AltoClef;
import adris.altoclef.TaskCatalogue;
import adris.altoclef.tasks.construction.DestroyBlockTask;
import adris.altoclef.tasks.construction.PlaceBlockTask;
import adris.altoclef.tasks.resources.CollectCobblestoneTask;
import adris.altoclef.tasks.resources.MineAndCollectTask;
import adris.altoclef.tasks.squashed.CataloguedResourceTask;
import adris.altoclef.tasks.stupid.SkipTask;
import adris.altoclef.tasksystem.Task;
import adris.altoclef.util.ItemTarget;
import adris.altoclef.util.MiningRequirement;
import adris.altoclef.util.helpers.StorageHelper;
import adris.altoclef.util.helpers.WorldHelper;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.system.CallbackI;

import java.util.Optional;

public class ConstructBridgeTask extends Task {
    private BlockPos _position;
    private boolean _canBeFinished = false;
    private int c = 0;
    private int counter = 0;
    private Task task;

    public ConstructBridgeTask(AltoClef mod) {
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
            System.out.println("collecting");
            this.task = new MineAndCollectTask(Items.COBBLESTONE, 16, new Block[]{Blocks.STONE, Blocks.COBBLESTONE}, MiningRequirement.WOOD);
        }

        if (this.task == null) {
            System.out.println("building");
            if (WorldHelper.isBlock(mod, _position.north(c), Blocks.AIR)) {
                return new PlaceBlockTask(_position.north(c), Blocks.COBBLESTONE);
            }
            if (WorldHelper.isBlock(mod, _position.north(c).east(), Blocks.AIR)) {
                return new PlaceBlockTask(_position.north(c).east(), Blocks.COBBLESTONE);
            }
            if (WorldHelper.isBlock(mod, _position.north(c).west(), Blocks.AIR)) {
                c++;
                return new PlaceBlockTask(_position.north(c-1).west(), Blocks.COBBLESTONE);
            }
        }

        if (this.task.isFinished(mod)) {
            this.task = null;
            System.out.println("Finished");
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
        return other instanceof ConstructBridgeTask;
    }

    @Override
    public boolean isFinished(AltoClef mod) {
        return false;
    }

    @Override
    protected String toDebugString() {
        return "Construct bridge";
    }
}
