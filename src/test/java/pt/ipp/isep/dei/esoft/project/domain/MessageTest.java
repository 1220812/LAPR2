package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MessageTest {

    @Test
    public void testCheckIfValidVisit_NoOverlap_ReturnsFalse() {
        LocalDateTime startTime1 = LocalDateTime.of(2023, 6, 9, 10, 0);
        LocalDateTime endTime1 = LocalDateTime.of(2023, 6, 9, 12, 0);

        LocalDateTime startTime2 = LocalDateTime.of(2023, 6, 9, 14, 0);
        LocalDateTime endTime2 = LocalDateTime.of(2023, 6, 9, 16, 0);

        List<Message> messageList = new ArrayList<>();
        messageList.add(new Message(startTime1, endTime1));

        boolean result = Message.checkIfValidVisit(messageList, startTime2, endTime2);

        Assertions.assertFalse(result);
    }

    @Test
    public void testCheckIfValidVisit_Overlap_ReturnsTrue() {
        LocalDateTime startTime1 = LocalDateTime.of(2023, 6, 9, 10, 0);
        LocalDateTime endTime1 = LocalDateTime.of(2023, 6, 9, 12, 0);

        LocalDateTime startTime2 = LocalDateTime.of(2023, 6, 9, 11, 0);
        LocalDateTime endTime2 = LocalDateTime.of(2023, 6, 9, 13, 0);

        List<Message> messageList = new ArrayList<>();
        messageList.add(new Message(startTime1, endTime1));

        boolean result = Message.checkIfValidVisit(messageList, startTime2, endTime2);

        Assertions.assertTrue(result);
    }

    @Test
    public void testCheckIfValidVisit_OverlapWithMultipleVisits_ReturnsTrue() {
        LocalDateTime startTime1 = LocalDateTime.of(2023, 6, 9, 10, 0);
        LocalDateTime endTime1 = LocalDateTime.of(2023, 6, 9, 12, 0);

        LocalDateTime startTime2 = LocalDateTime.of(2023, 6, 9, 11, 0);
        LocalDateTime endTime2 = LocalDateTime.of(2023, 6, 9, 13, 0);

        LocalDateTime startTime3 = LocalDateTime.of(2023, 6, 9, 9, 0);
        LocalDateTime endTime3 = LocalDateTime.of(2023, 6, 9, 10, 30);

        List<Message> messageList = new ArrayList<>();
        messageList.add(new Message(startTime1, endTime1));
        messageList.add(new Message(startTime3, endTime3));

        boolean result = Message.checkIfValidVisit(messageList, startTime2, endTime2);

        Assertions.assertTrue(result);
    }

    @Test
    public void testCheckIfValidVisit_NoVisits_ReturnsFalse() {
        LocalDateTime startTime = LocalDateTime.of(2023, 6, 9, 10, 0);
        LocalDateTime endTime = LocalDateTime.of(2023, 6, 9, 12, 0);

        List<Message> messageList = new ArrayList<>();

        boolean result = Message.checkIfValidVisit(messageList, startTime, endTime);

        Assertions.assertFalse(result);
    }

    @Test
    public void testCheckIfValidVisit_ExistingVisitsWithSameTime_ReturnsTrue() {
        LocalDateTime startTime1 = LocalDateTime.of(2023, 6, 9, 10, 0);
        LocalDateTime endTime1 = LocalDateTime.of(2023, 6, 9, 12, 0);

        LocalDateTime startTime2 = LocalDateTime.of(2023, 6, 9, 10, 0);
        LocalDateTime endTime2 = LocalDateTime.of(2023, 6, 9, 12, 0);

        List<Message> messageList = new ArrayList<>();
        messageList.add(new Message(startTime1, endTime1));

        boolean result = Message.checkIfValidVisit(messageList, startTime2, endTime2);

        Assertions.assertTrue(result);
    }

    @Test
    public void testCheckIfValidVisit_ExistingVisitsWithDifferentTimes_ReturnsFalse() {
        LocalDateTime startTime1 = LocalDateTime.of(2023, 6, 9, 10, 0);
        LocalDateTime endTime1 = LocalDateTime.of(2023, 6, 9, 12, 0);

        LocalDateTime startTime2 = LocalDateTime.of(2023, 6, 9, 12, 30);
        LocalDateTime endTime2 = LocalDateTime.of(2023, 6, 9, 13, 0);

        List<Message> messageList = new ArrayList<>();
        messageList.add(new Message(startTime1, endTime1));

        boolean result = Message.checkIfValidVisit(messageList, startTime2, endTime2);

        Assertions.assertFalse(result);
    }
}