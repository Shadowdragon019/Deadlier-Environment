package net.mcreator.deadlierenvironment.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.deadlierenvironment.DeadlierEnvironmentModElements;

import java.util.Map;

@DeadlierEnvironmentModElements.ModElement.Tag
public class BleedingPotionStartedappliedProcedure extends DeadlierEnvironmentModElements.ModElement {
	public BleedingPotionStartedappliedProcedure(DeadlierEnvironmentModElements instance) {
		super(instance, 5);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure BleedingPotionStartedapplied!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.getPersistentData().putDouble("bleedingProgress", 0);
	}
}
