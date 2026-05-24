package me.nellowtcs.progressivesmithing.neoforge

import net.minecraft.item.ItemStack
import net.minecraft.item.crafting.SmithingRecipe
import net.minecraft.item.crafting.Ingredient
import net.minecraft.world.item.crafting.RecipeSerializer
import net.minecraft.util.Identifier
import com.google.gson.JsonObject
import net.minecraft.network.PacketByteBuf

/**
 * Minimal Smithing recipe that forwards to the shared UpgradeHandler.
 * The recipe ignores the content of the template only ensuring that
 * the base item exists in our tier map.
 */
class ProgressiveSmithingRecipe(id: Identifier, base: Ingredient, template: Ingredient) : SmithingRecipe(id, base, template) {

    override fun craft(input: net.minecraft.world.inventory.CraftingInventory): ItemStack {
        val base = input.getStack(0)
        val tmpl = input.getStack(1)
        return me.nellowtcs.progressivesmithing.UpgradeHandler.upgrade(base, tmpl) ?: ItemStack.EMPTY
    }
}

object ProgressiveSmithingRecipeSerializer : RecipeSerializer<ProgressiveSmithingRecipe> {
    override fun read(id: Identifier, json: JsonObject): ProgressiveSmithingRecipe {
        val base = Ingredient.fromJson(json.get("base"))
        val template = Ingredient.fromJson(json.get("template"))
        return ProgressiveSmithingRecipe(id, base, template)
    }

    override fun read(id: Identifier, buf: PacketByteBuf): ProgressiveSmithingRecipe {
        return ProgressiveSmithingRecipe(id, Ingredient.fromPacket(buf), Ingredient.fromPacket(buf))
    }

    override fun write(buf: PacketByteBuf, recipe: ProgressiveSmithingRecipe) {}
}
