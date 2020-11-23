package net.mcreator.deadlyierenviroment.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.deadlyierenviroment.DeadlierEnvironmentModElements;

import java.util.Map;
import java.util.Collection;

@DeadlierEnvironmentModElements.ModElement.Tag
public class BleedingOnPotionActiveTickProcedure extends DeadlierEnvironmentModElements.ModElement {
	public BleedingOnPotionActiveTickProcedure(DeadlierEnvironmentModElements instance) {
		super(instance, 4);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure BleedingOnPotionActiveTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.getPersistentData().putDouble("bleedingProgress", ((entity.getPersistentData().getDouble("bleedingProgress")) + 1));
		if (((entity.getPersistentData().getDouble("bleedingProgress")) >= 40)) {
			entity.getPersistentData().putDouble("bleedingProgress", 0);
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).attackEntityFrom(new DamageSource("bleed").setDamageBypassesArmor(), (float) 1);
			}
			if ((new Object() {
				boolean check(Entity _entity) {
					if (_entity instanceof LivingEntity) {
						Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
						for (EffectInstance effect : effects) {
							if (effect.getPotion() == Effects.REGENERATION)
								return true;
						}
					}
					return false;
				}
			}.check(entity))) {
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).removePotionEffect(Effects.REGENERATION);
				}
			}
		}
	}
}
