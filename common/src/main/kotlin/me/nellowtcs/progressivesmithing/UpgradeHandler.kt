package me.nellowtcs.progressivesmithing

import net.minecraft.world.item.ItemStack

/**
 * Handles armor upgrades via the Smithing Table
 */
object UpgradeHandler {
    fun canUpgrade(item: ItemStack, template: ItemStack): Boolean {
        val expectedTemplate = Tiers.templateMap[item.item] ?: return false
        return template.item == expectedTemplate
    }

    /**
     * Attempts to upgrade [item] using the recipe template [template].
     * Returns a new {@link ItemStack} of the next tier, or {@code null} if no mapping exists.
     */
    fun upgrade(item: ItemStack, template: ItemStack): ItemStack? {
        if (!canUpgrade(item, template)) return null

        val nextItem = Tiers.tierMap[item.item] ?: return null
        return item.transmuteCopy(nextItem)
    }
}
