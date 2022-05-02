package com.github.relativobr.recipe;

import lombok.Getter;

@Getter
public final class InventoryRecipe {


  //CRAFT INPUT SIZE 1
  public static final int[] ALL_INV = {
      0, 1, 2, 3, 4, 5, 6, 7, 8,
      9, 10, 11, 12, 13, 14, 15, 16, 17,
      18, 19, 20, 21, 22, 23, 24, 25, 26,
      27, 28, 29, 30, 31, 32, 33, 34, 35,
      36, 37, 38, 39, 40, 41, 42, 43, 44,
      45, 46, 47, 48, 49, 50, 51, 52
  };
  public static final int[] NO_INV = {53};

  //template chest
  //0,   1,  2,  3,  4,  5,  6,  7,  8
  //9,  10, 11, 12, 13, 14, 15, 16, 17
  //18, 19, 20, 21, 22, 23, 24, 25, 26
  //27, 28, 29, 30, 31, 32, 33, 34, 35
  //36, 37, 38, 39, 40, 41, 42, 43, 44
  //45, 46, 47, 48, 49, 50, 51, 52, 53


  //CRAFT INPUT SIZE 1
  public static final int[] SIMPLE_BORDER = {
      0, 1, 2, 3, 4, 5, 6, 7, 8,
      12, 13, 14,
      22, 23,
      30, 31, 32,
      36, 37, 38, 39, 40, 41, 42, 43, 44,
      45, 46, 47, 48, 49, 50, 51, 52, 53
  };
  public static final int SIMPLE_STATUS_SLOT = 21;
  public static final int[] SIMPLE_INPUT = {19};
  public static final int[] SIMPLE_INPUT_BORDER = {
      9, 10, 11,
      18, 20,
      27, 28, 29
  };
  public static final int[] SIMPLE_OUTPUT = {25};
  public static final int[] SIMPLE_OUTPUT_BORDER = {
      15, 16, 17,
      24, 26,
      33, 34, 35
  };


  //CRAFT INPUT SIZE 2
  public static final int[] DOUBLE_BORDER = {
      0, 1, 2, 3, 4, 5, 6, 7, 8,
      13, 14,
      23,
      31, 32,
      36, 37, 38, 39, 40, 41, 42, 43, 44,
      45, 46, 47, 48, 49, 50, 51, 52, 53
  };
  public static final int DOUBLE_STATUS_SLOT = 22;
  public static final int[] DOUBLE_INPUT = {19, 20};
  public static final int[] DOUBLE_INPUT_BORDER = {
      9, 10, 11, 12,
      18, 21,
      27, 28, 29, 30
  };
  public static final int[] DOUBLE_OUTPUT = {25};
  public static final int[] DOUBLE_OUTPUT_BORDER = {
      15, 16, 17,
      24, 26,
      33, 34, 35
  };


  //CRAFT INPUT SIZE 3
  public static final int[] TRIPLE_BORDER = {
      0, 1, 2, 3, 4, 5, 6, 7, 8,
      14,
      32,
      36, 37, 38, 39, 40, 41, 42, 43, 44,
      45, 46, 47, 48, 49, 50, 51, 52, 53
  };
  public static final int TRIPLE_STATUS_SLOT = 23;
  public static final int[] TRIPLE_INPUT = {19, 20, 21};
  public static final int[] TRIPLE_INPUT_BORDER = {
      9, 10, 11, 12, 13,
      18, 22,
      27, 28, 29, 30, 31
  };
  public static final int[] TRIPLE_OUTPUT = {25};
  public static final int[] TRIPLE_OUTPUT_BORDER = {
      15, 16, 17,
      24, 26,
      33, 34, 35
  };


  //CRAFT INPUT SIZE 9 (3X3)
  public static final int[] MEDIUM_BORDER = {
      5, 6, 7, 8,
      14,
      32,
      41, 42, 43, 44
  };
  public static final int MEDIUM_STATUS_SLOT = 23;
  public static final int[] MEDIUM_INPUT = {
      10, 11, 12,
      19, 20, 21,
      28, 29, 30
  };
  public static final int[] MEDIUM_INPUT_BORDER = {
      0, 1, 2, 3, 4,
      9, 13,
      18, 22,
      27, 31,
      36, 37, 38, 39, 40
  };
  public static final int[] MEDIUM_OUTPUT = {25};
  public static final int[] MEDIUM_OUTPUT_BORDER = {
      15, 16, 17,
      24, 26,
      33, 34, 35
  };


  //CRAFT INPUT SIZE 36 (6x6)
  public static final int[] LARGE_BORDER = {
      6, 7, 8,
      16, 17,
      24, 25, 26
  };
  public static final int LARGE_STATUS_SLOT = 15;
  public static final int[] LARGE_INPUT = {
      0, 1, 2, 3, 4, 5,
      9, 10, 11, 12, 13, 14,
      18, 19, 20, 21, 22, 23,
      27, 28, 29, 30, 31, 32,
      36, 37, 38, 39, 40, 41,
      45, 46, 47, 48, 49, 50
  };
  public static final int[] LARGE_INPUT_BORDER = {};
  public static final int[] LARGE_OUTPUT = {43};
  public static final int[] LARGE_OUTPUT_BORDER = {
      33, 34, 35,
      42, 44,
      51, 52, 53
  };

  //CRAFT QUARRY MACHINE
  public static final int[] QUARRY_BORDER = {
      0, 1, 2, 3, 4, 5, 6,
      9, 10,
      18, 19,
      27, 28,
      36, 37, 38, 39, 40, 41, 42,
  };
  public static final int QUARRY_STATUS = 23;
  public static final int QUARRY_BUTTON = 21;
  public static final int[] QUARRY_INPUT_BORDER = {
      11, 12, 13, 14, 15,
      20, 22, 24,
      29, 30, 31, 32, 33,
  };
  public static final int[] QUARRY_OUTPUT = {
      17,
      26,
      35,
  };
  public static final int[] QUARRY_OUTPUT_BORDER = {
      7, 8,
      16,
      25,
      34,
      43, 44,
  };

}
