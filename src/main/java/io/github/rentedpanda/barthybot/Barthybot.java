package io.github.rentedpanda.barthybot;

import io.github.rentedpanda.barthybot.commands.BoomCommand;
import io.github.rentedpanda.barthybot.commands.RealCommand;
import io.github.rentedpanda.barthybot.commands.ThoughtsCommand;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;
import java.util.Collections;

public class Barthybot {
    private static final String BOT_TOKEN = "OTI2MjMxMzQ4NDgwNDQyMzk4.Yc4qKg.mAVMYeopepV259U2e-yun1pn7jk";

    public static void main(String[] arguments) throws LoginException {
        JDA api = JDABuilder.createLight(BOT_TOKEN, Collections.emptyList())
                .addEventListeners(new BoomCommand())
                .addEventListeners(new RealCommand())
                .addEventListeners(new ThoughtsCommand())
                .setActivity(Activity.playing("real."))
                .build();
        api.upsertCommand("boom", "BOOM").queue();
        api.upsertCommand("real", "real").queue();
        api.upsertCommand("thoughts", "What is Barthy thinking about?").queue();
    }
}
