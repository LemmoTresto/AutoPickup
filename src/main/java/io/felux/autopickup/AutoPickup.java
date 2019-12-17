package io.felux.autopickup;

import io.felux.autopickup.listener.MineListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class AutoPickup extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new MineListener(), this);
    }
}
