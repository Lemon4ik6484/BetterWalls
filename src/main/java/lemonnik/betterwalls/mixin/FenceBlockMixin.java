package lemonnik.betterwalls.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.block.BlockState;
import net.minecraft.block.FenceBlock;
import net.minecraft.registry.tag.BlockTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(FenceBlock.class)
public class FenceBlockMixin {
    @ModifyReturnValue(method = "canConnect", at = @At("RETURN"))
    private boolean doConnectFences(boolean original, @Local BlockState state) {
        return original ? true : state.isIn(BlockTags.WALLS);
    }
}
