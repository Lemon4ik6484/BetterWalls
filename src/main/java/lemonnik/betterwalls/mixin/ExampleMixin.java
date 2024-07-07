package lemonnik.betterwalls.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.PaneBlock;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static net.minecraft.block.Block.cannotConnect;

@Mixin(MinecraftServer.class)
public static class ExampleMixin {
	@Inject(at = @At("HEAD"), method = "loadWorld")
	private void init(CallbackInfo info) {
		// This code is injected into the start of MinecraftServer.loadWorld()
	}
}

@Override
private boolean shouldConnectTo(BlockState state, boolean faceFullSquare, Direction side) {
	Block block = state.getBlock();
	boolean bl = block instanceof FenceGateBlock && FenceGateBlock.canWallConnect(state, side);
	return state.isIn(BlockTags.WALLS) || !cannotConnect(state) && faceFullSquare || block instanceof PaneBlock || bl;
}