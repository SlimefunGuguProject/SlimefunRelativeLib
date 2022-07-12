package com.github.relativobr.util;

import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;
import io.github.thebusybiscuit.slimefun4.utils.tags.SlimefunTag;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nonnull;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Waterlogged;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class UtilCheckBlock {

  public static boolean checkUnderWater(@Nonnull Block b) {
    return b.getRelative(BlockFace.DOWN).getType().equals(Material.WATER);
  }

  public static boolean checkInWater(@Nonnull Block b) {
    BlockData blockData = b.getBlockData();
    if (blockData instanceof Waterlogged) {
      Waterlogged waterLogged = (Waterlogged) blockData;
      return waterLogged.isWaterlogged();
    }
    return false;
  }

  public static boolean checkUnderFire(@Nonnull Block b) {
    return b.getRelative(BlockFace.DOWN).getType().equals(Material.FIRE) || b.getRelative(BlockFace.DOWN).getType()
        .equals(Material.SOUL_FIRE) || b.getRelative(BlockFace.DOWN).getType().equals(Material.LAVA) || b.getRelative(
        BlockFace.DOWN).getType().equals(Material.CAMPFIRE) || b.getRelative(BlockFace.DOWN).getType()
        .equals(Material.SOUL_CAMPFIRE);
  }

  public static boolean checkWind(@Nonnull Block b) {
    final Location location = b.getLocation();
    final World world = location.getWorld();
    if (world != null && world.getEnvironment() == World.Environment.THE_END) {
      return false;
    } else {
      return b.getRelative(BlockFace.NORTH).getType().equals(Material.AIR) || b.getRelative(BlockFace.EAST).getType()
          .equals(Material.AIR) || b.getRelative(BlockFace.SOUTH).getType().equals(Material.AIR) || b.getRelative(
          BlockFace.WEST).getType().equals(Material.AIR);
    }
  }

  public static boolean checkDay(@Nonnull Block b) {
    final Location location = b.getLocation();
    final World world = location.getWorld();
    if (world != null) {
      if (world.getEnvironment() == World.Environment.NETHER) {
        return false;
      } else if (world.getEnvironment() == World.Environment.THE_END) {
        return false;
      } else {
        return !world.hasStorm() && !world.isThundering() && world.getTime() <= 13000;
      }
    }
    return false;
  }

  public static boolean checkNight(@Nonnull Block b) {
    final Location location = b.getLocation();
    final World world = location.getWorld();
    if (world != null) {
      if (world.getEnvironment() == World.Environment.NETHER) {
        return true;
      } else if (world.getEnvironment() == World.Environment.THE_END) {
        return true;
      } else {
        return world.hasStorm() && world.isThundering() && world.getTime() >= 13000;
      }
    }
    return false;
  }

  public static boolean checkDark(@Nonnull Block b) {
    final Location l = b.getLocation();
    final World world = l.getWorld();
    if (world != null) {
      if (world.getEnvironment() == World.Environment.NETHER) {
        return true;
      } else if (world.getEnvironment() == World.Environment.THE_END) {
        return true;
      } else {
        return (l.add(0, 1, 0).getBlock().getLightFromSky() != 15);
      }
    }
    return false;
  }

  public static boolean checkSky(@Nonnull Block b) {
    final Location l = b.getLocation();
    final World world = l.getWorld();
    if (world != null) {
      return (l.add(0, 1, 0).getBlock().getLightFromSky() >= 15);
    }
    return false;
  }

  public static boolean isSlimeChunk(@Nonnull Block b) {
    return b.getChunk().isSlimeChunk();
  }

  public static Optional<Item> getItemInChunk(@Nonnull Block b, @Nonnull ItemStack itemStack) {
    Optional<Item> itemOptional = Optional.empty();
    Optional<Entity> entityOptional = Arrays.stream(b.getChunk().getEntities()).filter(Item.class::isInstance)
        .filter(entity -> SlimefunUtils.isItemSimilar(itemStack, ((Item) entity).getItemStack(), false, false))
        .findFirst();
    if (entityOptional.isPresent()) {
      itemOptional = Optional.of((Item) entityOptional.get());
    }
    return itemOptional;
  }

  public static Optional<Item> getItemInChunkAndRemoveSyncTask(@Nonnull Plugin plugin, @Nonnull Block b,
      @Nonnull ItemStack itemStack) {
    Optional<Item> itemOptional = Optional.empty();
    Optional<Entity> entityOptional = Arrays.stream(b.getChunk().getEntities()).filter(Item.class::isInstance)
        .filter(entity -> SlimefunUtils.isItemSimilar(itemStack, ((Item) entity).getItemStack(), false, false))
        .findFirst();
    if (entityOptional.isPresent()) {
      Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new RemoveEntity(entityOptional.get()));
      itemOptional = Optional.of((Item) entityOptional.get());
    }
    return itemOptional;
  }

  public static Optional<Entity> getLivingEntityInChunk(@Nonnull Block b, @Nonnull Entity entity) {
    return Arrays.stream(b.getChunk().getEntities()).filter(LivingEntity.class::isInstance)
        .filter(x -> x.getEntityId() == entity.getEntityId()).findFirst();
  }

  public static boolean checkLivingEntityInChunk(@Nonnull Block b, @Nonnull Entity entity) {
    return getLivingEntityInChunk(b, entity).isPresent();
  }

  public static boolean checkLivingEntityInChunkAndRemoveSyncTask(@Nonnull Plugin plugin, @Nonnull Block b,
      @Nonnull Entity entity) {
    final Optional<Entity> entityOptional = getLivingEntityInChunk(b, entity);
    entityOptional.ifPresent(value -> Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new RemoveEntity(value)));
    return entityOptional.isPresent();
  }

  private static class RemoveEntity implements Runnable {

    private Entity targetLoc;

    public RemoveEntity(Entity p) {
      targetLoc = p;
    }

    @Override
    public void run() {
      targetLoc.remove();
    }
  }

  public static boolean checkItemInInventory(@Nonnull ItemStack itemStack, @Nonnull Block targetBlockInventory) {
    if (!isInvalidInventory(targetBlockInventory)) {
      BlockState targetState = targetBlockInventory.getState();
      if (targetState instanceof InventoryHolder) {
        Inventory targetInventory = ((InventoryHolder) targetState).getInventory();
        return targetInventory.contains(itemStack, itemStack.getAmount());
      }
    }
    return false;
  }

  public static void removeItemInInventory(@Nonnull ItemStack itemStack, @Nonnull Block targetBlockInventory) {
    if (!isInvalidInventory(targetBlockInventory)) {
      BlockState targetState = targetBlockInventory.getState();
      if (targetState instanceof InventoryHolder) {
        Inventory targetInventory = ((InventoryHolder) targetState).getInventory();
        targetInventory.remove(itemStack);
      }
    }
  }

  public static void pushItemInInventory(@Nonnull ItemStack itemStack, @Nonnull Block targetBlockInventory) {
    if (!isInvalidInventory(targetBlockInventory)) {
      BlockState targetState = targetBlockInventory.getState();
      if (targetState instanceof InventoryHolder) {
        Inventory targetInventory = ((InventoryHolder) targetState).getInventory();
        if (targetInventory.firstEmpty() != -1) {
          targetInventory.addItem(itemStack);
        }
      }
    }
  }

  public static void moveItemInInventory(@Nonnull Block sourceBlock, @Nonnull int[] sourceSlots,
      @Nonnull Block targetBlockInventory) {
    if (!isInvalidInventory(targetBlockInventory)) {
      BlockState targetState = targetBlockInventory.getState();
      if (targetState instanceof InventoryHolder) {
        BlockMenu sourceInventory = BlockStorage.getInventory(sourceBlock);
        Inventory targetInventory = ((InventoryHolder) targetState).getInventory();
        for (int slot : sourceSlots) {
          ItemStack sourceItemInSlot = sourceInventory.getItemInSlot(slot);
          if (sourceItemInSlot != null && targetInventory.firstEmpty() != -1) {
            targetInventory.addItem(sourceItemInSlot);
            sourceInventory.replaceExistingItem(slot, null, false);
          }
        }
      }
    }
  }

  public static void moveItemInInventorySyncTask(@Nonnull Plugin plugin, @Nonnull Block sourceBlock,
      @Nonnull int[] sourceSlots, @Nonnull Block targetBlockInventory) {
    if (!isInvalidInventory(targetBlockInventory)) {
      BlockState targetState = targetBlockInventory.getState();
      if (targetState instanceof InventoryHolder) {
        BlockMenu sourceInventory = BlockStorage.getInventory(sourceBlock);
        if (Arrays.stream(sourceSlots).mapToObj(sourceInventory::getItemInSlot).anyMatch(Objects::nonNull)) {
          Bukkit.getScheduler().scheduleSyncDelayedTask(plugin,
              (Runnable) () -> moveItemInInventory(sourceBlock, sourceSlots, targetBlockInventory), 1);
        }
      }
    }
  }

  public static boolean isInvalidInventory(@Nonnull Block block) {
    Material type = block.getType();
    switch (type) {
      case CHEST:
      case TRAPPED_CHEST:
      case BARREL:
        return false;
      default:
        return !SlimefunTag.SHULKER_BOXES.isTagged(type);
    }
  }
}
