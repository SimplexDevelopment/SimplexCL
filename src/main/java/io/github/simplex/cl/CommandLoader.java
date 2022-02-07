package io.github.simplex.cl;

import io.github.simplex.cl.api.annotations.Info;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Set;

public class CommandLoader {
    private final Plugin plugin;

    public CommandLoader(Plugin plugin) {
        this.plugin = plugin;
    }

    public <T extends CommandBase> void registerCommands(Class<T> commandRoot) {
        Reflections reflections = new Reflections(commandRoot);
        if (commandRoot.getDeclaredAnnotation(Info.class) != null) {
            Set<Class<?>> classSet = reflections.getTypesAnnotatedWith(Info.class);
            classSet.forEach(cmd -> {
                Info info = cmd.getDeclaredAnnotation(Info.class);
                try {
                    CommandBase base = (CommandBase) cmd.getConstructor().newInstance();
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
