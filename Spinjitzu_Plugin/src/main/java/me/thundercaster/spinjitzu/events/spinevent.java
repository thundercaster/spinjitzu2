package me.thundercaster.spinjitzu.events;

import me.thundercaster.spinjitzu.Spinjitzu;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class spinevent implements Listener {
    Spinjitzu plugin;

    public spinevent(Spinjitzu plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void Move(PlayerMoveEvent e){
        Player p = e.getPlayer();
        Location loc = p.getLocation();
        float k = (float) loc.getY();
        while (plugin.plist.contains(p)){
            for (int i = 0; i<6; i++){
                float y = (float) (0.5*i);
                float r = (float) (0.5*i);
                circle(r,k+y,loc,p);

            }



        }




    }




    public void circle(float r, double y, Location l, Player p){
        final double[] a = {0};
        new BukkitRunnable(){
            @Override
            public void run() {
                double x = r*Math.cos(a[0]);
                double z = r*Math.sin(a[0]);
                p.spawnParticle(Particle.DRIP_LAVA, l.add(x,y,z), 50);
                l.subtract(x,y,z);
                a[0] = a[0] + 0.1;

            }
        }.runTaskTimerAsynchronously(Spinjitzu.getPlugin(), 0, 1L);
    }
}
