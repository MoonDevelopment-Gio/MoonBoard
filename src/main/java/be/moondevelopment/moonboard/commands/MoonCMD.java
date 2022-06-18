package be.moondevelopment.moonboard.commands;

import be.moondevelopment.moonboard.MoonBoard;
import be.moondevelopment.moonboard.scoreboard.Adapter;
import be.moondevelopment.moonboard.scoreboard.Assemble;
import be.moondevelopment.moonboard.scoreboard.AssembleStyle;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MoonCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&3&lMoonBoard &b&lv" + MoonBoard.getInstance().getDescription().getVersion()));
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8By Moondevelopment"));
            return true;
        } else if (args.length == 1) {
            if (args[0].equalsIgnoreCase("reload")) {
                if (sender.hasPermission("moonboard.reload")) {
                    MoonBoard.getInstance().assemble.cleanup();
                    MoonBoard.getInstance().reloadConfig();
                    MoonBoard.getInstance().assemble = new Assemble(MoonBoard.getInstance(), new Adapter());
                    MoonBoard.getInstance().assemble.setTicks(2);
                    MoonBoard.getInstance().assemble.setAssembleStyle(AssembleStyle.VIPER);
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cMoonBoard reloaded!"));
                    return true;
                } else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cYou don't have permission to do that!"));
                    return true;
                }
            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&3&lMoonBoard &b&lv" + MoonBoard.getInstance().getDescription().getVersion()));
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8By Moondevelopment"));
                return true;
            }
        }
        return true;
    }

}
