package io.github.rentedpanda.barthybot.commands;

import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Random;

public class ThoughtsCommand extends ListenerAdapter {
    private final int MAX_CASES = 8;

    @Override
    public void onSlashCommand(SlashCommandEvent event) {
        if (event.getName().equalsIgnoreCase("thoughts")) {
            int indexOfThought = getRandomInt(0, MAX_CASES);
            String thought = getThought(indexOfThought);
            event.reply(thought).queue();
        }
    }

    private String getThought(int index) {
        assert (0 <= index && index <= MAX_CASES);
        switch (index) {
            case 0:
                return "real";
            case 1:
                return "pain.";
            case 2:
                return "balls.";
            case 3:
                return "balls in my face.";
            case 4:
                return "not right.";
            case 5:
                return "isn't that special?";
            case 6:
                return "SQUID GAME";
            case 7:
                return "ey. ey. ey.";
            default:
                return "nein.";
        }
    }

    private int getRandomInt(int min, int max) {
        assert (min < max);
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}
