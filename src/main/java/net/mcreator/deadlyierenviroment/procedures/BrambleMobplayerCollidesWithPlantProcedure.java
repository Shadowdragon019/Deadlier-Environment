package net.mcreator.deadlyierenviroment.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.deadlyierenviroment.potion.BleedingPotion;
import net.mcreator.deadlyierenviroment.DeadlierEnvironmentModElements;

import java.util.Map;
import java.util.Collection;

@DeadlierEnvironmentModElements.ModElement.Tag
public class BrambleMobplayerCollidesWithPlantProcedure extends DeadlierEnvironmentModElements.ModElement {
	public BrambleMobplayerCollidesWithPlantProcedure(DeadlierEnvironmentModElements instance) {
		super(instance, 2);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure BrambleMobplayerCollidesWithPlant!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).attackEntityFrom(new DamageSource("brambles").setDamageBypassesArmor(), (float) 2);
		}
		if ((!(new Object() {
			boolean check(Entity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == BleedingPotion.potion)
							return true;
					}
				}
				return false;
			}
		}.check(entity)))) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(BleedingPotion.potion, (int) 300, (int) 0));
		}
	}
}
