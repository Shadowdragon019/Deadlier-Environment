package net.mcreator.deadlierenvironment.procedures;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.deadlierenvironment.DeadlierEnvironmentModElements;

import java.util.Map;
import java.util.HashMap;

@DeadlierEnvironmentModElements.ModElement.Tag
public class ResetAttributeCommandExecutedProcedure extends DeadlierEnvironmentModElements.ModElement {
	public ResetAttributeCommandExecutedProcedure(DeadlierEnvironmentModElements instance) {
		super(instance, 30);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure ResetAttributeCommandExecuted!");
			return;
		}
		if (dependencies.get("cmdparams") == null) {
			if (!dependencies.containsKey("cmdparams"))
				System.err.println("Failed to load dependency cmdparams for procedure ResetAttributeCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		HashMap cmdparams = (HashMap) dependencies.get("cmdparams");
		LivingEntity livingentity = (LivingEntity) dependencies.get("entity");
		if ((((new Object() {
			public String getText() {
				String param = (String) cmdparams.get("0");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText())).equals("Health"))) {
			if (entity instanceof LivingEntity) {
				LivingEntity livingEntity = (LivingEntity) dependencies.get("entity");
				livingEntity.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20);
			} ;
		}
	}
}
