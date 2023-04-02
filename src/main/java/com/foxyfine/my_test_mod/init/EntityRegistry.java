package com.foxyfine.my_test_mod.init;

import com.foxyfine.my_test_mod.TestMod;
import com.foxyfine.my_test_mod.entity.passivepet.GSPetEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.util.ResourceLocation;

public class EntityRegistry {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES,
            TestMod.MOD_ID);
    public static final RegistryObject<EntityType<GSPetEntity>> GS_PET = ENTITY_TYPES
            .register("gs_pet",
                    () -> EntityType.Builder.<GSPetEntity>of(GSPetEntity::new, EntityClassification.CREATURE)
                            .sized(0.9f, 1.49f)
                            .build("gs_pet"));
}
