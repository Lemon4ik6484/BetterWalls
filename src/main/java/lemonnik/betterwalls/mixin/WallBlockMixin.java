package lemonnik.betterwalls.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.block.BlockState;
import net.minecraft.block.WallBlock;
import net.minecraft.registry.tag.BlockTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(WallBlock.class)
public class WallBlockMixin {
    @ModifyReturnValue(method = "shouldConnectTo", at = @At("RETURN"))
    private boolean doConnectFences(boolean original, @Local BlockState state) {
        if (original) {
            return state.isIn(BlockTags.FENCES);
        }

        return false;
    }
}
