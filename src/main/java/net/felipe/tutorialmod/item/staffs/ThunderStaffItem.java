package net.felipe.tutorialmod.item.staffs;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public class ThunderStaffItem extends WindStaffItem {
    protected static int CHARGE_USED = 90;
    protected static int MAX_CHARGE = 1000;
    protected static int STAFF_COOLDOWN = 40;

    protected static float STAFF_DAMAGE = 200F;

    protected static SoundEvent STAFF_SOUND = SoundEvents.ENTITY_LIGHTNING_BOLT_IMPACT;
    protected static double HORIZONTAL_MOD = 6;
    protected static int EFFECT_DURATION = 300;

    private static final Settings settings = new Settings().maxCount(1).maxDamage(MAX_CHARGE);
    public static Item INSTANCE = new ThunderStaffItem(settings);

    public ThunderStaffItem(Settings settings) {
        super(settings);
    }

    @Override
    public int getChargeUsed() {
        return CHARGE_USED;
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
    public void windPush(World world, PlayerEntity player) {

        // Player coords
        double pX = player.getX();
        double pY = player.getY();
        double pZ = player.getZ();

        // Box bounds
        double bbX1 = pX + HORIZONTAL_MOD;
        double bbY1 = pY + 3;
        double bbZ1 = pZ + HORIZONTAL_MOD;
        double bbX2 = pX - HORIZONTAL_MOD;
        double bbY2 = pY - 3;
        double bbZ2 = pZ - HORIZONTAL_MOD;

        Box searchBox = new Box(bbX2, bbY2, bbZ2,
                bbX1, bbY1, bbZ1);

        List<LivingEntity> entities = world.getTargets(LivingEntity.class, TargetPredicate.DEFAULT, player, searchBox);

        entities.forEach(entity -> {
            if (entity != null) {

                // Entity cords
                double eX = entity.getX();
                double eY = entity.getY();
                double eZ = entity.getZ();

                Direction direction = player.getHorizontalFacing();
                Vec3d shootAngle = player.getRotationVector();
                // Vectors
                Vec3d pushVec = new Vec3d(-(pX - eX), -(pY - eY), -(pZ - eZ));
                double multiplier = (1 / pushVec.length());
                pushVec = pushVec.normalize();
                pushVec = pushVec.multiply(8, 1, 8);
                pushVec = pushVec.multiply(multiplier, 1, multiplier);
                pushVec = pushVec.add(0, 2, 0);

                entity.addVelocity(pushVec);
                if (entity.canTakeDamage()) {
                    entity.damage(entity.getDamageSources().playerAttack(player), STAFF_DAMAGE);
                }
                // entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, EFFECT_DURATION));
            }
        });
    }

    public void staffParticles(World world, PlayerEntity player, double pX, double pZ) {
        world.addParticle(ParticleTypes.EXPLOSION, //PLACEHOLDER
                pX, player.getY() + 0.5, pZ, 0, 0, 0);
    }

    @Override
    public void staffEffect(ItemStack itemStack, World world, PlayerEntity player) {
        double playerX = player.getX();
        double playerY = player.getY();
        double playerZ = player.getZ();

        // Cria um raio no mundo
        LightningEntity lightning = EntityType.LIGHTNING_BOLT.create(world);
        lightning.refreshPositionAfterTeleport((playerX + 5 ), playerY , playerZ );
        world.spawnEntity(lightning);

        // Reproduz o som do raio
        world.playSound(player, playerX, playerY, playerZ, SoundEvents.ENTITY_LIGHTNING_BOLT_THUNDER, SoundCategory.PLAYERS, 1.0f, 1.0f);
    }
}