package be.moondevelopment.moonboard.scoreboard;

import be.moondevelopment.moonboard.MoonBoard;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Adapter implements AssembleAdapter {

    @Override
    public String getTitle(Player player) {
        return ChatColor.translateAlternateColorCodes('&', MoonBoard.getInstance().getConfig().getString("title"));
    }

    @Override
    public List<String> getLines(Player player) {
        final List<String> toReturn = new ArrayList<>();

        for (String s : MoonBoard.getInstance().getConfig().getStringList("lines")) {
            String message1 = s.replace("{player}", player.getName());
            String message = PlaceholderAPI.setPlaceholders(player, message1);
            toReturn.add(ChatColor.translateAlternateColorCodes('&', message));
        }

        return toReturn;
    }
}
