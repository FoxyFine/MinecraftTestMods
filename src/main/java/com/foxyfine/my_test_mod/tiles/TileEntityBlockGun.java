package com.foxyfine.my_test_mod.tiles;

import com.foxyfine.my_test_mod.init.TileRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.SnowballEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TileEntityBlockGun extends TileBase implements ITickableTileEntity {

    public TileEntityBlockGun() {
        super(TileRegistry.GUN_TILE.get());
    }

    @Override
    public SUpdateTileEntityPacket getUpdatePacket() {
        return null;
    }

    @Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {

    }

    int timer = 0;
    boolean isActive = true;
    final int RANGE = 10;
    /*Нанесение урона мобам*/
    private void hurtMobs() {
        BlockPos topCorner = this.worldPosition.offset(RANGE, RANGE, RANGE);
        BlockPos bottomCorner = this.worldPosition.offset(-RANGE, -RANGE, -RANGE);
        AxisAlignedBB axisalignedbb = new AxisAlignedBB(topCorner, bottomCorner);
        List<LivingEntity> list = this.level.getEntitiesOfClass(LivingEntity.class, axisalignedbb);
        list = list.stream()
                .sorted(Comparator.comparing(entity -> entity.position().distanceTo(Vector3d.atCenterOf(this.getBlockPos()))))
                .collect(Collectors.toList());
        LivingEntity entity = null;
        for (LivingEntity target : list) {
            if (target == null || !target.isAlive())
                continue;

            entity = target;
            break;
        }
            if (!(entity instanceof PlayerEntity))
            {
                BlockPos pos = this.getBlockPos();
                double x = pos.getX();
                double y = pos.getY();
                double z = pos.getZ();
                SnowballEntity snowballentity = new SnowballEntity(this.level, x, y, z);
                double d0 = entity.getEyeY() - (double)1.1F;
                double d1 = entity.getX() - x;
                double d2 = d0 - snowballentity.getY();
                double d3 = entity.getZ() - z;
                float f = MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F;
                snowballentity.shoot(d1, d2 + (double)f, d3, 1.6F, 12.0F);
                this.level.addFreshEntity(snowballentity);
            }
    }
    public void toggle(){
        this.isActive = !this.isActive;
    }
    @Override
    public void tick() {
        if (!this.level.isClientSide() && this.isActive) {
            this.timer++;
            if (this.timer > 5) {
                this.timer = 0;

                this.hurtMobs();
            }
        }
    }
    @Override
    public CompoundNBT save(CompoundNBT nbt) {
        nbt.putBoolean("active", this.isActive);
        return super.save(nbt);
    }

    @Override
    public void load(BlockState state, CompoundNBT nbt) {
        super.load(state, nbt);
        this.isActive = nbt.getBoolean("active");
    }
}