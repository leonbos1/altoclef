package adris.altoclef.tasks.resources;


import adris.altoclef.AltoClef;
import adris.altoclef.Debug;
import adris.altoclef.TaskCatalogue;
import adris.altoclef.tasks.CraftInInventoryTask;
import adris.altoclef.tasks.CraftInTableTask;
import adris.altoclef.tasks.ResourceTask;
import adris.altoclef.tasksystem.Task;
import adris.altoclef.util.CraftingRecipe;
import adris.altoclef.util.ItemTarget;
import net.minecraft.item.Item;


public abstract class CraftWithMatchingMaterialsTask extends ResourceTask {
    private final ItemTarget target;
    private final CraftingRecipe recipe;
    private final boolean[] sameMask;
    private final ItemTarget sameResourceTarget;
    private final int sameResourceRequiredCount;
    private final int sameResourcePerRecipe;

    public CraftWithMatchingMaterialsTask(ItemTarget target, CraftingRecipe recipe, boolean[] sameMask) {
        super(target);
        this.target = target;
        this.recipe = recipe;
        this.sameMask = sameMask;
        int sameResourceRequiredCount = 0;
        ItemTarget sameResourceTarget = null;
        if (recipe.getSlotCount() != sameMask.length) {
            Debug.logError("Invalid CraftWithMatchingMaterialsTask constructor parameters: Recipe size must equal \"sameMask\" size.");
        }
        for (int i = 0; i < recipe.getSlotCount(); ++i) {
            if (sameMask[i]) {
                sameResourceRequiredCount++;
                ItemTarget t = recipe.getSlot(i);
                sameResourceTarget = t;
            }
        }
        this.sameResourceTarget = sameResourceTarget;
        int craftsNeeded = (int) (1 + Math.floor((double) target.targetCount / recipe.outputCount() - 0.001));
        sameResourcePerRecipe = sameResourceRequiredCount;
        this.sameResourceRequiredCount = sameResourceRequiredCount * craftsNeeded;
    }

    private static CraftingRecipe generateSamedRecipe(CraftingRecipe diverseRecipe, Item sameItem, boolean[] sameMask) {
        ItemTarget[] result = new ItemTarget[diverseRecipe.getSlotCount()];
        for (int i = 0; i < result.length; ++i) {
            if (sameMask[i]) {
                result[i] = new ItemTarget(sameItem, 1);
            } else {
                result[i] = diverseRecipe.getSlot(i);
            }
        }
        return CraftingRecipe.newShapedRecipe(result, diverseRecipe.outputCount());
    }

    @Override
    protected void onResourceStart(AltoClef mod) {

    }

    @Override
    protected Task onResourceTick(AltoClef mod) {

        // TODO: Scenario of
        //      Command: Get 3 beds
        //
        //      We have 3 red wool
        //      We have 6 white wool
        //
        //      The system should craft 1 red bed + 2 white beds
        //      BUT since it needs 9 of the --SAME WOOL-- it keeps going.
        //      You should MAP for each type how many can fit into --_sameResourcePerRecipe-- and grab from THAT list.

        /*
         * 0) Figure out the "same resource" item target
         * 1) Get the "same resource" item matches array
         * 2) Figure out how many of the "same resource" we need
         * 3) Get the most frequent occurrence of said material
         * 4) If the most frequent occurrence is NOT met, return TaskCatalogue.getItemTask("same resource" item target)
         * 5) If the most frequent occurrence IS met, run CraftInTable with a custom recipe that only has the frequent material.`
         */

        // For each "same" item: How many items can we craft with it?
        // For instance, if we have 7 red wool, we can craft 2 beds
        // sameFullCraftsPermitted[Items.RED_WOOL] = 2;
        int canCraftTotal = 0;
        int majorityCraftCount = 0;
        Item majorityCraftItem = null;
        for (Item sameCheck : sameResourceTarget.getMatches()) {
            int count = getExpectedTotalCountOfSameItem(mod, sameCheck);
            int canCraft = (count / sameResourcePerRecipe) * recipe.outputCount();
            canCraftTotal += canCraft;
            if (canCraft > majorityCraftCount) {
                majorityCraftCount = canCraft;
                majorityCraftItem = sameCheck;
            }
        }

        // If we already have some of our target, we need less "same" materials.
        int currentTargetCount = mod.getInventoryTracker().getItemCount(target);
        int currentTargetsRequired = target.targetCount - currentTargetCount;

        if (canCraftTotal >= currentTargetsRequired) {
            // We have enough of the same resource!!!
            // Handle crafting normally.

            // We may need to convert our raw materials into our "matching" materials.
            int trueCanCraftTotal = 0;
            for (Item sameCheck : sameResourceTarget.getMatches()) {
                int trueCount = mod.getInventoryTracker().getItemCountIncludingTable(false, sameCheck);
                int trueCanCraft = (trueCount / sameResourcePerRecipe) * recipe.outputCount();
                trueCanCraftTotal += trueCanCraft;
            }
            if (trueCanCraftTotal < currentTargetsRequired) {
                return getSpecificSameResourceTask(mod, sameResourceTarget.getMatches());
            }

            CraftingRecipe samedRecipe = generateSamedRecipe(recipe, majorityCraftItem, sameMask);
            int toCraftTotal = majorityCraftCount + currentTargetCount;
            toCraftTotal = Math.min(toCraftTotal, target.targetCount);
            return recipe.isBig()
                   ? new CraftInTableTask(new ItemTarget(target.getMatches(), toCraftTotal), samedRecipe, true, true)
                   : new CraftInInventoryTask(target, samedRecipe, true, true);
        }
        // Collect SAME resources first!!!
        return getAllSameResourcesTask(mod);
    }

    @Override
    protected void onResourceStop(AltoClef mod, Task interruptTask) {

    }

    // Virtual
    protected Task getAllSameResourcesTask(AltoClef mod) {
        if (sameResourceTarget.isCatalogueItem()) {
            ItemTarget infinityVersion = new ItemTarget(sameResourceTarget.getCatalogueName());
            return TaskCatalogue.getItemTask(infinityVersion);
        }
        Debug.logWarning("ItemTarget for same resource is not catalogued: " + sameResourceTarget);
        return null;
    }

    // Virtual
    protected int getExpectedTotalCountOfSameItem(AltoClef mod, Item sameItem) {
        return mod.getInventoryTracker().getItemCountIncludingTable(sameItem);
    }

    // Virtual
    protected Task getSpecificSameResourceTask(AltoClef mod, Item[] toGet) {
        Debug.logError("Uh oh!!! getSpecificSameResourceTask should be implemented!!!! Now we're stuck.");
        return null;
    }
}