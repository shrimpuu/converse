package net.novelmc.commands;

import net.novelmc.commands.loader.CommandBase;
import net.novelmc.commands.loader.CommandParameters;
import net.novelmc.commands.loader.Messages;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

@CommandParameters(description = "Broadcast a message to the server",
        usage = "/<command> <message>",
        aliases = "shout, announce, broadcast")
public class Say extends CommandBase
{
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args)
    {
        if (!sender.hasPermission("converse.say"))
        {
            sender.sendMessage(Messages.NO_PERMISSION);
            return true;
        }

        String msg = "";

        if (args.length == 0)
        {
            sender.sendMessage(ChatColor.RED + "Incorrect usage!");
            return false;
        } else {
            StringBuilder builder = new StringBuilder();
            builder.append(ChatColor.AQUA + "[" + "Server:" + sender.getName() + "] ");
            builder.append(StringUtils.join(args, ' '));
            Bukkit.broadcastMessage(builder.toString());

        }

        return true;
    }
}
