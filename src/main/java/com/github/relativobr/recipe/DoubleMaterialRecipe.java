package com.github.relativobr.recipe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

@Data
@AllArgsConstructor
@NoArgsConstructor
public final class DoubleMaterialRecipe {


    private Material material;
    private Material mainItem;
    private Material secondItem;


    public DoubleMaterialRecipe(Material material, Material mainItem) {
        this.material = material;
        this.mainItem = mainItem;
        this.secondItem = mainItem;
    }


    public ItemStack[] getInput(){
        return new ItemStack[]{
                new ItemStack(this.material)
        };
    }


    public ItemStack[] getOutput(){
        return new ItemStack[]{
                new ItemStack(this.mainItem),
                new ItemStack(this.secondItem)
        };
    }


}