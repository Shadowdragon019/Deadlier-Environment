package net.mcreator.deadlierenvironment.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.entity.Entity;

import net.mcreator.deadlierenvironment.DeadlierEnvironmentModVariables;
import net.mcreator.deadlierenvironment.DeadlierEnvironmentModElements;

import java.util.Map;
import java.util.HashMap;

@DeadlierEnvironmentModElements.ModElement.Tag
public class CreeperExplosionCommandExecutedProcedure extends DeadlierEnvironmentModElements.ModElement {
	public CreeperExplosionCommandExecutedProcedure(DeadlierEnvironmentModElements instance) {
		super(instance, 16);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure CreeperExplosionCommandExecuted!");
			return;
		}
		if (dependencies.get("cmdparams") == null) {
			if (!dependencies.containsKey("cmdparams"))
				System.err.println("Failed to load dependency cmdparams for procedure CreeperExplosionCommandExecuted!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure CreeperExplosionCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		HashMap cmdparams = (HashMap) dependencies.get("cmdparams");
		IWorld world = (IWorld) dependencies.get("world");
		if ((("Default").equals((new Object() {
			public String getText() {
				String param = (String) cmdparams.get("0");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText())))) {
			{
				Entity _ent = entity;
				if (!_ent.world.isRemote && _ent.world.getServer() != null) {
					_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
							"tellraw @s {\"text\":\"Creeper Explosion size was defaulted to 6\"}");
				}
			}
			DeadlierEnvironmentModVariables.MapVariables.get(world).CreeperExplosionSize = (double) 6;
			DeadlierEnvironmentModVariables.MapVariables.get(world).syncData(world);
		} else if ((new Object() {
			int convert(String s) {
				try {
					return Integer.parseInt(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert((new Object() {
			public String getText() {
				String param = (String) cmdparams.get("0");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText())) >= 1)) {
			{
				Entity _ent = entity;
				if (!_ent.world.isRemote && _ent.world.getServer() != null) {
					_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
							(("tellraw @s {\"text\":\"Creeper Explosion size was set to ") + "" + (new Object() {
								int convert(String s) {
									try {
										return Integer.parseInt(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert((new Object() {
								public String getText() {
									String param = (String) cmdparams.get("0");
									if (param != null) {
										return param;
									}
									return "";
								}
							}.getText()))) + "" + ("\"}")));
				}
			}
			DeadlierEnvironmentModVariables.MapVariables.get(world).CreeperExplosionSize = (double) new Object() {
				int convert(String s) {
					try {
						return Integer.parseInt(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert((new Object() {
				public String getText() {
					String param = (String) cmdparams.get("0");
					if (param != null) {
						return param;
					}
					return "";
				}
			}.getText()));
			DeadlierEnvironmentModVariables.MapVariables.get(world).syncData(world);
		} else {
			{
				Entity _ent = entity;
				if (!_ent.world.isRemote && _ent.world.getServer() != null) {
					_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
							"tellraw @s {\"text\":\"Type a positive integer or Default!\",\"color\":\"red\"}");
				}
			}
		}
	}
}
