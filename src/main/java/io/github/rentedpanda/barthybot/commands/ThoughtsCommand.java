package io.github.rentedpanda.barthybot.commands;

import com.google.gson.Gson;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.io.*;
import java.util.Random;

public class ThoughtsCommand extends ListenerAdapter {
    @Override
    public void onSlashCommand(SlashCommandEvent event) {
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
        InputStream inputStream = getFileFromResourceAsStream("thoughts.json");
        Reader thoughtsJson = new InputStreamReader(inputStream);
        String[] thoughts = gson.fromJson(thoughtsJson, String[].class);
        int index = getRandomInt(0, thoughts.length - 1);
        return thoughts[index];
    }

    // imported from https://mkyong.com/java/java-read-a-file-from-resources-folder/

    private InputStream getFileFromResourceAsStream(String fileName) {
        // The class loader that loaded the class
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        // the stream holding the file content
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }
    }

    private int getRandomInt(int min, int max) {
        assert (min < max);
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}
