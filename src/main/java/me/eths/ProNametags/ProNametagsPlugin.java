package me.eths.ProNametags;

import lombok.Getter;
import me.eths.ProNametags.nametag.NametagFetcher;
import me.eths.ProNametags.packet.PacketListener;
import me.eths.ProNametags.player.PlayerHandler;
import me.eths.ProNametags.thread.NametagUpdaterThread;
import org.bukkit.plugin.java.JavaPlugin;
import org.checkerframework.checker.units.qual.N;

public class ProNametagsPlugin extends JavaPlugin {

    public static ProNametagsPlugin INSTANCE;
    @Getter private PlayerHandler playerHandler;
    @Getter private NametagFetcher nametagFetcher;

    @Override
    public void onEnable() {
        INSTANCE = this;

        playerHandler = new PlayerHandler();
        nametagFetcher = new NametagFetcher();

        new PacketListener();
        new NametagUpdaterThread().start();
    }

}
