package com.github.relativobr.machine;

import static java.util.Objects.nonNull;

import com.github.relativobr.recipe.SimpleItemRecipe;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.NotHopperable;
import io.github.thebusybiscuit.slimefun4.core.attributes.RecipeDisplayItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AContainer;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.MachineRecipe;
import me.mrCookieSlime.Slimefun.Objects.handlers.BlockTicker;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

public class SimpleItemContainerMachine extends AContainer implements NotHopperable, RecipeDisplayItem {

    private List<SimpleItemRecipe> machineRecipes = new ArrayList<>();
    private static Map<Block, MachineRecipe> processing = new HashMap<>();
    private static Map<Block, Integer> progress = new HashMap<>();
    private int timeProcess = 15;
    private String machineIdentifier = "SimpleItemContainerMachine";

    @ParametersAreNonnullByDefault
    protected SimpleItemContainerMachine(ItemGroup category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
    }

    public SimpleItemContainerMachine setMachineIdentifier(@Nonnull String machineIdentifier){
        this.machineIdentifier = machineIdentifier;
        return this;
    }

    public SimpleItemContainerMachine setMachineRecipes(@Nonnull List<SimpleItemRecipe> machineRecipes){
        this.machineRecipes = machineRecipes;
        return this;
    }

    public SimpleItemContainerMachine setTimeProcess(int timeProcess){
        this.timeProcess = timeProcess;
        return this;
    }

    public int getTimeProcess(){
        return this.timeProcess;
    }

    @Override
    public void registerDefaultRecipes() {
        this.recipes.clear();
        machineRecipes.forEach(recipe -> {
            this.recipes.add(new MachineRecipe(this.timeProcess, recipe.getInput(),recipe.getOutput()));
        });
    }


    @Nonnull
    @Override
    public List<ItemStack> getDisplayRecipes() {
        List<ItemStack> displayRecipes = new ArrayList();
        machineRecipes.forEach(recipe -> {
            displayRecipes.add(recipe.getInput()[0]);
            displayRecipes.add(recipe.getOutput()[0]);
        });
        return displayRecipes;
    }

    @Override
    public void preRegister() {
        this.addItemHandler(new BlockTicker() {
            public void tick(Block b, SlimefunItem sf, Config data) {
                SimpleItemContainerMachine.this.tick(b);
            }

            public boolean isSynchronized() {
                return true;
            }
        });
    }

    @Nonnull
    @Override
    public String getMachineIdentifier() {
        return nonNull(this.machineIdentifier) ? this.machineIdentifier : "MachineIdentifier";
    }

    @Override
    public ItemStack getProgressBar() {
        return new ItemStack(Material.IRON_PICKAXE);
    }

}