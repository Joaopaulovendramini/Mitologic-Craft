package net.felipe.tutorialmod.item.staffs;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public abstract class AbstractStaffItem extends Item  {

    protected static int CHARGE_USED = 10;
    protected static int MAX_CHARGE = 1000;
    protected static int STAFF_COOLDOWN = 2;

    protected static SoundEvent STAFF_SOUND = SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP;

    static final Settings settings = new Settings().maxCount(1).maxDamage(MAX_CHARGE);
    // public static Item INSTANCE = new AbstractStaffItem(settings);
    public AbstractStaffItem(Settings settings) {
        super(settings);
    }

    // Getters
    public int getMaxCharge(){
        return MAX_CHARGE;
    }

    public int getChargeUsed(){
        return CHARGE_USED;
    }

    public int getGetCooldown(){
        return STAFF_COOLDOWN;
    }

    public SoundEvent getStaffSound(){
        return STAFF_SOUND;
    }

    // Main methods
    protected void playStaffSound(World world, PlayerEntity player){
        if (!world.isClient) {
            world.playSound(null, player.getBlockPos(), getStaffSound(), SoundCategory.PLAYERS, 1f, 1f);
        }
    }

    public abstract void staffEffect(ItemStack itemStack, World world, PlayerEntity player);

    // Overrides

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {

        ItemStack itemStack = player.getStackInHand(hand);

        int maxCharge = getMaxCharge();
        int chargeUsed = getChargeUsed();
        int staffCooldown = getGetCooldown();

        // If there is charge left and it's not on cool down...
        if(!(itemStack.getDamage() == maxCharge - 1) && !(player.getItemCooldownManager().isCoolingDown(itemStack.getItem()))){
            if(itemStack.getDamage() > maxCharge - chargeUsed){
                itemStack.setDamage(maxCharge - 1);
            } else {
                itemStack.setDamage(itemStack.getDamage() + chargeUsed);
            }

            // Set cooldown
            player.getItemCooldownManager().set(itemStack.getItem(), staffCooldown);

            // Play staff sound
            playStaffSound(world, player);

            // Do what the staff does
            staffEffect(itemStack, world, player);

            return TypedActionResult.success(player.getStackInHand(hand));

        } else {

            return TypedActionResult.fail(itemStack);

        }
    }
}
