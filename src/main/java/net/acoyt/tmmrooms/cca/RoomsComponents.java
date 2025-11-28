package net.acoyt.tmmrooms.cca;

import org.ladysnake.cca.api.v3.world.WorldComponentFactoryRegistry;
import org.ladysnake.cca.api.v3.world.WorldComponentInitializer;

public class RoomsComponents implements WorldComponentInitializer {
    public void registerWorldComponentFactories(WorldComponentFactoryRegistry registry) {
        registry.register(RoomCountComponent.KEY, RoomCountComponent.class, RoomCountComponent::new);
    }
}
