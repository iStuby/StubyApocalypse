package net.stuby.stubyapocalypse.item;

import com.sun.jna.platform.unix.solaris.LibKstat;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.stuby.stubyapocalypse.StubyApocalypse;
import net.stuby.stubyapocalypse.block.ModBlocks;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, StubyApocalypse.MOD_ID);

    public static final RegistryObject<CreativeModeTab> STUBYAPOCALYPSE_TAB = CREATIVE_MODE_TAB.register("stubyapocalypse_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.GUNPARTS.get()))
                    .title(Component.translatable("creativetab.stubyapocalypse_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.GUNPARTS.get());

                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
