package com.sbu;

import com.sbu.commands.*;
import com.sbu.listeners.TriviaListenerButton;
import com.sbu.listeners.TriviaListenerChat;
import org.bukkit.plugin.java.JavaPlugin;
public class SBUTrivia extends JavaPlugin{
    private int questionAnswerTime = 10;
    @Override
    public void onEnable() {
        getLogger().info("SBU trivia plugin enabled!");;
        getServer().getPluginManager().registerEvents(new TriviaListenerButton(),this);
        getServer().getPluginManager().registerEvents(new TriviaListenerChat(),this);
        this.getCommand("answer").setExecutor(new TriviaAnswer(this));
        this.getCommand("triviaInitialize").setExecutor(new TriviaInitialize());
        this.getCommand("triviaEnd").setExecutor(new TriviaEnd());
        this.getCommand("triviaAddLife").setExecutor(new TriviaAddLife());
        this.getCommand("triviaRemoveLife").setExecutor(new TriviaRemoveLife());
        this.getCommand("triviaSetAnswerTime").setExecutor(new TriviaSetAnswerTime(this));
    }

    @Override
    public void onDisable() {
        getLogger().info("SBU trivia plugin disabled!");
    }

    public int getQuestionAnswerTime() {
        return questionAnswerTime;
    }

    public void setQuestionAnswerTime(int questionAnswerTime) {
        this.questionAnswerTime = questionAnswerTime;
    }
}
