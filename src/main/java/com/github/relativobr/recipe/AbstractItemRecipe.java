package com.github.relativobr.recipe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AbstractItemRecipe {

  private ItemStack[] input;
  private ItemStack[] output;

  public ItemStack getItemInput(int index) {
    return input[index];
  }

  public ItemStack getItemOutput(int index) {
    return input[index];
  }

  public Material getMaterialInput(int index) {
    return getItemInput(index) != null ? getItemInput(index).getType() : null;
  }

  public Material getMaterialOutput(int index) {
    return getItemOutput(index) != null ? getItemOutput(index).getType() : null;
  }

  public ItemStack getFirstItemInput() {
    return getItemInput(0);
  }

  public ItemStack getFirstItemOutput() {
    return getItemOutput(0);
  }

  public ItemStack getSecondItemInput() {
    return getItemInput(1);
  }

  public ItemStack getSecondItemOutput() {
    return getItemOutput(1);
  }

  public Material getFirstMaterialInput() {
    return getMaterialInput(0);
  }

  public Material getFirstMaterialOutput() {
    return getMaterialOutput(0);
  }

  public Material getSecondMaterialInput() {
    return getMaterialInput(1);
  }

  public Material getSecondMaterialOutput() {
    return getMaterialOutput(1);
  }

  public AbstractItemRecipe(ItemStack input, ItemStack output) {
    this.input = new ItemStack[]{input};
    this.output = new ItemStack[]{output};
  }

  public AbstractItemRecipe(ItemStack[] input, ItemStack output) {
    this.input = input;
    this.output = new ItemStack[]{output};
  }

  public AbstractItemRecipe(ItemStack input, ItemStack[] output) {
    this.input = new ItemStack[]{input};
    this.output = output;
  }

  public AbstractItemRecipe(Material input, Material output) {
    this.input = new ItemStack[]{new ItemStack(input)};
    this.output = new ItemStack[]{new ItemStack(output)};
  }

  public AbstractItemRecipe(ItemStack[] input, Material output) {
    this.input = input;
    this.output = new ItemStack[]{new ItemStack(output)};
  }

  public AbstractItemRecipe(Material input, ItemStack[] output) {
    this.input = new ItemStack[]{new ItemStack(input)};
    this.output = output;
  }

  public AbstractItemRecipe(ItemStack input, Material output) {
    this.input = new ItemStack[]{input};
    this.output = new ItemStack[]{new ItemStack(output)};
  }

  public AbstractItemRecipe(Material input, ItemStack output) {
    this.input = new ItemStack[]{new ItemStack(input)};
    this.output = new ItemStack[]{output};
  }

  public AbstractItemRecipe(ItemStack input1, ItemStack input2, ItemStack output1, ItemStack output2) {
    this.input = new ItemStack[]{input1, input2};
    this.output = new ItemStack[]{output1, output2};
  }

  public AbstractItemRecipe(Material input1, Material input2, Material output1, Material output2) {
    this.input = new ItemStack[]{new ItemStack(input1), new ItemStack(input2)};
    this.output = new ItemStack[]{new ItemStack(output1), new ItemStack(output2)};
  }

  public AbstractItemRecipe(ItemStack input1, ItemStack input2, Material output1, Material output2) {
    this.input = new ItemStack[]{input1, input2};
    this.output = new ItemStack[]{new ItemStack(output1), new ItemStack(output2)};
  }

  public AbstractItemRecipe(Material input1, Material input2, ItemStack output1, ItemStack output2) {
    this.input = new ItemStack[]{new ItemStack(input1), new ItemStack(input2)};
    this.output = new ItemStack[]{output1, output2};
  }

}
