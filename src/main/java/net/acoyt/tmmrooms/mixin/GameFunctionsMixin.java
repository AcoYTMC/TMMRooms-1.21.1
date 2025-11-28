package net.acoyt.tmmrooms.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import dev.doctor4t.trainmurdermystery.game.GameFunctions;
import net.acoyt.tmmrooms.cca.RoomCountComponent;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(GameFunctions.class)
public class GameFunctionsMixin {
    @ModifyExpressionValue(method = "baseInitialize", at = @At(value = "CONSTANT", args = "intValue=7"))
    private static int modifyRoomCount(int original, ServerWorld serverWorld) {
        return RoomCountComponent.KEY.get(serverWorld).getRoomCount();
    }
}
