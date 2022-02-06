package io.github.simplex;

/*
 * This class is intended to be used as a nested class inside your main command class.
 * For example:
 */
public abstract class SubCommandBase extends CommandBase {
    public SubCommandBase(String permission, String permissionMessage, boolean allowConsole) {
        super(permission, permissionMessage, allowConsole);
    }

    public SubCommandBase(String permission, String permissionMessage) {
        this(permission, permissionMessage, true);
    }
}
