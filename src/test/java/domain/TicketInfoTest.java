package domain;

import manager.TicketInfoManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.TicketInfoRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TicketInfoTest {
    TicketInfoRepository repository = new TicketInfoRepository();
    TicketInfoManager manager = new TicketInfoManager(repository);
    TicketInfo one = new TicketInfo(1, 8000, null, null, 180);
    TicketInfo two = new TicketInfo(2, 15000, "SVO", "TSE", 180);
    TicketInfo three = new TicketInfo(3, 7000, "LCA", null, 200);
    TicketInfo four = new TicketInfo(4, 5000, "SVO", "TSE", 180);
    TicketInfo five = new TicketInfo(5, 10000, "LCA", "DME", 220);

    @BeforeEach
    public void setUp() {
        repository.add(one);
        repository.add(two);
        repository.add(three);
        repository.add(four);
        repository.add(five);
    }

    @Test
    public void sortSuitableTrips() {
        TicketInfo[] expected = new TicketInfo[]{four, two};
        TicketInfo[] actual = manager.findAll("SVO", "TSE");
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void sortOneSuitableTrip() {
        TicketInfo[] expected = new TicketInfo[]{five};
        TicketInfo[] actual = manager.findAll("LCA", "DME");
        Arrays.sort(actual); //можно не применять
        assertArrayEquals(expected, actual);
    }

    @Test
    public void noTrips() {
        TicketInfo[] expected = new TicketInfo[]{};
        TicketInfo[] actual = manager.findAll("SVO", "LCA");
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }
}