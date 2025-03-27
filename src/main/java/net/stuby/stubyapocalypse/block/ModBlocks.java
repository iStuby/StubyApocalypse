package net.stuby.stubyapocalypse.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.stuby.stubyapocalypse.StubyApocalypse;
import net.stuby.stubyapocalypse.block.custom.BarbedWireBlock;
import net.stuby.stubyapocalypse.item.ModCreativeModTabs;
import net.stuby.stubyapocalypse.item.ModItems;

import java.util.function.Supplier;

import static net.minecraft.world.item.Items.CHAIN;
import static net.minecraft.world.item.Items.registerBlock;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, StubyApocalypse.MOD_ID);

    public static final RegistryObject<Block> BARBED_WIRE = registerBlock("barbed_wire",
            () -> new BarbedWireBlock(BlockBehaviour.Properties.copy(Blocks.CHAIN).sound(SoundType.CHAIN).noOcclusion()));

    // Metodo principale di registrazione
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);  // Register the BlockItem too
        return toReturn;
    }

    // Metodo per registrare il BlockItem
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    // Metodo di registrazione degli eventi
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
