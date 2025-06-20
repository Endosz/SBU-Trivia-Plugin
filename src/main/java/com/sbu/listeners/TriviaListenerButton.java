package com.sbu.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class TriviaListenerButton implements Listener {

    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {
        if(event.getAction()== Action.RIGHT_CLICK_BLOCK){
            Player player = event.getPlayer();
            Block button = event.getClickedBlock();
            if(button.getBlockData().getMaterial() == Material.MANGROVE_BUTTON){
                Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(),"answer "+player.getDisplayName());
            }
        }
        return;
    }

}
