package net.mcreator.deadlierenvironment.procedures;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.deadlierenvironment.DeadlierEnvironmentModElements;

import java.util.Map;

@DeadlierEnvironmentModElements.ModElement.Tag
public class LethalInjuriesPotionExpiresProcedure extends DeadlierEnvironmentModElements.ModElement {
	public LethalInjuriesPotionExpiresProcedure(DeadlierEnvironmentModElements instance) {
		super(instance, 31);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure LethalInjuriesPotionExpires!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		LivingEntity livingentity = (LivingEntity) dependencies.get("entity");
		if (entity instanceof LivingEntity) {
			LivingEntity livingEntity = (LivingEntity) dependencies.get("entity");
			livingEntity.getAttribute(SharedMonsterAttributes.MAX_HEALTH)
					.setBaseValue((livingentity.getAttribute(SharedMonsterAttributes.MAX_HEALTH).getBaseValue() + 2));
		} ;
	}
}
