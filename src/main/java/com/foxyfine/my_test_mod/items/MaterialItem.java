package com.foxyfine.my_test_mod.items;

import com.foxyfine.my_test_mod.TestMod;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.AbstractRaiderEntity;
import net.minecraft.entity.monster.BlazeEntity;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.SnowballEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;

import java.util.function.Predicate;


public class MaterialItem extends Item {
    public MaterialItem() {
        super(new Properties().tab(TestMod.MYMOD));
        /*super вызывает конструктор класс Item (основной класс)*/
    }
    private boolean PKM;
    public void tick (TickEvent.PlayerTickEvent event)
    {
        if (event.player != null)
        {
            PlayerEntity player = event.player;
            World world = event.player.getCommandSenderWorld();
            int x = (int) player.getX();
            int y = (int) player.getY();
            int z = (int) player.getZ();
            if(PKM)
            {
                BlockPos blockAtPosition = new BlockPos(x - 1, y - 1, z);
                if ((world.getBlockState(blockAtPosition) == Blocks.AIR.defaultBlockState()) || (world.getBlockState(blockAtPosition) == Blocks.WATER.defaultBlockState()) || (world.getBlockState(blockAtPosition) == Blocks.LAVA.defaultBlockState()))
                {
                    world.setBlock(new BlockPos(x - 1, y - 1, z), Blocks.GLASS.defaultBlockState(), 1);
                }
            }
        }
    }
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
            if (!world.isClientSide) {
                if (!PKM) {
                    PKM = true;
                    MinecraftForge.EVENT_BUS.addListener(this::tick);
                } else {
                    PKM = false;
                }
            }
        return ActionResult.sidedSuccess(itemstack, world.isClientSide());
    }
}
