package be.moondevelopment.moonboard;

import be.moondevelopment.moonboard.commands.MoonCMD;
import be.moondevelopment.moonboard.scoreboard.Adapter;
import be.moondevelopment.moonboard.scoreboard.Assemble;
import be.moondevelopment.moonboard.scoreboard.AssembleStyle;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class MoonBoard extends JavaPlugin {
    private static MoonBoard instance;
    public Assemble assemble;


    @Override
    public void onEnable() {
        instance = this;
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&3Enabling MoonBoard..."));
        if (this.getDescription().getName().equals("MoonBoard") && this.getDescription().getMain().equals("be.moondevelopment.moonboard.MoonBoard") && this.getDescription().getAuthors().get(0).equals("MoonDevelopment")) {
            this.getConfig().options().copyDefaults(true);
            this.saveDefaultConfig();
            assemble = new Assemble(this, new Adapter());
            assemble.setTicks(2);
            assemble.setAssembleStyle(AssembleStyle.VIPER);
            getCommand("moonboard").setExecutor(new MoonCMD());
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&3MoonBoard enabled!"));
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&cMoonBoard version: " + this.getDescription().getVersion()));
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&cMoonBoard author: " + this.getDescription().getAuthors().get(0)));
        } else {
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&4There was an error enabling MoonBoard!"));
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&cIt looks like this plugin is not the correct one!"));
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&cPlease download the correct plugin from MC-Market"));
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&4Please report this to the author (MoonDevelopment)!"));
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&4MoonBoard version: " + this.getDescription().getVersion()));
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&4MoonBoard author: " + this.getDescription().getAuthors().get(0)));
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&4MoonBoard name: " + this.getDescription().getName()));
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&4MoonBoard main: " + this.getDescription().getMain()));
            Bukkit.getPluginManager().disablePlugin(this);
        }

    }

    public static MoonBoard getInstance() {
        return instance;
    }

    @Override
    public void onDisable() {
        if (this.getDescription().getName().equals("MoonBoard") && this.getDescription().getMain().equals("be.moondevelopment.moonboard.MoonBoard") && this.getDescription().getAuthors().get(0).equals("MoonDevelopment")) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&3Disabling MoonBoard..."));
            assemble.cleanup();
            this.saveDefaultConfig();
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&3MoonBoard disabled!"));
        }
    }


}
