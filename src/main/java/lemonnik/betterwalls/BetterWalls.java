package lemonnik.betterwalls;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BetterWalls implements ModInitializer {
	public static final String MOD_ID = "betterwalls";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Fixing block connections!");
	}
}