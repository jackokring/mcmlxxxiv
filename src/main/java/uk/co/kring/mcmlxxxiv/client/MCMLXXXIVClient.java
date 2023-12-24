package uk.co.kring.mcmlxxxiv.client;
import net.fabricmc.api.*;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import uk.co.kring.mcmlxxxiv.MCMLXXXIV;

public class MCMLXXXIVClient implements ClientModInitializer {
    /**
     * Runs the mod initializer on the client environment.
     */
    @Override
    public void onInitializeClient() {
    	// the color of Crumb
    	ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xcb8c8c, MCMLXXXIV.CRUMB);
    	// the color of Luster
    	ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xcbcb8c, MCMLXXXIV.LUSTER);
        // the color of Elon
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x8acb8d, MCMLXXXIV.ELON);
        // the color of Carbide
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x8c8ccb, MCMLXXXIV.CARBIDE);
        // the color of Never
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x31292a, MCMLXXXIV.NEVER);
    }
}
