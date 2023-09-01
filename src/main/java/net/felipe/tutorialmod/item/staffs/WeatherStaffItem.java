package net.felipe.tutorialmod.item.staffs;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;

public class WeatherStaffItem extends AbstractStaffItem {

    protected static int CHARGE_USED = 500;
    protected static int MAX_CHARGE = 1000;
    protected static int STAFF_COOLDOWN = 200;

    protected static SoundEvent STAFF_SOUND = SoundEvents.ENTITY_FIREWORK_ROCKET_LAUNCH; //PLACEHOLDER

    private static final Settings settings = new Settings().maxCount(1).maxDamage(MAX_CHARGE);
    public static Item INSTANCE = new WeatherStaffItem(settings);

    public WeatherStaffItem(Settings settings) {
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


    @Override
    public void staffEffect(ItemStack itemStack, World world, PlayerEntity player) {
        MinecraftServer server = MinecraftClient.getInstance().getServer();
        ServerCommandSource source = player.getCommandSource();
        assert server != null;
        CommandManager commandManager = server.getCommandManager();
        // fuck this shit
        // commandManager.execute(null, "weather thunder 10000");
    }



}
