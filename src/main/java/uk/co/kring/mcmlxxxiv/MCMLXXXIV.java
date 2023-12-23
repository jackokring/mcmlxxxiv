package uk.co.kring.mcmlxxxiv;
import net.fabricmc.api.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
//import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class MCMLXXXIV implements ModInitializer {

	public static final String MID = "mcmlxxxiv";
	public static Item FABRIC;
	public static Item ELON;
	
	private static ItemGroup ITEM_GROUP;

	/**
	 * An item constructor.
	 */
	Item itemReg(String id, int fuel, float compost) {
		Item i = new Item(new FabricItemSettings());
		if(ITEM_GROUP == null) {
			ITEM_GROUP = FabricItemGroup.builder()
			.icon(() -> new ItemStack(i))
			.displayName(Text.translatable("itemGroup." + MID + "." + id))
        	.entries((context, entries) -> {
				entries.add(i);
			}).build();
			Registry.register(Registries.ITEM_GROUP, new Identifier(MID, id), ITEM_GROUP);
			/* ItemGroupEvents.modifyEntriesEvent(ITEM_GROUP).register(content -> {
				content.add(i);
			}); */
		}
		if(fuel > 0) FuelRegistry.INSTANCE.add(i, fuel);
		if(compost > 0) CompostingChanceRegistry.INSTANCE.add(i, compost);
		return Registry.register(Registries.ITEM, new Identifier(MID, id), i);
	}

    /**
     * Runs the mod initializer.
     */
    @Override
    public void onInitialize() {
		// fuel ticks and compost chance
		FABRIC = itemReg("fabric", 369, 0.0f);// first item is group icon
		ELON = itemReg("elon", 501, 0.0f);
    }
}
