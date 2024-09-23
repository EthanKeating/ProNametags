package me.eths.ProNametags.player.impl;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class TrackedPlayer {

    private final UUID uuid;
    private final int entityId;

    public TrackedPlayer(UUID uuid, int entityId) {
        this.uuid = uuid;
        this.entityId = entityId;
    }

    public void update(List<String> display) {

    }

}
