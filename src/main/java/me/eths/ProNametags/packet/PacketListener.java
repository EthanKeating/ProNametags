package me.eths.ProNametags.packet;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.event.PacketListenerAbstract;
import com.github.retrooper.packetevents.event.PacketSendEvent;
import com.github.retrooper.packetevents.event.UserDisconnectEvent;
import com.github.retrooper.packetevents.protocol.ConnectionState;
import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import com.github.retrooper.packetevents.protocol.packettype.PacketType;
import com.github.retrooper.packetevents.protocol.player.User;
import com.github.retrooper.packetevents.protocol.player.UserProfile;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerDestroyEntities;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerPlayerInfo;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerSpawnEntity;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerSpawnPlayer;
import me.eths.ProNametags.ProNametagsPlugin;
import me.eths.ProNametags.player.PlayerData;
import me.eths.ProNametags.player.PlayerHandler;
import me.eths.ProNametags.player.impl.TrackedPlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class PacketListener extends PacketListenerAbstract implements Listener {

    private PlayerHandler playerHandler;

    public PacketListener() {
        playerHandler = ProNametagsPlugin.INSTANCE.getPlayerHandler();
        PacketEvents.getAPI().getEventManager().registerListener(this);
    }

    @Override
    public void onUserDisconnect(UserDisconnectEvent event) {
        final User user = event.getUser();
        if (user.getConnectionState() != ConnectionState.PLAY)
            return;

        playerHandler.delete(user.getUUID());
    }

    @Override
    public void onPacketSend(PacketSendEvent event) {
        if (event.getPacketType() == PacketType.Play.Server.SPAWN_PLAYER) {
            WrapperPlayServerSpawnPlayer wrappedPacket = new WrapperPlayServerSpawnPlayer(event);

            User user = event.getUser();
            PlayerData playerData = playerHandler.get(event.getUser().getUUID());

            UUID uuid = wrappedPacket.getUUID();

            if (Bukkit.getPlayer(uuid) == null) return;

            playerData.create(uuid, wrappedPacket.getEntityId());

        }

        if (event.getPacketType() == PacketType.Play.Server.DESTROY_ENTITIES) {
            User user = event.getUser();
            PlayerData playerData = playerHandler.get(user.getUUID());

            WrapperPlayServerDestroyEntities wrappedPacket = new WrapperPlayServerDestroyEntities(event);

            for(int i : wrappedPacket.getEntityIds())
                playerData.delete(i);

        }
    }

}
