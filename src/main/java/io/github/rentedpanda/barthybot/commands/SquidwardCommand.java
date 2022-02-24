package io.github.rentedpanda.barthybot.commands;

import io.github.rentedpanda.barthybot.util.FileUtil;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class SquidwardCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getName().equalsIgnoreCase("squidward")) {
            InputStream imageInputStream = new FileUtil().getFileFromResourceAsStream("memes" +
                    "/4.png");
            try {
                BufferedImage image = ImageIO.read(imageInputStream);
                File temp = new File("tmp.png");
                ImageIO.write(image, "png", temp);
                event.getChannel().sendFile(temp).queue();
                temp.delete();
                event.reply("squid game").queue();
            } catch (IOException e) {
                e.printStackTrace();
                event.reply("Squid game?").queue();
            }
        }
    }
}
