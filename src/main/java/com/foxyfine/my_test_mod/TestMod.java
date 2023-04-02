package com.foxyfine.my_test_mod;

import com.foxyfine.my_test_mod.init.*;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("test_mod")
@Mod.EventBusSubscriber(modid = TestMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TestMod
{
    public static final ItemGroup MYMOD = new ItemGroup("MYMOD") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemsRegistry.EXCALIBUR.get());
        }
        @Override
        public boolean hasSearchBar() {
            return false;// true если нужен поисковик в нашей вкладке.
        }
    };
    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
        BlocksRegistry.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
            event.getRegistry()
                    .register(
                            new BlockItem(
                                    block,
                                    new Item.Properties()
                                            .tab(TestMod.MYMOD)
                            )
                                    .setRegistryName(
                                            block.getRegistryName()
                                    )
                    );
        });
    }
    private static final Logger LOGGER = LogManager.getLogger(); /*это что?*/
    public static final String MOD_ID = "test_mod"; /*публичная переменная в которой хранится id для создания предмета*/
    /*Ниже конструктор*/
    public TestMod() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.addListener(this::setup);
        eventBus.addListener(this::doClientStuff);

        MinecraftForge.EVENT_BUS.register(this);
        BlocksRegistry.BLOCKS.register(eventBus);
        ItemsRegistry.ITEMS.register(eventBus); /*зарегистрировали предметы*/
        TileRegistry.TILE_ENTITY_TYPES.register(eventBus);
        EntityRegistry.ENTITY_TYPES.register(eventBus);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
    }


}
