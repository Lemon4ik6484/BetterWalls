package lemonnik.betterwalls.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
//? if >=26.1 {
/*import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.state.BlockState;
*///?} else {
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.PaneBlock;
import net.minecraft.registry.tag.BlockTags;
//?}
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(FenceBlock.class)
public class FenceBlockMixin {
    //? if >=26.1 {
    /*@ModifyReturnValue(method = "connectsTo", at = @At("RETURN"))
    *///?} else {
    @ModifyReturnValue(method = "canConnect", at = @At("RETURN"))
    //?}
    private boolean doConnectFences(boolean original, @Local BlockState state) {
        Block block = state.getBlock();
        return original
                //? if >=26.1 {
                /*|| state.is(BlockTags.WALLS)
                || state.is(BlockTags.FENCES)
                || block instanceof IronBarsBlock
                || state.is(BlockTags.WALL_SIGNS);
                *///?} else {
                || state.isIn(BlockTags.WALLS)
                || state.isIn(BlockTags.FENCES)
                || block instanceof PaneBlock
                || state.isIn(BlockTags.WALL_SIGNS);
                //?}
    }
}