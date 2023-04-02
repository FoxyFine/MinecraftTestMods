package com.foxyfine.my_test_mod.init;

import com.foxyfine.my_test_mod.entity.passivepet.GSPetEntity;
import com.foxyfine.my_test_mod.TestMod;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TestMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EventBusSubscriber {
    @SubscribeEvent
    public void regis(EntityAttributeCreationEvent e){
        e.put(EntityRegistry.GS_PET.get(), GSPetEntity.createAttributes().build());
    }


}
