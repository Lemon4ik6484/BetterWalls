package lemonnik.betterwalls.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
//? if >=26.1 {
/*import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockState;
*///?} else {
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.WallBlock;
import net.minecraft.registry.tag.BlockTags;
//?}
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

//? if >=26.1 {
/*@Mixin(WallBlock.class)
*///?} else {
@Mixin(WallBlock.class)
//?}
public abstract class WallBlockMixin {
    //? if >=26.1 {
    /*@ModifyReturnValue(method = "connectsTo", at = @At("RETURN"))
    *///?} else {
    @ModifyReturnValue(method = "canConnect", at = @At("RETURN"))
     //?}
    private boolean doConnectFences(boolean original, @Local BlockState state) {
        if (!original) {
            //? if >=26.1 {
            /*if (state.is(BlockTags.FENCES)) {
                return true;
            } else if (state.is(BlockTags.WALL_SIGNS)) {
                return true;
            }
            *///?} else {
            if (state.isIn(BlockTags.FENCES)) {
                return true;
            } else if (state.isIn(BlockTags.WALL_SIGNS)) {
                return true;
            }
            //?}
        }
        return original;
    }
}