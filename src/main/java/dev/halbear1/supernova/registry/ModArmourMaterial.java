package dev.halbear1.supernova.registry;

import dev.halbear1.supernova.SuperNova;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public enum ModArmourMaterial implements IArmorMaterial {
    ;
    private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final float knockbackResistance;
    private final LazyValue<Ingredient> repairMaterial;

    private ModArmourMaterial(String name, int maxDmg, int[] maxDmgReductArr, int enchantability, SoundEvent soundEvent, float toughness, float KnbckResistance, Supplier repairMat) {
        this.name = name;
        this.maxDamageFactor = maxDmg;
        this.damageReductionAmountArray = maxDmgReductArr;
        this.enchantability = enchantability;
        this.soundEvent = soundEvent;
        this.toughness = toughness;
        this.knockbackResistance = KnbckResistance;
        this.repairMaterial = new LazyValue(repairMat);
    }

    public int getDurability(EquipmentSlotType equipSlotType) {
        return MAX_DAMAGE_ARRAY[equipSlotType.getIndex()] * this.maxDamageFactor;
    }

    public int getDamageReductionAmount(EquipmentSlotType equipSlotType) {
        return this.damageReductionAmountArray[equipSlotType.getIndex()];
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public SoundEvent getSoundEvent() {
        return this.soundEvent;
    }

    public Ingredient getRepairMaterial() {
        return (Ingredient)this.repairMaterial.getValue();
    }

    @OnlyIn(Dist.CLIENT)
    public String getName() {
        return SuperNova.MOD_ID + ":" + this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
