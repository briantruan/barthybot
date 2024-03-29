package io.github.rentedpanda.barthybot;

import io.github.rentedpanda.barthybot.commands.*;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class Barthybot {
    private static final String BOT_TOKEN = System.getenv("BARTHYBOT_TOKEN");

    public static void main(String[] arguments) throws LoginException {
        JDA api = JDABuilder.createDefault(BOT_TOKEN)
                .addEventListeners(new BoomCommand())
                .addEventListeners(new HeHeHeHawCommand())
                .addEventListeners(new MemeCommand())
                .addEventListeners(new RealCommand())
                .addEventListeners(new SquidwardCommand())
                .addEventListeners(new ThoughtsCommand())
                .setActivity(Activity.playing("real."))
                .build();
        api.upsertCommand("boom", "BOOM").queue();
        api.upsertCommand("hehehehaw", "HE HE HE HAW").queue();
        api.upsertCommand("meme",
                "Acquire a meme from Barhty's fine selections").queue();
        api.upsertCommand("real", "real").queue();
        api.upsertCommand("squidward", "SQUID GAME").queue();
        api.upsertCommand("thoughts",
                "What is Barthy thinking about?").queue();
    }
}
