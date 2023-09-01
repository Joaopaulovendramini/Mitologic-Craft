package net.felipe.tutorialmod.item.staffs;

import net.felipe.tutorialmod.item.SwordToolMaterial;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.SmallFireballEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Position;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.Random;

public class FireStaffItem extends AbstractStaffItem {


    protected static int MAX_CHARGE = 1000;
    protected static int STAFF_COOLDOWN = 20;



    protected static SoundEvent STAFF_SOUND = SoundEvents.ITEM_FIRECHARGE_USE; //PLACEHOLDER
    protected static final float SPEED = 1f;

    private static final Settings settings = new Settings().maxCount(1).maxDamage(MAX_CHARGE).fireproof();
    public static Item INSTANCE = new FireStaffItem(settings);

    public FireStaffItem(Settings settings) {
        super(settings);
    }

    @Override
    public int getChargeUsed() {
        Random rng = new Random();
        int x = 7 + rng.nextInt(3);
        return x;
    }

    @Override
    public int getGetCooldown() {
        return STAFF_COOLDOWN;
    }

    @Override
    public SoundEvent getStaffSound() {
        return STAFF_SOUND;
    }

    @Override
    public void staffEffect(ItemStack itemStack, World world, PlayerEntity player) {
        float divergence = 0F;
        // Shoot FIRE
        if (!world.isClient) {
            for (int i = 0; i <= 5; i++) {
                // FlameProjectileEntity projectile = new FlameProjectileEntity(world, player);

                // First shot should be accurate always
                if (i != 0) {
                    divergence = 0.33F;
                }

                Direction direction = player.getHorizontalFacing();
                Vec3d shootAngle = player.getRotationVector();

                Position position = player.getEyePos();
                double d = position.getX(); //+ (direction.getOffsetX() + 0.33);
                double e = position.getY() - 0.33;
                double f = position.getZ(); //+ (direction.getOffsetZ() + 0.33);;
                net.minecraft.util.math.random.Random random = world.random;
                double g = random.nextTriangular(shootAngle.x, divergence);
                // double h = random.nextTriangular(shootAngle.y, divergence);
                double h = shootAngle.y;
                double j = random.nextTriangular(shootAngle.z, divergence);
                SmallFireballEntity projectile = new SmallFireballEntity(world, d, e, f, g, h, j);

                projectile.setVelocity(player, player.getPitch(), player.getYaw(), 0.0F, SPEED, divergence);

                world.spawnEntity(projectile);
            }
        }
    }


}