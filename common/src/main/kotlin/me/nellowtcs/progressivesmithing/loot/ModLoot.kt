package me.nellowtcs.progressivesmithing.loot

import dev.architectury.event.events.common.LootEvent
import me.nellowtcs.progressivesmithing.registry.ModItems
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.Item
import net.minecraft.world.level.storage.loot.LootPool
import net.minecraft.world.level.storage.loot.entries.LootItem
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue

object ModLoot {
    private val SIMPLE_DUNGEON = ResourceLocation.fromNamespaceAndPath("minecraft", "chests/simple_dungeon")
    private val DESERT_PYRAMID = ResourceLocation.fromNamespaceAndPath("minecraft", "chests/desert_pyramid")
    private val BURIED_TREASURE = ResourceLocation.fromNamespaceAndPath("minecraft", "chests/buried_treasure")
    private val ABANDONED_MINESHAFT = ResourceLocation.fromNamespaceAndPath("minecraft", "chests/abandoned_mineshaft")
    private val ANCIENT_CITY = ResourceLocation.fromNamespaceAndPath("minecraft", "chests/ancient_city")

    private data class LootDrop(
        val tableId: ResourceLocation,
        val item: () -> Item,
        val chance: Float,
    )

    private val drops = listOf(
        LootDrop(SIMPLE_DUNGEON, { ModItems.COPPER_UPGRADE.get() }, 0.12f),
        LootDrop(DESERT_PYRAMID, { ModItems.GOLD_UPGRADE.get() }, 0.08f),
        LootDrop(BURIED_TREASURE, { ModItems.CHAIN_UPGRADE.get() }, 0.10f),
        LootDrop(ABANDONED_MINESHAFT, { ModItems.IRON_UPGRADE.get() }, 0.10f),
        LootDrop(ANCIENT_CITY, { ModItems.DIAMOND_UPGRADE.get() }, 0.05f),
    )

    fun init() {
        LootEvent.MODIFY_LOOT_TABLE.register { id, context, builtin ->
            // Ensure we are adjusting vanilla built-in files
            if (!builtin) return@register

            for (drop in drops) {
                // Safely extract the pure ResourceLocation path for evaluation
                if (id.location() == drop.tableId) {
                    context.addPool(
                        LootPool.lootPool()
                            .setRolls(ConstantValue.exactly(1.0f))
                            .`when`(LootItemRandomChanceCondition.randomChance(drop.chance))
                            .add(LootItem.lootTableItem(drop.item()))
                    )
                }
            }
        }
    }
}
