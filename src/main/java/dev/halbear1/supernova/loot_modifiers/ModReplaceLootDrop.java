package dev.halbear1.supernova.loot_modifiers;
import com.google.gson.JsonObject;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;
import java.util.List;

public class ModReplaceLootDrop extends LootModifier {
    private final Item addition;
    protected ModReplaceLootDrop(ILootCondition[] conditionsIn, Item addition) {
        super(conditionsIn);
        this.addition = addition;
    }

    @Nonnull
    @Override
    protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext lootContext) {
        generatedLoot.clear(); // clears the drop that was going to drop
        generatedLoot.add(new ItemStack(addition)); // adds new drop to the drop
        return generatedLoot;
    }

    public static class Serializer extends GlobalLootModifierSerializer<ModReplaceLootDrop>{
        @Override
        public ModReplaceLootDrop read(ResourceLocation name, JsonObject object, ILootCondition[] conditionsIn) {
            Item addition = ForgeRegistries.ITEMS.getValue(
                    new ResourceLocation(JSONUtils.getString(object, "addition")));
            return new ModReplaceLootDrop(conditionsIn, addition);
        }

        @Override
        public JsonObject write(ModReplaceLootDrop instance) {
            JsonObject json = makeConditions(instance.conditions);
            json.addProperty("addition", ForgeRegistries.ITEMS.getKey(instance.addition).toString());
            return json;
        }
    }
}
