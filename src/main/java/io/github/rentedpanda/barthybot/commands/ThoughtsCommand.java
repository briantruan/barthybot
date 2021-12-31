package io.github.rentedpanda.barthybot.commands;

import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Random;

public class ThoughtsCommand extends ListenerAdapter {
    @Override
    public void onSlashCommand(SlashCommandEvent event) {
        if (event.getName().equalsIgnoreCase("thoughts")) {
            final int MAX_CASES = 7;
            int indexOfThought = getRandomInt(0, MAX_CASES);
            String thought = getThought(indexOfThought);
            event.reply(thought).queue();
        }
    }

    private String getThought(int index) {
        assert(0 <= index && index <= 7);
        return switch (index) {
            case 0 -> "real.";
            case 1 -> "pain.";
            case 2 -> "balls.";
            case 3 -> "balls in my face.";
            case 4 -> "not right.";
            case 5 -> "isn't that special?";
            case 6 -> "SQUID GAME";
            case 7 -> "ey. ey. ey.";
            default -> "nein.";
        };
    }

    private int getRandomInt(int min, int max) {
        assert(min < max);
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}
