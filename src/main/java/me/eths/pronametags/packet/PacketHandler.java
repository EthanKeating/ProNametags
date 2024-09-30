package me.eths.pronametags.packet;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.event.PacketListenerAbstract;
import com.github.retrooper.packetevents.event.PacketSendEvent;
import com.github.retrooper.packetevents.event.UserDisconnectEvent;
import com.github.retrooper.packetevents.protocol.ConnectionState;
import com.github.retrooper.packetevents.protocol.player.User;
import me.eths.pronametags.ProNameTagsPlugin;
import me.eths.pronametags.nametag.NameTagProvider;

public class PacketHandler extends PacketListenerAbstract {

    private final NameTagProvider nameTagProvider;

    public PacketHandler() {
        PacketEvents.getAPI().getEventManager().registerListener(this);

        nameTagProvider = ProNameTagsPlugin.INSTANCE.getNameTagProvider();
    }

    @Override
    public void onUserDisconnect(UserDisconnectEvent event) {
        final User user = event.getUser();
        if (user.getConnectionState() != ConnectionState.PLAY)
            return;

        nameTagProvider.remove(user.getUUID());
    }

    @Override
    public void onPacketSend(PacketSendEvent event) {
    }

}
