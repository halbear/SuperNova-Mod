package dev.halbear1.supernova.custom.block.blockstate_stuff;

import dev.halbear1.supernova.custom.block.blockstate_stuff.enums.PipeContents;
import net.minecraft.state.EnumProperty;

public class SupernovaBlockstates {
    public static final EnumProperty<PipeContents> EMPTY_PIPE;
    public static final EnumProperty<PipeContents> CRUDE_OIL_PIPE;
    public static final EnumProperty<PipeContents> WATER_PIPE;
    public static final EnumProperty<PipeContents> LAVA_PIPE;
    public static final EnumProperty<PipeContents> SALT_WATER_PIPE;

    static {
        EMPTY_PIPE = EnumProperty.create("empty", PipeContents.class);
        CRUDE_OIL_PIPE = EnumProperty.create("crude_oil", PipeContents.class);
        WATER_PIPE = EnumProperty.create("water", PipeContents.class);
        LAVA_PIPE = EnumProperty.create("lava", PipeContents.class);
        SALT_WATER_PIPE = EnumProperty.create("salt_water", PipeContents.class);
    }
}
