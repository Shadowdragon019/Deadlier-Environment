package net.mcreator.deadlyierenviroment.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.EntityMobGriefingEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.Explosion;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.Entity;

import net.mcreator.deadlyierenviroment.DeadlierEnvironmentModVariables;
import net.mcreator.deadlyierenviroment.DeadlierEnvironmentModElements;

import java.util.Map;
import java.util.HashMap;

@DeadlierEnvironmentModElements.ModElement.Tag
public class EntityAttemptGriefProcedure extends DeadlierEnvironmentModElements.ModElement {
	public EntityAttemptGriefProcedure(DeadlierEnvironmentModElements instance) {
		super(instance, 15);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure EntityAttemptGrief!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure EntityAttemptGrief!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if ((entity instanceof CreeperEntity)) {
			if (dependencies.get("event") != null) {
				Object _obj = dependencies.get("event");
				if (_obj instanceof Event) {
					Event _evt = (Event) _obj;
					if (_evt.hasResult())
						_evt.setResult(Event.Result.DENY);
				}
			}
			if (world instanceof World && !world.getWorld().isRemote) {
				world.getWorld().createExplosion(null, (int) (entity.getPosX()), (int) (entity.getPosY()), (int) (entity.getPosZ()),
						(float) (DeadlierEnvironmentModVariables.MapVariables.get(world).CreeperExplosionSize), Explosion.Mode.BREAK);
			}
		}
	}

	@SubscribeEvent
	public void onEntityGrief(EntityMobGriefingEvent event) {
		Entity entity = event.getEntity();
		double i = entity.getPosX();
		double j = entity.getPosY();
		double k = entity.getPosZ();
		World world = entity.world;
		Map<String, Object> dependencies = new HashMap<>();
		dependencies.put("x", i);
		dependencies.put("y", j);
		dependencies.put("z", k);
		dependencies.put("world", world);
		dependencies.put("entity", entity);
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}
}
