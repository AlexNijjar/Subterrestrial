package com.github.alexnijjar.subterrestrial.data;

import org.apache.commons.lang3.Range;

import net.minecraft.util.Identifier;

public record LootData(String chest, Identifier id, Range<Integer> rolls, Range<Integer> count, float chance) {
}