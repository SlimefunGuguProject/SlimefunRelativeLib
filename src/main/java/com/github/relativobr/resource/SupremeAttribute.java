package com.github.relativobr.resource;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import org.bukkit.enchantments.Enchantment;

public class SupremeAttribute {

  public static final SlimefunItemStack ATTRIBUTE_MAGIC = new SlimefunItemStack("ATTRIBUTE_MAGIC",
      "16d1c19b0dabdf7360fbd18df9dfd1c615da2f8d2c84fc4216565d9c5dd", "&aAttribute Magic", "",
      "&7A super magic attribute with special effects");

  public static final SlimefunItemStack ATTRIBUTE_BOMB = new SlimefunItemStack("ATTRIBUTE_BOMB",
      "44253275e1b7757130a2d637d07f522fcc6686dc804346f0e71668d5ce6d5891", "&aAttribute Bomb", "",
      "&7A super bomb attribute with special effects");

  public static final SlimefunItemStack ATTRIBUTE_FORTUNE = new SlimefunItemStack(
      "ATTRIBUTE_FORTUNE",
      "81251d814bdea8fc4881aeb6e7d1f48a2edf9cdba9ab4e3fa7f7359c5b92", "&aAttribute Fortune", "",
      "&7A super fortune attribute with special effects");

  public static final SlimefunItemStack ATTRIBUTE_IMPETUS = new SlimefunItemStack(
      "ATTRIBUTE_IMPETUS",
      "f2d27936be90709046d9b4eec4e2a67d6ed583e4cf94f53c0569431357423", "&aAttribute Impetus", "",
      "&7A super impetus attribute with special effects");

  public static SlimefunItemStack getMagic() {
    final SlimefunItemStack attributeMagic = SupremeAttribute.ATTRIBUTE_MAGIC;
    attributeMagic.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 20);
    attributeMagic.addUnsafeEnchantment(Enchantment.DURABILITY, 20);
    attributeMagic.addUnsafeEnchantment(Enchantment.MENDING, 10);
    return attributeMagic;
  }

  public static SlimefunItemStack getBomb() {
    final SlimefunItemStack attributeBomb = SupremeAttribute.ATTRIBUTE_BOMB;
    attributeBomb.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 20);
    attributeBomb.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 20);
    attributeBomb.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 20);
    attributeBomb.addUnsafeEnchantment(Enchantment.THORNS, 10);
    return attributeBomb;
  }

  public static SlimefunItemStack getFortune() {
    final SlimefunItemStack attributeFortune = SupremeAttribute.ATTRIBUTE_FORTUNE;
    attributeFortune.addUnsafeEnchantment(Enchantment.DIG_SPEED, 20);
    attributeFortune.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 10);
    return attributeFortune;
  }

  public static SlimefunItemStack getImpetus() {
    final SlimefunItemStack attributeImpetus = SupremeAttribute.ATTRIBUTE_IMPETUS;
    attributeImpetus.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 20);
    attributeImpetus.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 10);
    attributeImpetus.addUnsafeEnchantment(Enchantment.LOOT_BONUS_MOBS, 10);
    return attributeImpetus;
  }

}
