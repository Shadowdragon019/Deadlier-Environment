
package net.mcreator.deadlyierenviroment.enchantment;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantment;

import net.mcreator.deadlyierenviroment.item.WoodenDaggerItem;
import net.mcreator.deadlyierenviroment.item.StoneDaggerItem;
import net.mcreator.deadlyierenviroment.item.IronDaggerItem;
import net.mcreator.deadlyierenviroment.item.GoldDaggerItem;
import net.mcreator.deadlyierenviroment.item.DiamondDaggerItem;
import net.mcreator.deadlyierenviroment.DeadlierEnvironmentModElements;

@DeadlierEnvironmentModElements.ModElement.Tag
public class DeepCutsEnchantment extends DeadlierEnvironmentModElements.ModElement {
	@ObjectHolder("deadlier_environment:deep_cuts")
	public static final Enchantment enchantment = null;
	public DeepCutsEnchantment(DeadlierEnvironmentModElements instance) {
		super(instance, 24);
	}

	@Override
	public void initElements() {
		elements.enchantments.add(() -> new CustomEnchantment(EquipmentSlotType.MAINHAND).setRegistryName("deep_cuts"));
	}
	public static class CustomEnchantment extends Enchantment {
		public CustomEnchantment(EquipmentSlotType... slots) {
			super(Enchantment.Rarity.COMMON, EnchantmentType.WEAPON, slots);
		}

		@Override
		public int getMinLevel() {
			return 1;
		}

		@Override
		public int getMaxLevel() {
			return 3;
		}

		@Override
		public boolean canApplyAtEnchantingTable(ItemStack stack) {
			if (stack.getItem() == new ItemStack(WoodenDaggerItem.block, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(StoneDaggerItem.block, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(IronDaggerItem.block, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(GoldDaggerItem.block, (int) (1)).getItem())
				return true;
			if (stack.getItem() == new ItemStack(DiamondDaggerItem.block, (int) (1)).getItem())
				return true;
			return false;
		}

		@Override
		public boolean isTreasureEnchantment() {
			return false;
		}

		@Override
		public boolean isCurse() {
			return false;
		}

		@Override
		public boolean isAllowedOnBooks() {
			return true;
		}
	}
}
