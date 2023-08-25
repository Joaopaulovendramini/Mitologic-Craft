package net.felipe.tutorialmod.item.staffs;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EnderChestInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.recipe.Ingredient;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.world.World;

import java.util.Random;

public class EnderChestStaffItem extends AbstractStaffItem {
    protected static int MAX_CHARGE = 1000;
    protected static int STAFF_COOLDOWN = 20;

    protected static SoundEvent STAFF_SOUND = SoundEvents.BLOCK_ENDER_CHEST_OPEN;

    private static final Text CONTAINER_NAME;

    private static final Settings settings = new Settings().maxCount(1).maxDamage(MAX_CHARGE);
    public static Item INSTANCE = new EnderChestStaffItem(settings);

    public EnderChestStaffItem(Settings settings) {
        super(settings);
    }

    @Override
    public int getChargeUsed(){
        Random rng = new Random();
        int x = 7 + rng.nextInt(3);
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

    protected void spawnParticles(World world, PlayerEntity player){
        Random rng = new Random();

        for(int i = 0; i <= 6 + rng.nextInt(4); i++){

            double posOffsetX = -1.0 + rng.nextDouble(2.0);
            double posOffsetY = 0 + rng.nextDouble(1.0);
            double posOffsetZ = -1.0 + rng.nextDouble(2.0);

            double velOffsetX = -0.25 + rng.nextDouble(0.5);
            double velOffsetY = -0.1 + rng.nextDouble(0.2);
            double velOffsetZ = -0.25 + rng.nextDouble(0.5);

            world.addParticle(ParticleTypes.PORTAL,
                    player.getX() + posOffsetX, player.getY() + posOffsetY, player.getZ() + posOffsetZ,
                    velOffsetX, velOffsetY, velOffsetZ);
        }
    }

    @Override
    public void staffEffect(ItemStack itemStack, World world, PlayerEntity player) {

        EnderChestInventory enderChestInventory = player.getEnderChestInventory();

        spawnParticles(world, player);

        if (enderChestInventory != null) {
            //EnderChestBlockEntity enderChestBlockEntity = (EnderChestBlockEntity)blockEntity;
            //enderChestInventory.setActiveBlockEntity(enderChestBlockEntity);
            player.openHandledScreen(new SimpleNamedScreenHandlerFactory((syncId, inventory, playerx) -> {
                return GenericContainerScreenHandler.createGeneric9x3(syncId, inventory, enderChestInventory);
                }, CONTAINER_NAME));
                player.incrementStat(Stats.OPEN_ENDERCHEST);
                // PiglinBrain.onGuardedBlockInteracted(player, true);
        }
    }

    static {
        CONTAINER_NAME = Text.translatable("container.enderchest");
    }


    }

