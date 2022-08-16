package adris.altoclef.tasks.construction.compound;

import adris.altoclef.AltoClef;
import adris.altoclef.tasks.construction.DestroyBlockTask;
import adris.altoclef.tasks.construction.PlaceBlockTask;
import adris.altoclef.tasks.squashed.CataloguedResourceTask;
import adris.altoclef.tasksystem.Task;
import adris.altoclef.util.ItemTarget;
import adris.altoclef.util.helpers.StorageHelper;
import adris.altoclef.util.helpers.WorldHelper;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

import java.util.Optional;

public class ConstructWitherTask extends Task {
    private BlockPos _position;
    private boolean _canBeFinished = false;

    public ConstructWitherTask() {

    }

    public ConstructWitherTask(BlockPos pos) {
        _position = pos;
    }

    @Override
    protected void onStart(AltoClef mod) {
        mod.getBehaviour().push();
        mod.getBehaviour().addProtectedItems(Items.SOUL_SAND, Items.WITHER_SKELETON_SKULL);
        mod.getClientBaritoneSettings().blocksToAvoidBreaking.value.add(Blocks.SOUL_SAND);
        mod.getClientBaritoneSettings().blocksToAvoidBreaking.value.add(Blocks.WITHER_SKELETON_SKULL);
    }

    @Override
    protected Task onTick(AltoClef mod) {
        if (!StorageHelper.itemTargetsMetInventory(mod, witherMaterials(mod))) {
            setDebugState("Getting materials for the wither");
            return new CataloguedResourceTask(witherMaterials(mod));
        }
        if (_position == null) {
            for (BlockPos pos : WorldHelper.scanRegion(mod,
                    new BlockPos(mod.getPlayer().getBlockX(), 64, mod.getPlayer().getBlockZ()),
                    new BlockPos(mod.getPlayer().getBlockX(), 128, mod.getPlayer().getBlockZ()))) {
                if (mod.getWorld().getBlockState(pos).getBlock() == Blocks.AIR) {
                    _position = pos;
                    break;
                }
            }
            if (_position == null) {
                _position = mod.getPlayer().getBlockPos();
            }
        }
        if (!WorldHelper.isBlock(mod, _position, Blocks.SOUL_SAND)) {
            if (!WorldHelper.isBlock(mod, _position, Blocks.AIR)) {
                setDebugState("Destroying block in way of base soul sand");
                return new DestroyBlockTask(_position);
            }
            setDebugState("Placing the base soul sand");
            return new PlaceBlockTask(_position, Blocks.SOUL_SAND);
        }
//        mod.getPlayer().getServer().getPlayerManager().getPlayer("camelCasedSnivy").getAdvancementTracker()
        if (!WorldHelper.isBlock(mod, _position.up(), Blocks.SOUL_SAND)) {
            if (!WorldHelper.isBlock(mod, _position.up(), Blocks.AIR)) {
                setDebugState("Destroying block in way of center wither");
                return new DestroyBlockTask(_position.up());
            }
            setDebugState("Placing the center wither");
            return new PlaceBlockTask(_position.up(), Blocks.SOUL_SAND);
        }
        if (!WorldHelper.isBlock(mod, _position.up().east(), Blocks.SOUL_SAND)) {
            if (!WorldHelper.isBlock(mod, _position.up().east(), Blocks.AIR)) {
                setDebugState("Destroying block in way of east wither");
                return new DestroyBlockTask(_position.up().east());
            }
            setDebugState("Placing the east wither");
            return new PlaceBlockTask(_position.up().east(), Blocks.SOUL_SAND);
        }
        if (!WorldHelper.isBlock(mod, _position.up().west(), Blocks.SOUL_SAND)) {
            if (!WorldHelper.isBlock(mod, _position.up().west(), Blocks.AIR)) {
                setDebugState("Destroying block in way of west wither");
                return new DestroyBlockTask(_position.up().west());
            }
            setDebugState("Placing the west wither");
            return new PlaceBlockTask(_position.up().west(), Blocks.SOUL_SAND);
        }
        if (!WorldHelper.isBlock(mod, _position.east(), Blocks.AIR)) {
            setDebugState("Clearing area on east side...");
            return new DestroyBlockTask(_position.east());
        }
        if (!WorldHelper.isBlock(mod, _position.west(), Blocks.AIR)) {
            setDebugState("Clearing area on west side...");
            return new DestroyBlockTask(_position.west());
        }
        _canBeFinished = true;
        setDebugState("Placing the skull (I think)");
        if (!WorldHelper.isBlock(mod, _position.up(2), Blocks.WITHER_SKELETON_SKULL)) {
            System.out.println("BLOCK IS NOT WITHER SKELETON");
            if (!WorldHelper.isBlock(mod, _position.up(2), Blocks.AIR)) {
                setDebugState("Destroying block in way of skull");
                return new DestroyBlockTask(_position.up(2));
            }
            else {
                return new PlaceBlockTask(_position.up(2), Blocks.WITHER_SKELETON_SKULL);
            }
        }

        if (!WorldHelper.isBlock(mod, _position.up(2).east(), Blocks.WITHER_SKELETON_SKULL)) {
            if (!WorldHelper.isBlock(mod, _position.up(2).east(), Blocks.AIR)) {
                setDebugState("Destroying block in way of skull");
                return new DestroyBlockTask(_position.up(2).east());
            }
            else {
                return new PlaceBlockTask(_position.up(2).east(), Blocks.WITHER_SKELETON_SKULL);
            }
        }

        else {
            if (!WorldHelper.isBlock(mod, _position.up(2).west(), Blocks.AIR)) {
                setDebugState("Destroying block in way of skull");
                return new DestroyBlockTask(_position.up(2).west());
            }
            else {
                return new PlaceBlockTask(_position.up(2).west(), Blocks.WITHER_SKELETON_SKULL);
            }
        }
    }

