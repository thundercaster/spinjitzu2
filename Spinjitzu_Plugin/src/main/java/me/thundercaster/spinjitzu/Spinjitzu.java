package me.thundercaster.spinjitzu;

import me.thundercaster.spinjitzu.Commands.SpinjitzuCommand;
import me.thundercaster.spinjitzu.events.spinevent;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

public final class Spinjitzu extends JavaPlugin {
    public List<Player> plist = new ArrayList<>();
    private static Spinjitzu plugin;
    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;

        getCommand("spinjitzu").setExecutor(new SpinjitzuCommand(this));
        getServer().getPluginManager().registerEvents(new spinevent(this), this);


    }

    public static Spinjitzu getPlugin() {
        return plugin;
    }
}
