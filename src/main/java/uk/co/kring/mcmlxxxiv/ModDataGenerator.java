package uk.co.kring.mcmlxxxiv;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.advancement.*;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        FabricDataGenerator.Pack pack = generator.createPack();

        pack.addProvider(AdvancementsProvider::new);
        pack.addProvider(TagProvider::new);
    }
    
    static class TagProvider extends FabricTagProvider.ItemTagProvider {
		public TagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
			super(output, completableFuture);
		}

		static final TagKey<Item> CURRENCY_ITEMS = TagKey.of(RegistryKeys.ITEM,
				new Identifier(MCMLXXXIV.MID, "currency"));

		@Override
		protected void configure(RegistryWrapper.WrapperLookup arg) {
			getOrCreateTagBuilder(CURRENCY_ITEMS)
				.add(MCMLXXXIV.CRUMB)
				.add(MCMLXXXIV.LUSTER)
				.add(MCMLXXXIV.ELON)
				.add(MCMLXXXIV.CARBIDE)
				.add(MCMLXXXIV.NEVER);
				//.addOptionalTag(ItemTags.DIRT);// dirty deeds done dirt cheap
		}
	}

    static class AdvancementsProvider extends FabricAdvancementProvider {
        protected AdvancementsProvider(FabricDataOutput dataGenerator) {
            super(dataGenerator);
        }

        @Override
        public void generateAdvancement(Consumer<AdvancementEntry> consumer) {
            AdvancementEntry rootAdvancement = Advancement.Builder.create()
		        .display(
		            MCMLXXXIV.FABRIC, // The display icon
		            Text.literal("Das Capital"), // The title
		            Text.literal("You're on the road to greatness"), // The description
		            new Identifier("textures/gui/advancements/backgrounds/adventure.png"), // Background image used
		            AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
		            true, // Show toast top right
		            true, // Announce to chat
		            false // Hidden in the advancement tab
		        )
		        // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
		        .criterion("got_fabric", InventoryChangedCriterion.Conditions.items(MCMLXXXIV.FABRIC))
		        .build(consumer, MCMLXXXIV.MID + "/root");
        }
    }

}
