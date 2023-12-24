# MCMLXXXIV

A `Fabric` Minecraft Mod. Instead of using `Forge` this time I'm trying the `Fabric` way. Maybe this module will get
further, or has got further. A few basic design decisions include:

 * No mine-ables. All items and blocks are recipe or brewing based.
 * All mobs are derivatives. So making and easy class extension and simple texture repaints.
 * Extra mobs are for AI ideas. Reasons for introducing mobs are to try new AI ideas.
 * No unexpected potion ingredients. All new brew recipes based on the unused potion ingredients.
 * Potion effects are not standard. Potions provide effects not just simple combinations of existing status effects.
 * No new tools. Every beginner mod seems to have a new tool level. Vanilla controls the tool progression.
 * New effect enchantments. Only new status effects have new enhancements.
 * Custom commands when useful. There's no point in just adding a command because you can.
 * No new structures. Vanilla has this sorted already.
 * New fluids have utility. Maybe interesting, depending on features.
 * Useful redstone. THere's no point in adding in things which are gimmicks.

## Items

The currency items are built from `Fabric` and may require blocks which act as base blocks for
`Becon` blocks. Each behaves with a different cash acceleration and transaction party profit bias.

 * `Fabric` a fungible currency medium/fuel. Also, the item group icon.
   Three white `Wool` plus six `Bonemeal` in a sandwich pattern makes three `Fabric`. A unique recipe.
 * `Crumb` you might need a `Block of Iron`. "Oxygene." -- Jean-Michel Jarre
 * `Luster` you might need a `Block of Gold`. "Fool's Gold." -- Stone Roses
 * `Elon` you'll understand in the end. You might need a `Block of Emerald`. "Money! It's a gas." -- Pink Floyd
 * `Carbide` you might need a `Block of Diamond`. "Hackney Diamonds." -- Rolling Stones
 * `Never` you might need a `Block of Netherite`. "Never Gonna Give You Up." -- Rick Astley

The six currencies are tagged as `mcmlxxxiv:currency` for module dependencies. The latter five have backed value
but do not combine into blocks.

## Blocks

 * `Block of Fabric` for placing currency reserves in the world.
 * `Block of Blocks of Fabric` for 4096 `Fabric` per item stack.

## Mobs



## Potions and Effects



## Lore

