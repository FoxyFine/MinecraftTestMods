package com.foxyfine.my_test_mod.items;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public enum SwordExcaliburSpecification implements IItemTier
{
    MAGIC_TIER(1000, 7.2F, 7.2F, 2, 5, Ingredient.of(new ItemStack(Items.ENCHANTED_BOOK, 5)));
    private final int getUses;
    private final float getSpeed;
    private final float getAttackDamageBonus;
    private final int getLevel;
    private final int getEnchantmentValue;
    private final Ingredient getRepairIngredient;
    SwordExcaliburSpecification(int getUses, float getSpeed, float getAttackDamageBonus, int getLevel, int getEnchantmentValue, Ingredient getRepairIngredient) {
        this.getUses = getUses;
        this.getSpeed = getSpeed;
        this.getAttackDamageBonus = getAttackDamageBonus;
        this.getLevel = getLevel;
        this.getEnchantmentValue = getEnchantmentValue;
        this.getRepairIngredient = getRepairIngredient;
    }

    @Override
    public int getUses() {
        return getUses;
    }

    @Override
    public float getSpeed() {
        return getSpeed;
    }

    @Override
    public float getAttackDamageBonus() {
        return getAttackDamageBonus;
    }

    @Override
    public int getLevel() {
        return getLevel;
    }

    @Override
    public int getEnchantmentValue() {
        return getEnchantmentValue;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return getRepairIngredient;
    }
}
