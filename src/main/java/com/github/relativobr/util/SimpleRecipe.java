package com.github.relativobr.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bukkit.inventory.ItemStack;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public final class SimpleRecipe {

  private ItemStack item;
  private ItemStack[] recipe;

}