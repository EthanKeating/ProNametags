package me.eths.ProNametags.player;

import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class PlayerHandler {

    @Getter private final HashMap<UUID, PlayerData> playerDataMap = new HashMap<>();

    public PlayerData get(UUID uuid) {
        return playerDataMap.getOrDefault(uuid, playerDataMap.put(uuid, new PlayerData(uuid)));
    }

    public void delete(UUID uuid) {
        playerDataMap.remove(uuid);
    }

}
