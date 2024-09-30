package me.eths.pronametags;

import lombok.Getter;
import me.eths.pronametags.nametag.NameTagBuilder;
import me.eths.pronametags.nametag.NameTagProvider;
import me.eths.pronametags.packet.PacketBuilder;
import me.eths.pronametags.packet.PacketHandler;
import org.bukkit.plugin.java.JavaPlugin;

public class ProNameTagsPlugin extends JavaPlugin {

    public static ProNameTagsPlugin INSTANCE;

    @Getter private NameTagBuilder nameTagBuilder;
    @Getter private NameTagProvider nameTagProvider;
    @Getter private PacketHandler packetHandler;
    @Getter private PacketBuilder packetBuilder;

    @Override
    public void onEnable() {
        INSTANCE = this;

        nameTagBuilder = new NameTagBuilder();
        nameTagProvider = new NameTagProvider();
        packetHandler = new PacketHandler();
        packetBuilder = new PacketBuilder();
    }

}
