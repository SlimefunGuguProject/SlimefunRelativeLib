package com.github.relativobr.util;

import io.github.thebusybiscuit.slimefun4.api.events.BlockPlacerPlaceEvent;
import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.NotPlaceable;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockPlaceHandler;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockUseHandler;
import javax.annotation.Nonnull;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

public final class ItemNotPlaceable extends SlimefunItem implements NotPlaceable {

  public ItemNotPlaceable(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType,
      ItemStack[] recipe) {
    super(itemGroup, item, recipeType, recipe);
    addItemHandler(onPlace(), onRightClick());
  }

  @Nonnull
  private BlockPlaceHandler onPlace() {
    return new BlockPlaceHandler(false) {
      @Override
      public void onPlayerPlace(BlockPlaceEvent e) {
        e.setBuild(false);
        e.setCancelled(true);
      }
      @Override
      public void onBlockPlacerPlace(BlockPlacerPlaceEvent e) {
        e.setCancelled(true);
      }
    };
  }

  @Nonnull
  public BlockUseHandler onRightClick() {
    return PlayerRightClickEvent::cancel;
  }
}