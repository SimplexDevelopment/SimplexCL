package io.github.simplex.cl;

import org.bukkit.command.CommandSender;

public abstract class Permissible {
    private final String permission;
    private final String permissionMessage;
    private final boolean allowConsole;

    public Permissible(String permission, String permissionMessage, boolean allowConsole) {
        this.permission = permission;
        this.permissionMessage = permissionMessage;
        this.allowConsole = allowConsole;
    }

    public String getPermission() {
        return permission;
    }

    public String getPermissionMessage() {
        return permissionMessage;
    }

    public boolean hasPermission(CommandSender sender) {
        return sender.hasPermission(getPermission());
    }

    public boolean allowConsole() {
        return allowConsole;
    }
}
