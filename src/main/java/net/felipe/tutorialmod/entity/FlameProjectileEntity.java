package net.felipe.tutorialmod.entity;


import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.EndGatewayBlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.entity.projectile.SmallFireballEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;

import java.util.Random;

public class FlameProjectileEntity extends ThrownItemEntity {

    protected int particleTimer = 0;

    public FlameProjectileEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public FlameProjectileEntity(World world, LivingEntity owner) {
        super(EntityMod.FlameProjectileEntityType, owner, world);
    }

    public FlameProjectileEntity(World world, double x, double y, double z) {
        super(EntityMod.FlameProjectileEntityType, x, y, z, world);
    }

    @Override
    protected Item getDefaultItem() {
        return Items.FIRE_CHARGE;
    }

    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        if (!this.getWorld().isClient) {
            Entity entity = entityHitResult.getEntity();
            Entity entity2 = this.getOwner();
            int i = entity.getFireTicks();
            entity.setOnFireFor(5);
            if (!entity.damage(this.getDamageSources().onFire(), 5.0F)) {
                entity.setFireTicks(i);
            } else if (entity2 instanceof LivingEntity) {
                this.applyDamageEffects((LivingEntity)entity2, entity);
            }

        }
    }

    protected void onBlockHit(BlockHitResult blockHitResult) {
        super.onBlockHit(blockHitResult);
        if (!this.getWorld().isClient) {
            Entity entity = this.getOwner();
            if (!(entity instanceof MobEntity) || this.getWorld().getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) {
                BlockPos blockPos = blockHitResult.getBlockPos().offset(blockHitResult.getSide());
                if (this.getWorld().isAir(blockPos)) {
                    this.getWorld().setBlockState(blockPos, AbstractFireBlock.getState(this.getWorld(), blockPos));
                }
            }

        }
    }

    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!this.getWorld().isClient) {
            this.discard();
        }

    }

    public boolean canHit() {
        return false;
    }

    public boolean damage(DamageSource source, float amount) {
        return false;
    }

}