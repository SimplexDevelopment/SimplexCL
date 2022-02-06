package io.github.simplex;

import io.github.simplex.api.annotations.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.reflections.Reflections;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Set;

public class CommandLoader<T extends CommandBase> {
    private final Plugin plugin;

    public CommandLoader(Plugin plugin) {
        this.plugin = plugin;
    }

    public void registerCommands(Class<T> target) {
        Reflections reflections = new Reflections(target);
        if (target.getDeclaredAnnotation(Info.class) != null) {
            Set<Class<?>> classSet = reflections.getTypesAnnotatedWith(Info.class);
            classSet.forEach(cmd -> {
                Info info = cmd.getDeclaredAnnotation(Info.class);
                Permission permission = cmd.getDeclaredAnnotation(Permission.class);
                try {
                    CommandBase base = (CommandBase) cmd.getConstructor(String.class,
                            String.class,
                            Boolean.class)
                            .newInstance(permission.permission(),
                                    permission.permissionMessage(),
                                    permission.allowConsole());
                    DummyCommand dummy = new DummyCommand(plugin,
                            base,
                            info.name(),
                            info.description(),
                            info.usage(),
                            Arrays.asList(info.aliases().split(",")));
                    Bukkit.getCommandMap().register(info.name(), "SimplexCL", dummy);
                } catch (NoSuchMethodException
                        | InvocationTargetException
                        | IllegalAccessException
                        | InstantiationException e) {
                    plugin.getLogger().severe(e.getMessage() + "\n\n\n" + e.getCause());
                }
            });
        } else {
            throw new RuntimeException("Missing a required annotation! Unable to load the command.");
        }
    }
}
