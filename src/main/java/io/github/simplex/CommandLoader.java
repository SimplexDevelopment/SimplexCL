package io.github.simplex;

import io.github.simplex.api.annotations.*;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.plugin.Plugin;
import org.reflections.Reflections;

import java.lang.annotation.AnnotationTypeMismatchException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Set;

public class CommandLoader {
    private final Plugin plugin;

    public CommandLoader(Plugin plugin) {
        this.plugin = plugin;
    }

    public Plugin getPlugin() {
        return plugin;
    }

    public void registerCommands(Class<CommandBase> target) {
        Reflections reflections = new Reflections(target);
        if (target.getDeclaredAnnotation(Info.class) != null) {
            Set<Class<?>> classSet = reflections.getTypesAnnotatedWith(Info.class);
            classSet.forEach(cmd -> {
                Info info = cmd.getDeclaredAnnotation(Info.class);
                try {
                    CommandBase base = (CommandBase) cmd.getConstructor(Plugin.class, String.class, String.class).newInstance(plugin, info.permission(), info.permissionMessage());
                    DummyCommand dummy = new DummyCommand(base, info.name(), info.description(), info.usage(), Arrays.asList(info.aliases().split(",")));
                    Field f = Bukkit.getServer().getClass().getDeclaredField("commandMap");
                    f.setAccessible(true);
                    CommandMap commandMap = (CommandMap) f.get(Bukkit.getServer());
                    commandMap.register(info.name(), dummy);
                } catch (NoSuchMethodException
                        | InvocationTargetException
                        | IllegalAccessException
                        | InstantiationException
                        | NoSuchFieldException e) {
                    plugin.getLogger().severe(e.getMessage() + "\n\n\n" + e.getCause());
                }
            });
        } else if (target.getDeclaredAnnotation(Name.class) != null) {
            Set<Class<?>> classSet = reflections.getTypesAnnotatedWith(Name.class);
            classSet.forEach(cmd -> {
                Name name = cmd.getDeclaredAnnotation(Name.class);
                Description description = cmd.getDeclaredAnnotation(Description.class);
                Usage usage = cmd.getDeclaredAnnotation(Usage.class);
                Aliases aliases = cmd.getDeclaredAnnotation(Aliases.class);
                Permission permission = cmd.getDeclaredAnnotation(Permission.class);
                try {
                    CommandBase base = (CommandBase) cmd.getConstructor(Plugin.class, String.class, String.class).newInstance(plugin, permission.permission(), permission.permissionMessage());
                    DummyCommand dummy = new DummyCommand(base, name.name(), description.description(), usage.usage(), Arrays.asList(aliases.aliases().split(",")));
                    Field f = Bukkit.getServer().getClass().getDeclaredField("commandMap");
                    f.setAccessible(true);
                    CommandMap commandMap = (CommandMap) f.get(Bukkit.getServer());
                    commandMap.register(name.name(), dummy);
                } catch (NoSuchMethodException
                        | InvocationTargetException
                        | IllegalAccessException
                        | InstantiationException
                        | NoSuchFieldException e) {
                    plugin.getLogger().severe(e.getMessage() + "\n\n\n" + e.getCause());
                }
            });
        } else {
            throw new RuntimeException("Missing a required annotation! Unable to load the command.");
        }
    }
}
