package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.repository.TicketRepository;
import ru.netology.ticket.Ticket;

public class TicketManagerTest {
    TicketRepository repository = new TicketRepository();
    TicketManager manager = new TicketManager(repository);
    Ticket ticket1 = new Ticket(1, 1000, "SVO", "LED", 45);
    Ticket ticket2 = new Ticket(2, 7500, "SVO", "ARH", 90);
    Ticket ticket3 = new Ticket(3, 15000, "SVO", "AER", 100);
    Ticket ticket4 = new Ticket(4, 6000, "SVO", "LED", 45);
    Ticket ticket5 = new Ticket(5, 3000, "SVO", "ARH", 90);
    Ticket ticket6 = new Ticket(6, 4000, "SVO", "LED", 45);
    Ticket ticket7 = new Ticket(7, 8900, "SVO", "OVB", 160);

    Ticket ticket8 = new Ticket(8, 2000, "SVO", "LED", 60);
    Ticket ticket9 = new Ticket(9, 7500, "SVO", "KRR", 60);
    Ticket ticket10 = new Ticket(10, 5000, "SVO", "LED", 60);
    Ticket ticket11 = new Ticket(11, 7500, "SVO", "KRR", 60);
    Ticket ticket12 = new Ticket(12, 7500, "SVO", "ARH", 90);


    @BeforeEach

    public void setup() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
        manager.add(ticket11);
        manager.add(ticket12);

    }

    @Test

    public void shouldSearch() {
        Ticket[] expected = {ticket1, ticket8, ticket6, ticket10, ticket4};
        Ticket[] actual = manager.searchBy("SVO", "LED");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldSearchSameCost() {
        Ticket[] expected = {ticket5, ticket2, ticket12};
        Ticket[] actual = manager.searchBy("SVO", "ARH");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldSearchOne() {
        Ticket[] expected = {ticket7};
        Ticket[] actual = manager.searchBy("SVO", "OVB");

        Assertions.assertArrayEquals(expected, actual);
    }

}
