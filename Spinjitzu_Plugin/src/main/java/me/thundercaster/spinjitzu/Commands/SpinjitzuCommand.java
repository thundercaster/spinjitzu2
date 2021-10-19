package me.thundercaster.spinjitzu.Commands;

import me.thundercaster.spinjitzu.Spinjitzu;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityEnterBlockEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.spigotmc.event.entity.EntityMountEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpinjitzuCommand implements CommandExecutor, Listener {



    Spinjitzu plugin;
    public SpinjitzuCommand(Spinjitzu plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player p){
            if(args.length==1){
                if (args[0].equalsIgnoreCase("on")) {
                    plugin.plist.add(p);
                    }
                if (args[0].equalsIgnoreCase("off")){
                    plugin.plist.remove(p);
                    }
                if (!((args[0].equalsIgnoreCase("on") | args[0].equalsIgnoreCase("off") ))){
                    p.sendMessage(ChatColor.RED + "put on or off as first argument");
                }

                }
            else {
                p.sendMessage(ChatColor.RED + "please only use 1 argument");
                }
            }
        return true;
    }


}

