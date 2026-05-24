package me.nellowtcs.progressivesmithing

import me.nellowtcs.progressivesmithing.registry.ModItems
import net.minecraft.item.Item
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier

/**
 * A simple linear tier map for the Smithing Table upgrades.
 */
object Tiers {
    data class UpgradeStep(
        val base: Identifier,
        val template: Item,
        val result: Identifier,
    )

    /**
     * Maps a base armor item to the next tier’s armor item.
     * Items are resolved lazily from the registry.
     */
    val tierMap: Map<Item, Item> by lazy {
        val registry = Registry.ITEM
        upgradeSteps.associate { step ->
            registry.get(step.base)!! to registry.get(step.result)!!
        }
    }

    val templateMap: Map<Item, Item> by lazy {
        val registry = Registry.ITEM
        upgradeSteps.associate { step ->
            registry.get(step.base)!! to step.template
        }
    }

    private val upgradeSteps: List<UpgradeStep> = listOf(
        // Leather -> Copper
        UpgradeStep(Identifier("minecraft", "leather_helmet"), ModItems.COPPER_UPGRADE.get(), Identifier("minecraft", "copper_helmet")),
        UpgradeStep(Identifier("minecraft", "leather_chestplate"), ModItems.COPPER_UPGRADE.get(), Identifier("minecraft", "copper_chestplate")),
        UpgradeStep(Identifier("minecraft", "leather_leggings"), ModItems.COPPER_UPGRADE.get(), Identifier("minecraft", "copper_leggings")),
        UpgradeStep(Identifier("minecraft", "leather_boots"), ModItems.COPPER_UPGRADE.get(), Identifier("minecraft", "copper_boots")),

        // Copper -> Gold
        UpgradeStep(Identifier("minecraft", "copper_helmet"), ModItems.GOLD_UPGRADE.get(), Identifier("minecraft", "gold_helmet")),
        UpgradeStep(Identifier("minecraft", "copper_chestplate"), ModItems.GOLD_UPGRADE.get(), Identifier("minecraft", "gold_chestplate")),
        UpgradeStep(Identifier("minecraft", "copper_leggings"), ModItems.GOLD_UPGRADE.get(), Identifier("minecraft", "gold_leggings")),
        UpgradeStep(Identifier("minecraft", "copper_boots"), ModItems.GOLD_UPGRADE.get(), Identifier("minecraft", "gold_boots")),

        // Gold -> Chain
        UpgradeStep(Identifier("minecraft", "gold_helmet"), ModItems.CHAIN_UPGRADE.get(), Identifier("minecraft", "chainmail_helmet")),
        UpgradeStep(Identifier("minecraft", "gold_chestplate"), ModItems.CHAIN_UPGRADE.get(), Identifier("minecraft", "chainmail_chestplate")),
        UpgradeStep(Identifier("minecraft", "gold_leggings"), ModItems.CHAIN_UPGRADE.get(), Identifier("minecraft", "chainmail_leggings")),
        UpgradeStep(Identifier("minecraft", "gold_boots"), ModItems.CHAIN_UPGRADE.get(), Identifier("minecraft", "chainmail_boots")),

        // Chain -> Iron
        UpgradeStep(Identifier("minecraft", "chainmail_helmet"), ModItems.IRON_UPGRADE.get(), Identifier("minecraft", "iron_helmet")),
        UpgradeStep(Identifier("minecraft", "chainmail_chestplate"), ModItems.IRON_UPGRADE.get(), Identifier("minecraft", "iron_chestplate")),
        UpgradeStep(Identifier("minecraft", "chainmail_leggings"), ModItems.IRON_UPGRADE.get(), Identifier("minecraft", "iron_leggings")),
        UpgradeStep(Identifier("minecraft", "chainmail_boots"), ModItems.IRON_UPGRADE.get(), Identifier("minecraft", "iron_boots")),

        // Iron -> Diamond
        UpgradeStep(Identifier("minecraft", "iron_helmet"), ModItems.DIAMOND_UPGRADE.get(), Identifier("minecraft", "diamond_helmet")),
        UpgradeStep(Identifier("minecraft", "iron_chestplate"), ModItems.DIAMOND_UPGRADE.get(), Identifier("minecraft", "diamond_chestplate")),
        UpgradeStep(Identifier("minecraft", "iron_leggings"), ModItems.DIAMOND_UPGRADE.get(), Identifier("minecraft", "diamond_leggings")),
        UpgradeStep(Identifier("minecraft", "iron_boots"), ModItems.DIAMOND_UPGRADE.get(), Identifier("minecraft", "diamond_boots"))
    )
}
