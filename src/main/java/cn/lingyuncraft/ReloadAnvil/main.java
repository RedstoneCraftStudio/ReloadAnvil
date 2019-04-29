package cn.lingyuncraft.ReloadAnvil;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import static org.bukkit.Bukkit.broadcastMessage;
import static org.bukkit.Material.ANVIL;

public final class main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("铁砧自动还原插件加载成功!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("铁砧自动还原插件已卸载!");
    }
        public void onAnvilBreak(BlockPhysicsEvent e){
           new BukkitRunnable(){
                @Override
                public void run(){
                    Material TrueType = ANVIL;
                    World World = Bukkit.getWorld("world");
                     while(true){
                         Material Type = e.getChangedType();
                         World TrueWorld = e.getBlock().getWorld();
                          if (Type == TrueType & World ==TrueWorld ){
                                  e.getBlock().setType(TrueType);
                                 Bukkit.broadcastMessage("铁砧已被自动修复") ;
                                  
                          }
                     }
                 }
            }.run();
    }
}