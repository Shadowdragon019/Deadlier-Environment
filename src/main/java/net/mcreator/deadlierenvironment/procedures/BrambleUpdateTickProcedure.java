package net.mcreator.deadlierenvironment.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tags.BlockTags;

import net.mcreator.deadlierenvironment.block.BrambleBlock;
import net.mcreator.deadlierenvironment.DeadlierEnvironmentModElements;

import java.util.Map;

@DeadlierEnvironmentModElements.ModElement.Tag
public class BrambleUpdateTickProcedure extends DeadlierEnvironmentModElements.ModElement {
	public BrambleUpdateTickProcedure(DeadlierEnvironmentModElements instance) {
		super(instance, 6);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure BrambleUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure BrambleUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure BrambleUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure BrambleUpdateTick!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double CurrentHeight = 0;
		double MaxHeight = 0;
		MaxHeight = (double) 3;
		CurrentHeight = (double) 0;
		for (int index0 = 0; index0 < (int) ((MaxHeight)); index0++) {
			if ((BlockTags.getCollection().getOrCreate(new ResourceLocation(("forge:brambles").toLowerCase(java.util.Locale.ENGLISH)))
					.contains((world.getBlockState(new BlockPos((int) x, (int) (y - (CurrentHeight)), (int) z))).getBlock()))) {
				CurrentHeight = (double) ((CurrentHeight) + 1);
			} else {
				break;
			}
		}
		if ((((CurrentHeight) < (MaxHeight)) && (world.isAirBlock(new BlockPos((int) x, (int) (y + 1), (int) z))))) {
			world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), BrambleBlock.block.getDefaultState(), 3);
		}
	}
}
