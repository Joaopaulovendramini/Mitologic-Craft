package net.felipe.tutorialmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.felipe.tutorialmod.entity.EntityMod;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

public class TutorialModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(EntityMod.IceProjectileEntityType, (context) ->
                new FlyingItemEntityRenderer(context));
        EntityRendererRegistry.register(EntityMod.FlameProjectileEntityType, (context) ->
                new FlyingItemEntityRenderer(context));
        EntityRendererRegistry.register(EntityMod.WaterprojectileEntityType, (context) ->
                new FlyingItemEntityRenderer(context));

    }
}
