package dev.halbear1.supernova.custom.block.blockstate_stuff.enums;

import net.minecraft.util.IStringSerializable;

public enum PipeContents implements IStringSerializable {
    EMPTY("empty"),
    FLOWING("flowing");

    private final String name;

    private PipeContents(String Name) {
        this.name = Name;
    }

    public String toString() {
        return this.name;
    }

    public String getString() {
        return this.name;
    }
}