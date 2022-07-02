package com.github.relativobr.recipe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bukkit.inventory.ItemStack;

/**
 * Deprecated, use only AbstractItemRecipe
 */
@Deprecated
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public final class SimpleRecipe {

  private ItemStack item;
  private ItemStack[] recipe;

}