package me.eths.ProNametags.player;

import lombok.Data;
import me.eths.ProNametags.player.impl.TrackedPlayer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Data
public class PlayerData {

    private final UUID uuid;
    private final List<String> display = new ArrayList<>();

    private final HashMap<Integer, TrackedPlayer> trackedPlayerMap = new HashMap<>();

    public TrackedPlayer create(UUID uuid, int entityId) {
        return trackedPlayerMap.put(entityId, new TrackedPlayer(uuid, entityId));
    }

    public TrackedPlayer get(int entityId) {
        return trackedPlayerMap.get(entityId);
    }

    public void delete(int entityId) {
        trackedPlayerMap.remove(entityId);
    }

}
