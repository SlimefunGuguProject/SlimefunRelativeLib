package com.github.relativobr.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

@Data
@AllArgsConstructor
@NoArgsConstructor
public final class SimpleMaterialRecipe {


    private Material material;
    private Material mainItem;


    public ItemStack[] getInput(){
        return new ItemStack[]{
                new ItemStack(this.material)
        };
    }


    public ItemStack[] getOutput(){
        return new ItemStack[]{
                new ItemStack(this.mainItem)
        };
    }


}