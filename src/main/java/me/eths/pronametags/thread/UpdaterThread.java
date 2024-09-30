package me.eths.pronametags.thread;

import lombok.SneakyThrows;
import me.eths.pronametags.ProNameTagsPlugin;
import me.eths.pronametags.nametag.NameTagBuilder;
import me.eths.pronametags.nametag.NameTagProvider;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class UpdaterThread extends Thread {


    private final NameTagProvider nameTagProvider;
    private final NameTagBuilder nameTagBuilder;

    public UpdaterThread()
    {
        super("nametag-updater");

        nameTagProvider = ProNameTagsPlugin.INSTANCE.getNameTagProvider();
        nameTagBuilder = ProNameTagsPlugin.INSTANCE.getNameTagBuilder();
    }

    @SneakyThrows
    public void run() {
        while(true) {
            long startTime = System.currentTimeMillis();

            for(Player player : Bukkit.getOnlinePlayers()) {
                nameTagProvider.fetch(player.getUniqueId());
            }


            long runTime = System.currentTimeMillis() - startTime;

            Thread.sleep(Math.max(0, 50L - runTime));
        }
    }
}
