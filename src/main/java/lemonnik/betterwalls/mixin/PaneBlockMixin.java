package lemonnik.betterwalls.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
//? if >=26.1 {
/*import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.state.BlockState;
*///?} else {
import net.minecraft.block.BlockState;
import net.minecraft.block.PaneBlock;
import net.minecraft.registry.tag.BlockTags;
//?}
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

//? if >=26.1 {
/*@Mixin(IronBarsBlock.class)
*///?} else {
@Mixin(PaneBlock.class)
//?}
public class PaneBlockMixin {
    //? if >=26.1 {
    /*@ModifyReturnValue(method = "attachsTo", at = @At("RETURN"))
    *///?} else {
    @ModifyReturnValue(method = "connectsTo", at = @At("RETURN"))
    //?}
    private boolean doConnectFences(boolean original, @Local BlockState state) {
        return original
                //? if >=26.1 {
                /*|| state.is(BlockTags.FENCES)
                || state.is(BlockTags.FENCE_GATES)
                || state.is(BlockTags.WALL_SIGNS);
                *///?} else {
                || state.isIn(BlockTags.FENCES)
                || state.isIn(BlockTags.FENCE_GATES)
                || state.isIn(BlockTags.WALL_SIGNS);
                //?}
    }
}