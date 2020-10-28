package domain;

import manager.TicketInfoManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.TicketInfoRepository;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class TicketInfoTest {
    TicketInfoRepository repository = new TicketInfoRepository();
    TicketInfoManager manager = new TicketInfoManager(repository);
    TicketByTimeAscComparator comparator = new TicketByTimeAscComparator();

    TicketInfo one = new TicketInfo(1, 8000, null, null, 180);
    TicketInfo two = new TicketInfo(2, 15000, "SVO", "TSE", 180);
    TicketInfo three = new TicketInfo(3, 7000, "LCA", "DME", 220);
    TicketInfo four = new TicketInfo(4, 5000, "SVO", "TSE", 200);
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
        TicketInfo[] expected = new TicketInfo[]{two, four};
        TicketInfo[] actual = manager.findAll("SVO", "TSE", comparator);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void sortOneSuitableTrip() {
        TicketInfo[] expected = new TicketInfo[]{three, five};
        TicketInfo[] actual = manager.findAll("LCA", "DME", comparator);
        assertArrayEquals(expected, actual);
    }


}