package me.eths.ProNametags.nametag;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class NametagFetcher {

    private final HashMap<UUID, List<String>> nametagDataMap = new HashMap<>();


    public List<String> getNametag(UUID uuid) {
        return Arrays.asList(
                "Line #1",
                "Line #2",
                "Line #3",
                "Line #4"
        );
    }
}
