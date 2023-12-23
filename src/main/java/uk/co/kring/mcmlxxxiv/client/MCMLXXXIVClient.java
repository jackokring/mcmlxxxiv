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
        // the color of Elon
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x8acb8d, MCMLXXXIV.ELON);
    }
}
