package io.github.simplex;

import org.bukkit.command.CommandSender;

public abstract class Permissible {
    private final String permission;
    private final String permissionMessage;

    public Permissible(String permission, String permissionMessage) {
        this.permission = permission;
        this.permissionMessage = permissionMessage;
    }

    public Permissible(String permission) {
        this(permission, "You do not have permission to use this command.");
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
}
