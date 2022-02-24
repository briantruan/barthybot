package io.github.rentedpanda.barthybot.commands;

import com.google.gson.Gson;
import io.github.rentedpanda.barthybot.util.FileUtil;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.io.*;
import java.util.Random;

public class ThoughtsCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getName().equalsIgnoreCase("thoughts")) {
            String thought = "nein!";
            try {
                thought = getThought();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            event.reply(thought).queue();
        }
    }

    private String getThought() throws FileNotFoundException {
        Gson gson = new Gson();
        InputStream inputStream = new FileUtil().getFileFromResourceAsStream("thoughts.json");
        Reader thoughtsJson = new InputStreamReader(inputStream);
        String[] thoughts = gson.fromJson(thoughtsJson, String[].class);
        int index = getRandomInt(0, thoughts.length - 1);
        return thoughts[index];
    }

    private int getRandomInt(int min, int max) {
        assert (min < max);
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}
