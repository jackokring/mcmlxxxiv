package uk.co.kring.mcmlxxxiv;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.advancement.*;
import java.nio.file.Path;
import java.util.Optional;
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
		pack.addProvider(TagProvider::new);
		// perform lang servicing here
		pack.addProvider(EnglishLangProvider::new);
		// then ...
        pack.addProvider(AdvancementsProvider::new);
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
	
	static class EnglishLangProvider extends FabricLanguageProvider {
		FabricDataOutput dG;
		private EnglishLangProvider(FabricDataOutput dataGenerator) {
		    // Specifying en_us is optional, by default is en_us.
			super(dataGenerator, "en_us");
			dG = dataGenerator;
		}
	 
		@Override
		public void generateTranslations(TranslationBuilder translationBuilder) {
	 		//translationBuilder.add(SIMPLE_ITEM, "Simple Item");
			//translationBuilder.add(SIMPLE_BLOCK, "Simple Block");
			//translationBuilder.add(SIMPLE_ITEM_GROUP, "Simple Item Group");
			// can add Item, Block, ItemGroup, EntityType<T>, Enchantment,
			// EntityAttribute, StatType<T>, StatusEffect or Identifier
		 
			// Load an existing language file.
			try {
				Optional<Path> existingFilePath = dG.getModContainer()
					.findPath("assets/mcmlxxxiv/lang/en_us.static.json");
				if(existingFilePath.isPresent())
					translationBuilder.add(existingFilePath.get());
			} catch (Exception e) {
				throw new RuntimeException("Failed to add existing language file!", e);
			}
		}
	}
	
	//public void generate(RecipeExporter exporter)//replace Consumer<>

    static class AdvancementsProvider extends FabricAdvancementProvider {
        protected AdvancementsProvider(FabricDataOutput dataGenerator) {
            super(dataGenerator);
        }

        @Override
        public void generateAdvancement(Consumer<AdvancementEntry> consumer) {
            AdvancementEntry rootAdvancement = Advancement.Builder.create()
		        .display(
		            MCMLXXXIV.FABRIC, // The display icon
		            Text.translatable("advancement.mcmlxxxiv.das_capital_title"), // The title
		            Text.translatable("advancement.mcmlxxxiv.das_capital_desc"), // The description
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
