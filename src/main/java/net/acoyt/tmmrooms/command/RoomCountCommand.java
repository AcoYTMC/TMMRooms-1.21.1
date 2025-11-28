package net.acoyt.tmmrooms.command;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.acoyt.tmmrooms.cca.RoomCountComponent;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;

import static net.minecraft.server.command.CommandManager.argument;
import static net.minecraft.server.command.CommandManager.literal;

public class RoomCountCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher, CommandRegistryAccess ignoredAcc, CommandManager.RegistrationEnvironment ignoredDedicated) {
        dispatcher.register(literal("tmmrooms:roomCount")
                .then(argument("count", IntegerArgumentType.integer(1))
                        .executes(context -> {
                            ServerCommandSource source = context.getSource();
                            ServerWorld serverWorld = source.getWorld();
                            ServerPlayerEntity player = source.getPlayer();
                            if (serverWorld != null) {
                                int count = IntegerArgumentType.getInteger(context, "count");
                                RoomCountComponent.KEY.get(serverWorld).setRoomCount(count);

                                if (player != null) {
                                    MutableText text = Text.translatable("commands.roomCount.success", count);
                                    player.sendMessage(text);
                                }

                                return Command.SINGLE_SUCCESS;
                            }

                            return 0;
                        })
                )
        );
    }
}
