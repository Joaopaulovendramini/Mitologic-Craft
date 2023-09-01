package net.felipe.tutorialmod;

import net.fabricmc.api.ModInitializer;

import net.felipe.tutorialmod.block.ModBlocks;
import net.felipe.tutorialmod.entity.EntityMod;
import net.felipe.tutorialmod.item.ModItems;
import net.felipe.tutorialmod.item.ModItemsGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModBlocks.registerModBloks();
		ModItemsGroup.registerItemGroups();
		EntityMod.registerEntities();
		EntityMod.registerEntityRenderers();

	}
}