    @Override
    protected void onStop(AltoClef mod, Task interruptTask) {
        mod.getClientBaritoneSettings().blocksToAvoidBreaking.value.remove(Blocks.SOUL_SAND);
        mod.getBehaviour().pop();
    }

    @Override
    protected boolean isEqual(Task other) {
        return other instanceof ConstructWitherTask;
    }

    @Override
    public boolean isFinished(AltoClef mod) {
        if (_position == null) return false;
        Optional<Entity> closestWither = mod.getEntityTracker().getClosestEntity(new Vec3d(_position.getX(), _position.getY(), _position.getZ()), WitherEntity.class);
        return closestWither.isPresent() && closestWither.get().getBlockPos().isWithinDistance(_position, 2) && _canBeFinished;
    }

    @Override
    protected String toDebugString() {
        return "Construct wither";
    }

    private int SoulSandNeeded(AltoClef mod) {
        if (_position == null) {
            return 4;
        }
        int needed = 0;
        if (mod.getWorld().getBlockState(_position).getBlock() != Blocks.SOUL_SAND)
            needed++;
        if (mod.getWorld().getBlockState(_position.up().west()).getBlock() != Blocks.SOUL_SAND)
            needed++;
        if (mod.getWorld().getBlockState(_position.up().east()).getBlock() != Blocks.SOUL_SAND)
            needed++;
        if (mod.getWorld().getBlockState(_position.up()).getBlock() != Blocks.SOUL_SAND)
            needed++;
        return needed;
    }

    private ItemTarget[] witherMaterials(AltoClef mod) {
        if (_position == null || mod.getWorld().getBlockState(_position.up(2)).getBlock() != Blocks.WITHER_SKELETON_SKULL) return new ItemTarget[]{
                new ItemTarget(Items.SOUL_SAND, SoulSandNeeded(mod)),
                new ItemTarget(Items.WITHER_SKELETON_SKULL, 3)
        }; else return new ItemTarget[]{
                new ItemTarget(Items.SOUL_SAND, SoulSandNeeded(mod))
        };
    }
}
