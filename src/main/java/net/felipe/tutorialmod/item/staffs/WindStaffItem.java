package net.felipe.tutorialmod.item.staffs;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public class WindStaffItem extends AbstractStaffItem{

    protected static int CHARGE_USED = 100;
    protected static int MAX_CHARGE = 10;
    protected static int STAFF_COOLDOWN = 60;

    protected static SoundEvent STAFF_SOUND = SoundEvents.ENTITY_FIREWORK_ROCKET_LAUNCH; //PLACEHOLDER
    protected static double BOOST_HEIGHT = 1.75;
    protected static int EFFECT_DURATION = 200;

    private static final Settings settings = new Settings().maxCount(1).maxDamage(MAX_CHARGE);
    public static Item INSTANCE = new WindStaffItem(settings);

    public WindStaffItem(Settings settings) {
        super(settings);
    }

    @Override
    public int getChargeUsed(){
        return CHARGE_USED;
    }

    @Override
    public int getGetCooldown(){
        return STAFF_COOLDOWN;
    }

    @Override
    public SoundEvent getStaffSound(){
        return STAFF_SOUND;
    }

    public void windPush(World world, PlayerEntity player){

        // Player coords
        double pX = player.getX();
        double pY = player.getY();
        double pZ = player.getZ();

        // Box bounds
        double bbX1 = pX + 3;
        double bbY1 = pY + 2;
        double bbZ1 = pZ + 3;
        double bbX2 = pX - 3;
        double bbY2 = pY - 2;
        double bbZ2 = pZ - 3;

        Box searchBox = new Box(bbX2, bbY2, bbZ2,
                bbX1, bbY1, bbZ1);

        List<LivingEntity> entities = world.getTargets(LivingEntity.class, TargetPredicate.DEFAULT, player, searchBox);

        entities.forEach(entity -> {
            if(entity != null){

                // Entity cords
                double eX = entity.getX();
                double eY = entity.getY();
                double eZ = entity.getZ();

                // Vectors
                Vec3d pushVec = new Vec3d(-(pX - eX), -(pY - eY), -(pZ - eZ));
                double multiplier = ( 1 / pushVec.length());
                pushVec = pushVec.normalize();
                pushVec = pushVec.multiply(multiplier, 0.15, multiplier);
                pushVec = pushVec.add(0, 0.5, 0);

                entity.addVelocity(pushVec);
                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, EFFECT_DURATION / 2));
            }
        });


    }

    @Override
    public void staffEffect(ItemStack itemStack, World world, PlayerEntity player) {
        windPush(world, player);
        player.addVelocity(0, BOOST_HEIGHT, 0);
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, EFFECT_DURATION));
        world.addParticle(ParticleTypes.EXPLOSION, //PLACEHOLDER
                player.getX(), player.getY() + 1, player.getZ(), 0, BOOST_HEIGHT, 0);

    }


    }

