
package net.mcreator.deadlierenvironment.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.deadlierenvironment.DeadlierEnvironmentModElements;

@DeadlierEnvironmentModElements.ModElement.Tag
public class DiamondDaggerItem extends DeadlierEnvironmentModElements.ModElement {
	@ObjectHolder("deadlier_environment:diamond_dagger")
	public static final Item block = null;
	public DiamondDaggerItem(DeadlierEnvironmentModElements instance) {
		super(instance, 11);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 780;
			}

			public float getEfficiency() {
				return 8f;
			}

			public float getAttackDamage() {
				return 1f;
			}

			public int getHarvestLevel() {
				return 3;
			}

			public int getEnchantability() {
				return 10;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(Items.GOLD_INGOT, (int) (1)));
			}
		}, 3, -1.6f, new Item.Properties().group(ItemGroup.COMBAT)) {
		}.setRegistryName("diamond_dagger"));
	}
}
