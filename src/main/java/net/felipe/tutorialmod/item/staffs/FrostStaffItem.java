package net.felipe.tutorialmod.item.staffs;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import net.felipe.tutorialmod.entity.IceProjectileEntity;

import java.util.Random;

public class FrostStaffItem extends AbstractStaffItem {

    protected static int MAX_CHARGE = 1000;
    protected static int STAFF_COOLDOWN = 2;

    protected static SoundEvent STAFF_SOUND = SoundEvents.BLOCK_SNOW_BREAK; //PLACEHOLDER
    protected static final float SPEED = 1f;

    private static final Settings settings = new Settings().maxCount(1).maxDamage(MAX_CHARGE);
    public static Item INSTANCE = new FrostStaffItem(settings);

    public FrostStaffItem(Settings settings) {
        super(settings);
    }

    @Override
    public int getChargeUsed(){
        Random rng = new Random();
        int x = 4 + rng.nextInt(3);
        return x;
    }
    @Override
    public int getGetCooldown(){
        return STAFF_COOLDOWN;
    }

    @Override
    public SoundEvent getStaffSound(){
        return STAFF_SOUND;
    }

    @Override
    public void staffEffect(ItemStack itemStack, World world, PlayerEntity player) {
        // Shoot ice
        if (!world.isClient) {
            IceProjectileEntity projectile = new IceProjectileEntity(world, player);
            // projectile.setItem(itemStack);
            projectile.setVelocity(player, player.getPitch(), player.getYaw(), 0.0F, SPEED, 0F);
            world.spawnEntity(projectile);
        }
    }

}