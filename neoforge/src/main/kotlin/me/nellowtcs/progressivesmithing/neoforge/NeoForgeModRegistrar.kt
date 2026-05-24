package me.nellowtcs.progressivesmithing.neoforge
import me.nellowtcs.progressivesmithing.ProgressiveSmithing

import net.minecraft.util.Identifier
import net.neoforged.fml.common.Mod
import net.neoforged.neoforge.registries.DeferredRegister
import net.neoforged.neoforge.registries.ForgeRegistries
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.forge.event.lifecycle.FMLCommonSetupEvent

@Mod.EventBusSubscriber(modid = ProgressiveSmithing.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
object NeoForgeModRegistrar {
    private val REGISTER = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, ProgressiveSmithing.MOD_ID)

    @SubscribeEvent
    fun setup(event: FMLCommonSetupEvent) {
        REGISTER.register(event.bus)
    }

    init {
        REGISTER.register("progressive_smithing") {
            ProgressiveSmithingRecipeSerializer
        }
    }
}
