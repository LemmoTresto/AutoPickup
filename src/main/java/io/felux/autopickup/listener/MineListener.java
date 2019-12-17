package io.felux.autopickup.listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class MineListener implements Listener {

    @EventHandler(priority = EventPriority.LOW, ignoreCancelled = true)
    public void onMine(BlockBreakEvent e) {
        final Player p = e.getPlayer();

        if(!p.hasPermission("autopickup.use")) return;

        p.getInventory().addItem((ItemStack[]) e.getBlock().getDrops(p.getItemInHand()).toArray());
        e.getBlock().setType(Material.AIR);
    }
}
