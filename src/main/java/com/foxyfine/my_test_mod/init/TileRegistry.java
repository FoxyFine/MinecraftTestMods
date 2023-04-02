package com.foxyfine.my_test_mod.init;

import com.foxyfine.my_test_mod.TestMod;
import com.foxyfine.my_test_mod.tiles.*;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
public class TileRegistry {
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, TestMod.MOD_ID);
    public static final RegistryObject<TileEntityType<TileEntityBlockGun>> GUN_TILE = TILE_ENTITY_TYPES.register("gun_tile", () ->
            TileEntityType.Builder.of(TileEntityBlockGun::new, BlocksRegistry.GUN_BLOCK.get()).build(null));
}