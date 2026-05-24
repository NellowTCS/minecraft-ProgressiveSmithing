package me.nellowtcs.progressivesmithing

import net.minecraft.item.ItemStack

/**
 * Handles armor upgrades via the Smithing Table
 */
object UpgradeHandler {
    /**
     * Attempts to upgrade [item] using the recipe template [template].
     * Returns a new {@link ItemStack} of the next tier, or {@code null} if no mapping exists.
     */
    fun upgrade(item: ItemStack, template: ItemStack): ItemStack? {
        val nextItem = Tiers.tierMap[item.item] ?: return null
        val result = ItemStack(nextItem)
        copyTagData(item, result)
        return result
    }

    private fun copyTagData(src: ItemStack, dst: ItemStack) {
        // Preserve enchantments, name, lore, trim, durability, etc.
        dst.tag = src.tag?.copy()
        dst.damage = src.damage
    }
}
