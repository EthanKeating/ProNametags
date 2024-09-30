package me.eths.pronametags.nametag;

import java.util.HashMap;
import java.util.UUID;

public class NameTagProvider {

    private final HashMap<UUID, BaseNameTag> nameTagMap = new HashMap<>();

    public BaseNameTag fetch(UUID uuid) {
        BaseNameTag nameTag = nameTagMap.getOrDefault(uuid, new BaseNameTag());

        //Calculate all logic to provide a nametag for player
        // -Vault Rank
        // -ProNameTag Group
        // -Permission
        //Populate / Repopulate BaseNametag object without creating a new one
        return nameTagMap.put(uuid, nameTag);
    }

    public void remove(UUID uuid) {
        nameTagMap.remove(uuid);
    }

}
