package me.nellowtcs.progressivesmithing

import net.minecraft.item.Item
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier

/**
 * A simple linear tier map for the Smithing Table upgrades.
 */
object Tiers {
    /**
     * Maps a base armor item to the next tier’s armor item.
     * Items are resolved lazily from the registry.
     */
    val tierMap: Map<Item, Item> by lazy {
        val registry = Registry.ITEM
        listOf(
            // Leather -> Copper
            Pair(Identifier("minecraft", "leather_helmet"), Identifier("minecraft", "copper_helmet")),
            Pair(Identifier("minecraft", "leather_chestplate"), Identifier("minecraft", "copper_chestplate")),
            Pair(Identifier("minecraft", "leather_leggings"), Identifier("minecraft", "copper_leggings")),
            Pair(Identifier("minecraft", "leather_boots"), Identifier("minecraft", "copper_boots")),

            // Copper -> Gold
            Pair(Identifier("minecraft", "copper_helmet"), Identifier("minecraft", "gold_helmet")),
            Pair(Identifier("minecraft", "copper_chestplate"), Identifier("minecraft", "gold_chestplate")),
            Pair(Identifier("minecraft", "copper_leggings"), Identifier("minecraft", "gold_leggings")),
            Pair(Identifier("minecraft", "copper_boots"), Identifier("minecraft", "gold_boots")),

            // Gold -> Chain
            Pair(Identifier("minecraft", "gold_helmet"), Identifier("minecraft", "chainmail_helmet")),
            Pair(Identifier("minecraft", "gold_chestplate"), Identifier("minecraft", "chainmail_chestplate")),
            Pair(Identifier("minecraft", "gold_leggings"), Identifier("minecraft", "chainmail_leggings")),
            Pair(Identifier("minecraft", "gold_boots"), Identifier("minecraft", "chainmail_boots")),

            // Chain -> Iron
            Pair(Identifier("minecraft", "chainmail_helmet"), Identifier("minecraft", "iron_helmet")),
            Pair(Identifier("minecraft", "chainmail_chestplate"), Identifier("minecraft", "iron_chestplate")),
            Pair(Identifier("minecraft", "chainmail_leggings"), Identifier("minecraft", "iron_leggings")),
            Pair(Identifier("minecraft", "chainmail_boots"), Identifier("minecraft", "iron_boots")),

            // Iron -> Diamond
            Pair(Identifier("minecraft", "iron_helmet"), Identifier("minecraft", "diamond_helmet")),
            Pair(Identifier("minecraft", "iron_chestplate"), Identifier("minecraft", "diamond_chestplate")),
            Pair(Identifier("minecraft", "iron_leggings"), Identifier("minecraft", "diamond_leggings")),
            Pair(Identifier("minecraft", "iron_boots"), Identifier("minecraft", "diamond_boots")),

            // Diamond -> Netherite
            Pair(Identifier("minecraft", "diamond_helmet"), Identifier("minecraft", "netherite_helmet")),
            Pair(Identifier("minecraft", "diamond_chestplate"), Identifier("minecraft", "netherite_chestplate")),
            Pair(Identifier("minecraft", "diamond_leggings"), Identifier("minecraft", "netherite_leggings")),
            Pair(Identifier("minecraft", "diamond_boots"), Identifier("minecraft", "netherite_boots"))
        ).associate { (current, next) ->
            registry.get(current)!! to registry.get(next)!!
        }
    }
}
