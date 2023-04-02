package com.foxyfine.my_test_mod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class TrampolineBlock extends Block {

    public TrampolineBlock() {
        super(Properties.of(Material.STONE).harvestTool(ToolType.PICKAXE));
    }
    public void stepOn(World world, BlockPos pos, Entity entity )
    {
            Vector3d vector3d = entity.getDeltaMovement();
                entity.setDeltaMovement(vector3d.x, vector3d.y + 3f, vector3d.z);
        super.stepOn(world, pos, entity);
    }

}
