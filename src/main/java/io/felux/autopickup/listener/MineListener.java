package io.felux.autopickup.listener;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class MineListener implements Listener {

    @EventHandler
    public void onMine(BlockBreakEvent e) {
        final Player p = e.getPlayer();
        final Block b = e.getBlock();
        final List<ItemStack> blockDrops = new ArrayList<>(b.getDrops());

        if(!p.hasPermission("autopickup.use")) return;
        blockDrops.forEach(drop -> p.getInventory().addItem(drop));
        b.setType(Material.AIR);
    }
}
