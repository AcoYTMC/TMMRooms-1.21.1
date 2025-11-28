package net.acoyt.tmmrooms.cca;

import net.acoyt.tmmrooms.TMMRooms;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.world.World;
import org.ladysnake.cca.api.v3.component.ComponentKey;
import org.ladysnake.cca.api.v3.component.ComponentRegistry;
import org.ladysnake.cca.api.v3.component.sync.AutoSyncedComponent;

public class RoomCountComponent implements AutoSyncedComponent {
    public static final ComponentKey<RoomCountComponent> KEY = ComponentRegistry.getOrCreate(TMMRooms.id("room_count"), RoomCountComponent.class);
    private final World world;
    private int roomCount = 7;

    public RoomCountComponent(World world) {
        this.world = world;
    }

    public void sync() {
        KEY.sync(this.world);
    }

    public int getRoomCount() {
        return this.roomCount;
    }

    public void setRoomCount(int roomCount) {
        this.roomCount = roomCount;
        this.sync();
    }

    public void readFromNbt(NbtCompound tag, RegistryWrapper.WrapperLookup registryLookup) {
        this.roomCount = tag.getInt("RoomCount");
    }

    public void writeToNbt(NbtCompound tag, RegistryWrapper.WrapperLookup registryLookup) {
        tag.putInt("RoomCount", this.roomCount);
    }
}
