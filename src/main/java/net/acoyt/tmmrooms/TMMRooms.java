package net.acoyt.tmmrooms;

import com.mojang.logging.LogUtils;
import net.acoyt.tmmrooms.command.RoomCountCommand;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;

public class TMMRooms implements ModInitializer {
	public static final String MOD_ID = "tmmrooms";
	public static final Logger LOGGER = LogUtils.getLogger();

	public void onInitialize() {
        CommandRegistrationCallback.EVENT.register(RoomCountCommand::register);
	}

    public static Identifier id(String path) {
        return Identifier.of(MOD_ID, path);
    }
}
