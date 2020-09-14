package net.novelmc.commands;

import net.novelmc.commands.loader.CommandBase;
import net.novelmc.commands.loader.CommandParameters;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandParameters(description = "Teleport to the flatworld", usage = "/<command>", aliases = "fw")
public class Flatworld extends CommandBase {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        World flatworld = Bukkit.getWorld("flatworld");
        if (flatworld == null) {
            sender.sendMessage(ChatColor.RED +
                    "The flatworld could not be found. Please contact an administrator for assistance.");
            return true;
        } else {
            Player player = (Player) sender;
            sender.sendMessage(ChatColor.GRAY + "Teleporting to the flatworld...");
            player.teleport(flatworld.getSpawnLocation());
        }
        return true;
    }
}
