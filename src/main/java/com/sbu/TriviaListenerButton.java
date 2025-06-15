package com.sbu;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class TriviaListenerButton implements Listener {

    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {
        if(event.getAction()== Action.RIGHT_CLICK_BLOCK){
            Player player = event.getPlayer();
            World world = player.getWorld();
            Block button = event.getClickedBlock();
            if(button.getBlockData().getMaterial() == Material.MANGROVE_BUTTON){
                Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(),"answer "+player.getDisplayName());
            }
        }
        return;
    }

}
