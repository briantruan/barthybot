package io.github.rentedpanda.barthybot.commands;

import io.github.rentedpanda.barthybot.util.FileUtil;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public class MemeCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getName().equalsIgnoreCase("meme")) {
            InputStream imageInputStream = new FileUtil()
                            .getFileFromResourceAsStream("memes/" + getRandomInt(1, 5) +
                            ".png");
            try {
                BufferedImage image = ImageIO.read(imageInputStream);
                File temp = new File("tmp.png");
                ImageIO.write(image, "png", temp);
                event.getChannel().sendFile(temp).queue();
                event.reply("Meme delivered.").queue();
                temp.delete();
            } catch (IOException e) {
                e.printStackTrace();
                event.reply("No meme!").queue();
            }
        }
    }

    private int getRandomInt(int min, int max) {
        assert (min < max);
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}
