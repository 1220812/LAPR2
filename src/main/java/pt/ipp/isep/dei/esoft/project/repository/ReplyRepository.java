package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.domain.SortingMethods.BubbleSort;
import pt.ipp.isep.dei.esoft.project.domain.SortingMethods.MergeSort;

import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

/**
 * The type Reply repository.
 */
public class ReplyRepository implements Serializable {
    private static final long serialVersionUID = -2164261031341973438L;
    /**
     * The Reply list.
     */
    static List<String> ReplyList;
    /**
     * The Reply complete list.
     */
    static List<String> ReplyCompleteList;

    /**
     * Instantiates a new Reply repository.
     */
    public ReplyRepository() {
        ReplyList = new ArrayList<>();
        ReplyCompleteList = new ArrayList<>();
    }

    /**
     * Add boolean.
     *
     * @param reply the reply
     * @return the boolean
     */
    public static boolean add(String reply) {
        if (reply == null) throw new IllegalArgumentException("Impossible reply");
        if (ReplyList.contains(reply)) throw new IllegalArgumentException("Reply already exists");
        return ReplyList.add(reply);
    }

    /**
     * Add complete boolean.
     *
     * @param reply the reply
     * @return the boolean
     */
    public static boolean addComplete(String reply) {
        return ReplyCompleteList.add(reply);
    }

    /**
     * Gets reply list.
     *
     * @return the reply list
     */
    public static List<String> getReplyList() {
        return ReplyList;
    }


    /**
     * Remove reply string.
     *
     * @param reply the reply
     * @return the string
     */
    public static String removeReply(String reply) {
        getReplyList().remove(reply);
        return reply;
    }

    /**
     * The Final list.
     */
    List<String> finalList = new ArrayList<>();




}