/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author JoonaHa
 */
public class StatisticsTest {

    Statistics statistics;

    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    @Before
    public void setUp() {
        statistics = new Statistics(readerStub);
    }

    @Test
    public void searchReturnsRightPlayer() {
        Player result = statistics.search("Gretzky");

        assertEquals("Gretzky", result.getName());

    }

    @Test
    public void searchRetrunsNullIfNotFound() {
        assertEquals(null, statistics.search("abc"));
    }

    @Test
    public void teamReturnsWholeTeam() {
        List<Player> results = statistics.team("EDM");
        assertEquals(3, results.size());
    }

    @Test
    public void teamReturnsEmptyTeamIfNotFound() {
        List<Player> results = statistics.team("ABC");
        assertEquals(0, results.size());
    }

    @Test
    public void topScoresReturnsInorder() {
        List<Player> compare = readerStub.getPlayers();
        Collections.sort(compare);
        List<Player> results = statistics.topScorers(5);

        for (int i = 0; i < results.size(); i++) {
            assertEquals(compare.get(i).getName(), results.get(i).getName());

        }
    }

    @Test
    public void topScoresReturnsRightAmount() {
        List<Player> results = statistics.topScorers(2);
        assertEquals(2, results.size());

    }

    @Test
    public void topScoresDoesNotGoOutOfBounds() {
        List<Player> results = statistics.topScorers(7);
        assertEquals(5, results.size());

    }

    @Test
    public void topScoresReturnEmptyWhenArgumentNegative() {
        List<Player> results = statistics.topScorers(-1);
        assertEquals(0, results.size());

    }

}
