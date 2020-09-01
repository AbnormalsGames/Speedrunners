package me.jaackson.speedrunners.game.manager;

import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.Team;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.text.TextFormatting;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class TeamManager {

    private static final Logger LOGGER = LogManager.getLogger();

    public static void initTeams(MinecraftServer server) {
        Scoreboard scoreboard = server.getScoreboard();

        for(Team type : Team.values()) {
            if(!scoreboard.getTeamNames().contains(type.getString())) {
                ScorePlayerTeam team = scoreboard.createTeam(type.getString());
                team.setColor(type.getColor());
                LOGGER.debug("Created team " + team);
            }
        }
    }

    public enum Team implements IStringSerializable {
        DEAD("dead", "Dead", TextFormatting.GRAY),
        RUNNER("runner", "Runner", TextFormatting.AQUA),
        HUNTER("hunter", "Hunter", TextFormatting.RED);

        private final String id;
        private final String name;
        private final TextFormatting color;

        Team(String id, String name, TextFormatting color) {
            this.id = id;
            this.name = name;
            this.color = color;
        }

        @Override
        public String getString() {
            return id;
        }

        public String getName() {
            return id;
        }

        public TextFormatting getColor() {
            return color;
        }
    }
}
