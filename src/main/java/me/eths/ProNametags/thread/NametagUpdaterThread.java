package me.eths.ProNametags.thread;

import lombok.SneakyThrows;
import me.eths.ProNametags.ProNametagsPlugin;
import me.eths.ProNametags.nametag.NametagFetcher;
import me.eths.ProNametags.player.PlayerData;
import me.eths.ProNametags.player.PlayerHandler;
import me.eths.ProNametags.player.impl.TrackedPlayer;

import java.util.Map;
import java.util.UUID;

public class NametagUpdaterThread extends Thread {

    public NametagUpdaterThread()
    {
        super("pronametag-updater");
    }

    @SneakyThrows
    public void run() {
        PlayerHandler playerHandler = ProNametagsPlugin.INSTANCE.getPlayerHandler();
        NametagFetcher nametagFetcher = ProNametagsPlugin.INSTANCE.getNametagFetcher();

        while(true) {
            long startTime = System.currentTimeMillis();
            for(Map.Entry<UUID, PlayerData> playerDataEntry : playerHandler.getPlayerDataMap().entrySet()) {
                UUID uuid = playerDataEntry.getKey();
                PlayerData playerData = playerDataEntry.getValue();

                playerData.getDisplay().clear();
                playerData.getDisplay().addAll(nametagFetcher.getNametag(uuid));
            }

            for(PlayerData playerData : playerHandler.getPlayerDataMap().values())
                for(TrackedPlayer trackedPlayer : playerData.getTrackedPlayerMap().values())
                    trackedPlayer.update(playerHandler.get(trackedPlayer.getUuid()).getDisplay());

            long runTime = System.currentTimeMillis() - startTime;

            Thread.sleep(Math.max(0, 50L - runTime));
        }
    }
}
