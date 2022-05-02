package com.github.relativobr.recipe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bukkit.inventory.ItemStack;

@Data
@AllArgsConstructor
@NoArgsConstructor
public final class DoubleItemRecipe {


    private ItemStack material;
    private ItemStack mainItem;
    private ItemStack secondItem;


    public DoubleItemRecipe(ItemStack material, ItemStack mainItem) {
        this.material = material;
        this.mainItem = mainItem;
        this.secondItem = mainItem;
    }


    public ItemStack[] getInput(){
        return new ItemStack[]{
                this.material
        };
    }


    public ItemStack[] getOutput(){
        return new ItemStack[]{
                this.mainItem,
                this.secondItem
        };
    }


}