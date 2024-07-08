package lemonnik.betterwalls.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PaneBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.BlockRotation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(WallBlock.class)
public abstract class WallBlockMixin {
    @Shadow public abstract BlockState rotate(BlockState state, BlockRotation rotation);

    private static boolean beTall = false;

    @ModifyReturnValue(method = "shouldConnectTo", at = @At("RETURN"))
    private boolean doConnectFences(boolean original, @Local BlockState state) {
        beTall = false;
        if (!original) {
            Block block = state.getBlock();
            if (state.isIn(BlockTags.FENCES)) {
                beTall = true;
                return true;
            }
        }
        return original;
    }

    @ModifyReturnValue(method = "shouldUseTallShape", at = @At("RETURN"))
    private static boolean doTallWall(boolean original) {
        if (beTall) {
            return true;
        } else {
            return original;
        }
    }
}