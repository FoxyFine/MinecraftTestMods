package com.foxyfine.my_test_mod.block;

import com.foxyfine.my_test_mod.init.TileRegistry;
import com.foxyfine.my_test_mod.tiles.TileEntityBlockGun;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class GunBlock extends Block {
    public GunBlock() {
        super(Block.Properties.of(Material.STONE).strength(1.5F).harvestTool(ToolType.PICKAXE));
    }

    @Override
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit) {
        if (!world.isClientSide() && hand == Hand.MAIN_HAND ) {
            TileEntity tile = world.getBlockEntity(pos);
            if (tile instanceof TileEntityBlockGun) {
                ((TileEntityBlockGun) tile).toggle();
                world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.ANVIL_LAND, SoundCategory.PLAYERS, 1.0F, 1.0F);
                return ActionResultType.SUCCESS;
            }
        }

        return super.use(state, world, pos, player, hand, hit);
    }
    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return TileRegistry.GUN_TILE.get().create();
    }
}


