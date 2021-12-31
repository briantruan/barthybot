package io.github.rentedpanda.barthybot.commands;

import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class BoomCommand extends ListenerAdapter {
    @Override
    public void onSlashCommand(SlashCommandEvent event) {
        if (event.getName().equalsIgnoreCase("boom")) {
            event.reply("https://www.youtube.com/watch?v=_vBVGjFdwk4").queue();
        }
    }
}
