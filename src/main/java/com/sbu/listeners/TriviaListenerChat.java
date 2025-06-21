package com.sbu.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class TriviaListenerChat implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        String message = event.getMessage();
        Player player = event.getPlayer();
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        Team team = scoreboard.getTeam("answering");
        if(team==null){
            return;
        }
        if(player.isOp()){
            event.setFormat(ChatColor.DARK_RED+player.getDisplayName()+ChatColor.RED+": "+message);
            return;
        }
        if(!team.hasEntry(player.getName())){
            event.setCancelled(true);
        }else{
            event.setFormat(team.getColor()+player.getDisplayName()+ChatColor.RESET+": "+message);
        }

    }
}
