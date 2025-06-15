package com.sbu;

import org.bukkit.plugin.java.JavaPlugin;
public class SBUTrivia extends JavaPlugin{
    @Override
    public void onEnable() {
        getLogger().info("SBU trivia plugin enabled!");;
        getServer().getPluginManager().registerEvents(new TriviaListenerButton(),this);
        getServer().getPluginManager().registerEvents(new TriviaListenerChat(),this);
        this.getCommand("answer").setExecutor(new TriviaAnswer(this));
        this.getCommand("triviaInitialize").setExecutor(new TriviaInitialize());
        this.getCommand("triviaEnd").setExecutor(new TriviaEnd());
    }

    @Override
    public void onDisable() {
        getLogger().info("SBU trivia plugin disabled!");
    }

}
