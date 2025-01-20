package dev.halbear1.supernova.custom.fluid;

import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.fluid.FlowingFluid;

import java.util.function.Supplier;

public class FlammableFluid extends FlowingFluidBlock {

    public FlammableFluid(Supplier<? extends SupernovaFlowingFluid> supplier, Properties properties) {
        super(supplier, properties);
    }

}
