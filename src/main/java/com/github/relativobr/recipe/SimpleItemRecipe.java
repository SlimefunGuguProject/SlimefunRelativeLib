package com.github.relativobr.recipe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bukkit.inventory.ItemStack;

/**
 * Deprecated, use only AbstractItemRecipe
 */
@Deprecated
@Data
@AllArgsConstructor
@NoArgsConstructor
public final class SimpleItemRecipe {


    private ItemStack material;
    private ItemStack mainItem;


    public ItemStack[] getInput(){
        return new ItemStack[]{
                this.material
        };
    }


    public ItemStack[] getOutput(){
        return new ItemStack[]{
                this.mainItem
        };
    }


}