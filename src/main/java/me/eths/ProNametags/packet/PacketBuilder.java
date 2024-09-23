package me.eths.ProNametags.packet;

import com.github.retrooper.packetevents.protocol.player.User;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerEntityMetadata;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerSetCooldown;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerSetPassengers;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerSpawnEntity;

public class PacketBuilder {

    private final User user;
    private final WrapperPlayServerSpawnEntity spawnPacket;
    private final WrapperPlayServerSetPassengers passengersPacket;
    private final WrapperPlayServerEntityMetadata metadataPacket;

    public PacketBuilder(User user) {
        this.user = user;

        spawnPacket = new WrapperPlayServerSpawnEntity(null);
        passengersPacket = new WrapperPlayServerSetPassengers(null);
        metadataPacket = new WrapperPlayServerEntityMetadata(null);
    }

}
