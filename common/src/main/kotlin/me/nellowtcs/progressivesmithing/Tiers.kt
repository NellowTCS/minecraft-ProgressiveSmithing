package me.nellowtcs.progressivesmithing

import me.nellowtcs.progressivesmithing.registry.ModItems
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.Item

/**
 * A simple linear tier map for the Smithing Table upgrades.
 */
object Tiers {
    data class UpgradeStep(
        val base: ResourceLocation,
        val template: Item,
        val result: ResourceLocation,
    )

    /**
     * Maps a base armor item to the next tier’s armor item.
     * Items are resolved lazily from the registry.
     */
    val tierMap: Map<Item, Item> by lazy {
        upgradeSteps.associate { step ->
            BuiltInRegistries.ITEM.getValue(step.base) to BuiltInRegistries.ITEM.getValue(step.result)
        }
    }

    val templateMap: Map<Item, Item> by lazy {
        upgradeSteps.associate { step ->
            BuiltInRegistries.ITEM.getValue(step.base) to step.template
        }
    }

    private val upgradeSteps: List<UpgradeStep> = listOf(
        // Leather -> Copper
        UpgradeStep(ResourceLocation.fromNamespaceAndPath("minecraft", "leather_helmet"), ModItems.COPPER_UPGRADE.get(), ResourceLocation.fromNamespaceAndPath("minecraft", "copper_helmet")),
        UpgradeStep(ResourceLocation.fromNamespaceAndPath("minecraft", "leather_chestplate"), ModItems.COPPER_UPGRADE.get(), ResourceLocation.fromNamespaceAndPath("minecraft", "copper_chestplate")),
        UpgradeStep(ResourceLocation.fromNamespaceAndPath("minecraft", "leather_leggings"), ModItems.COPPER_UPGRADE.get(), ResourceLocation.fromNamespaceAndPath("minecraft", "copper_leggings")),
        UpgradeStep(ResourceLocation.fromNamespaceAndPath("minecraft", "leather_boots"), ModItems.COPPER_UPGRADE.get(), ResourceLocation.fromNamespaceAndPath("minecraft", "copper_boots")),

        // Copper -> Gold
        UpgradeStep(ResourceLocation.fromNamespaceAndPath("minecraft", "copper_helmet"), ModItems.GOLD_UPGRADE.get(), ResourceLocation.fromNamespaceAndPath("minecraft", "gold_helmet")),
        UpgradeStep(ResourceLocation.fromNamespaceAndPath("minecraft", "copper_chestplate"), ModItems.GOLD_UPGRADE.get(), ResourceLocation.fromNamespaceAndPath("minecraft", "gold_chestplate")),
        UpgradeStep(ResourceLocation.fromNamespaceAndPath("minecraft", "copper_leggings"), ModItems.GOLD_UPGRADE.get(), ResourceLocation.fromNamespaceAndPath("minecraft", "gold_leggings")),
        UpgradeStep(ResourceLocation.fromNamespaceAndPath("minecraft", "copper_boots"), ModItems.GOLD_UPGRADE.get(), ResourceLocation.fromNamespaceAndPath("minecraft", "gold_boots")),

        // Gold -> Chain
        UpgradeStep(ResourceLocation.fromNamespaceAndPath("minecraft", "gold_helmet"), ModItems.CHAIN_UPGRADE.get(), ResourceLocation.fromNamespaceAndPath("minecraft", "chainmail_helmet")),
        UpgradeStep(ResourceLocation.fromNamespaceAndPath("minecraft", "gold_chestplate"), ModItems.CHAIN_UPGRADE.get(), ResourceLocation.fromNamespaceAndPath("minecraft", "chainmail_chestplate")),
        UpgradeStep(ResourceLocation.fromNamespaceAndPath("minecraft", "gold_leggings"), ModItems.CHAIN_UPGRADE.get(), ResourceLocation.fromNamespaceAndPath("minecraft", "chainmail_leggings")),
        UpgradeStep(ResourceLocation.fromNamespaceAndPath("minecraft", "gold_boots"), ModItems.CHAIN_UPGRADE.get(), ResourceLocation.fromNamespaceAndPath("minecraft", "chainmail_boots")),

        // Chain -> Iron
        UpgradeStep(ResourceLocation.fromNamespaceAndPath("minecraft", "chainmail_helmet"), ModItems.IRON_UPGRADE.get(), ResourceLocation.fromNamespaceAndPath("minecraft", "iron_helmet")),
        UpgradeStep(ResourceLocation.fromNamespaceAndPath("minecraft", "chainmail_chestplate"), ModItems.IRON_UPGRADE.get(), ResourceLocation.fromNamespaceAndPath("minecraft", "iron_chestplate")),
        UpgradeStep(ResourceLocation.fromNamespaceAndPath("minecraft", "chainmail_leggings"), ModItems.IRON_UPGRADE.get(), ResourceLocation.fromNamespaceAndPath("minecraft", "iron_leggings")),
        UpgradeStep(ResourceLocation.fromNamespaceAndPath("minecraft", "chainmail_boots"), ModItems.IRON_UPGRADE.get(), ResourceLocation.fromNamespaceAndPath("minecraft", "iron_boots")),

        // Iron -> Diamond
        UpgradeStep(ResourceLocation.fromNamespaceAndPath("minecraft", "iron_helmet"), ModItems.DIAMOND_UPGRADE.get(), ResourceLocation.fromNamespaceAndPath("minecraft", "diamond_helmet")),
        UpgradeStep(ResourceLocation.fromNamespaceAndPath("minecraft", "iron_chestplate"), ModItems.DIAMOND_UPGRADE.get(), ResourceLocation.fromNamespaceAndPath("minecraft", "diamond_chestplate")),
        UpgradeStep(ResourceLocation.fromNamespaceAndPath("minecraft", "iron_leggings"), ModItems.DIAMOND_UPGRADE.get(), ResourceLocation.fromNamespaceAndPath("minecraft", "diamond_leggings")),
        UpgradeStep(ResourceLocation.fromNamespaceAndPath("minecraft", "iron_boots"), ModItems.DIAMOND_UPGRADE.get(), ResourceLocation.fromNamespaceAndPath("minecraft", "diamond_boots"))
    )
}
