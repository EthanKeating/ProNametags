package me.eths.pronametags.nametag;

import lombok.Getter;
import me.eths.pronametags.nametag.impl.INameTagLine;

import java.util.ArrayList;
import java.util.List;

public class BaseNameTag {

    @Getter private final List<INameTagLine> nameTagLineList;

    public BaseNameTag() {
        nameTagLineList = new ArrayList<>();
    }


}
