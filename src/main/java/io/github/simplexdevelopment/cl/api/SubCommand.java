package io.github.simplexdevelopment.cl.api;

@FunctionalInterface
public interface SubCommand {
    /**
     * This provides a way to use a functional interface to clearly define subcommands and their actions.
     */
    void execute();
}
