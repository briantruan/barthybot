package io.github.rentedpanda.barthybot.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class HeHeHeHawCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getName().equalsIgnoreCase("hehehehaw")) {
            event.reply("https://www.youtube.com/watch?v=7XIiIktFNRE").queue();
        }
    }
}
