package net.felipe.tutorialmod.item.staffs;

import net.felipe.tutorialmod.item.SwordToolMaterial;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.SnowballEntity;  // Import the appropriate water projectile entity
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.Random;

public class WaterStaffItem extends AbstractStaffItem {
    public static final Item INSTANCE = new WaterStaffItem(settings);

    // ... Other constants and fields ...

    protected static SoundEvent STAFF_SOUND = SoundEvents.ENTITY_BOAT_PADDLE_WATER;  // Change to a water-related sound

    public WaterStaffItem(Settings settings) {
        super(settings);
    }

    // ... Constructor and other methods ...

    @Override
    public void staffEffect(ItemStack itemStack, World world, PlayerEntity player) {
        float divergence = 0F;
        // Shoot WATER
        if (!world.isClient) {
            for (int i = 0; i <= 5; i++) {
                if (i != 0) {
                    divergence = 0.33F;
                }

                Direction direction = player.getHorizontalFacing();
                Vec3d shootAngle = player.getRotationVector();

                double d = player.getX();  // Use player's position
                double e = player.getY() - 0.33;  // Use player's eye level
                double f = player.getZ();  // Use player's position

                Random random = (Random) world.random;
                double g = ((net.minecraft.util.math.random.Random) random).nextTriangular(shootAngle.x, divergence);
                double h = shootAngle.y;
                double j = ((net.minecraft.util.math.random.Random) random).nextTriangular(shootAngle.z, divergence);

                // Replace SmallFireballEntity with your water projectile entity class
                SnowballEntity waterProjectile = new SnowballEntity(world, d, e, f);
                waterProjectile.setVelocity(g, h, j);  // Set the velocity based on your projectile entity

                world.spawnEntity(waterProjectile);
            }
        }
    }
}
