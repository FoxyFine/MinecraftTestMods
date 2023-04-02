package com.foxyfine.my_test_mod.client.entity.render;

import com.foxyfine.my_test_mod.TestMod;
import com.foxyfine.my_test_mod.entity.passivepet.GSPetEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class GSPetRenderer extends EntityRenderer<GSPetEntity> {
    private static final ResourceLocation PARROT_TEXTURES = new ResourceLocation(TestMod.MOD_ID, "textures/entity/parrot/gs_pet.png");

    public GSPetRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn);
    }

    @Override
    public ResourceLocation getTextureLocation(GSPetEntity entity) {
        return PARROT_TEXTURES;
    }
}