package com.foxyfine.my_test_mod.tiles;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public abstract class TileBase extends TileEntity {
    public TileBase(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public CompoundNBT getUpdateTag() {
        return save(new CompoundNBT());
    }

    public abstract SUpdateTileEntityPacket getUpdatePacket();

    public abstract void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt);
}