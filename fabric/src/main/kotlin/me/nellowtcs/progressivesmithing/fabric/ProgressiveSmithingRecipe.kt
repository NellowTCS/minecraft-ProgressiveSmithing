package me.nellowtcs.progressivesmithing.fabric

import net.fabricmc.fabric.api.recipe.v1.SmithingRecipeRegistry
import net.minecraft.item.ItemStack
import net.minecraft.recipe.Ingredient
import net.minecraft.recipe.SmithingRecipe
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.util.Identifier
import net.minecraft.util.collection.DefaultedList
import net.minecraft.util.registry.Registry
import net.minecraft.world.World
import net.minecraft.world.inventory.CraftingInventory
import net.minecraft.recipe.RecipeSerializer
import net.minecraft.item.Item
import net.minecraft.item.Items
import net.minecraft.recipe.RecipeType
import net.minecraft.util.registry.RegistryKey
import net.minecraft.util.registry.RegistryKeys
import net.minecraft.util.registry.Registry
import net.minecraft.util.ResourceLocation
import com.google.gson.JsonObject
import net.minecraft.network.PacketByteBuf

/**
 * A Smithing recipe that simply forwards to the shared {@link me.nellowtcs.progressivesmithing.UpgradeHandler}.
 * The recipe does not object specific logic it just checks that the base item is
 * present in the tier map and the template is any smithing template.
 */
class ProgressiveSmithingRecipe(
    val id: Identifier,
    // A dummy template key – the recipe logic ignores the content
    val template: Identifier = Identifier("minecraft", "smithing_template")
) : SmithingRecipe(id, Ingredient.EMPTY, Ingredient.EMPTY, Ingredient.empty()) {

    override fun craft(inv: CraftingInventory): ItemStack {
        val base = inv.getStack(0)
        val templateStack = inv.getStack(1)
        return me.nellowtcs.progressivesmithing.UpgradeHandler.upgrade(base, templateStack) ?: ItemStack.EMPTY
    }

    override fun matches(inv: CraftingInventory, world: World?): Boolean {
        // Basic sanity ensure only two slots filled with base & template.
        val base = inv.getStack(0)
        val template = inv.getStack(1)
        return base.isNotEmpty && template.isNotEmpty && me.nellowtcs.progressivesmithing.Tiers.tierMap.containsKey(base.item)
    }

    override fun getResultTable(): DefaultedList<ItemStack> = DefaultedList.ofSize(1, ItemStack.EMPTY)

    /** Fabric recipe id */
    override fun getFabricId() = id
}

/**
 * Holds the serializer for the above recipe.
 */
object ProgressiveSmithingRecipeSerializer : RecipeSerializer<ProgressiveSmithingRecipe> {
    override fun read(id: Identifier, json: JsonObject): ProgressiveSmithingRecipe {
        return ProgressiveSmithingRecipe(id)
    }

    override fun read(id: Identifier, buf: PacketByteBuf): ProgressiveSmithingRecipe {
        return ProgressiveSmithingRecipe(id)
    }

    override fun write(buf: PacketByteBuf, recipe: ProgressiveSmithingRecipe) {}
}

/**
 * Registration hook, call from ProgressiveSmithingFabric.onInitialize().
 */
fun registerProgressiveSmithingRecipe() {
    val id = Identifier("progressive_smithing", "progressive_smithing")
    SmithingRecipeRegistry.register(id, ProgressiveSmithingRecipeSerializer)
}
