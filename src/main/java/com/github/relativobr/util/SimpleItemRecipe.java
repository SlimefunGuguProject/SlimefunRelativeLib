package com.github.relativobr.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bukkit.inventory.ItemStack;

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