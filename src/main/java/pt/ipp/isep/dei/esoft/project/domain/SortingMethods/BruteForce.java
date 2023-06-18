package pt.ipp.isep.dei.esoft.project.domain.SortingMethods;

import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.Store;
import pt.ipp.isep.dei.esoft.project.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BruteForce implements Serializable {
    /**
     * This method divides the list of stores in two different subsets and finds the minimum difference between both
     *
     * @param storesList the list of stores
     */
    public void storesDivisor(List<Store> storesList) {
        int totalSubset1 = 0, totalSubset2 = 0, difference, minDifference, subsetSize;
        int sumOfAnnouncements = 0;
        int n = storesList.size();
        List<Store> subset1 = new ArrayList<>();
        List<Store> subset2 = new ArrayList<>();
        long startingTime, endingTime;
        double runTime;
        storesList = getStores(storesList, n);
        subsetSize = (int) Math.pow(2, n);
        minDifference = Integer.MAX_VALUE;
        startingTime = System.nanoTime();
        for (int i = 0; i < subsetSize; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    sumOfAnnouncements = getAnnouncementsByStoreID(storesList.get(j).getID()).size();
                    sum += sumOfAnnouncements;
                }
            }
            difference = Math.abs(sum - (getTotalNumberOfProperties(storesList) - sum));
            if (difference < minDifference) {
                minDifference = difference;
                subset1.clear();
                subset2.clear();
                for (int j = 0; j < n; j++) {
                    if ((i & (1 << j)) != 0) {
                        subset1.add(storesList.get(j));
                        totalSubset1 += getAnnouncementsByStoreID(storesList.get(j).getID()).size();
                    } else {
                        subset2.add(storesList.get(j));
                        getAnnouncementsByStoreID(storesList.get(j).getID());
                        totalSubset2 += getAnnouncementsByStoreID(storesList.get(j).getID()).size();
                    }
                }
            }
        }
        endingTime = System.nanoTime();
        System.out.printf("Stores list: " + storesList + ", Subset1: " + subset1 + ", Subset2: " + subset2 + ", Difference between the subsets: " + minDifference);
        runTime = (endingTime - startingTime) / 1000000000.0;
        System.out.printf(", run time: %.15f seconds%n", runTime);
    }

    /**
     * This method returns a list with the n first stores of the list of stores
     * @param stores the list of all stores
     * @param numberOfStores the number of stores to be returned
     * @return the list with the n first stores of the list of stores
     */
    public List<Store> getStores (List<Store> stores, int numberOfStores){
        List<Store> storesList = new ArrayList<>();
        for (int i = 0; i < numberOfStores; i++) {
            storesList.add(stores.get(i));
        }
        return storesList;
    }

    /**
     * This method returns the total number of properties of a list of stores
     * @param stores the list of stores
     * @return the total number of properties of a list of stores
     */
    public static int getTotalNumberOfProperties(List<Store> stores){
        int totalNumberOfProperties=0;
        for (Store store:stores) {
            List <Announcement> announcements = getAnnouncementsByStoreID(store.getID());
            for (int i = 0; i < announcements.size() ; i++) {
                totalNumberOfProperties++;
            }
        }
        return totalNumberOfProperties;
    }

    /**
     * This method returns a list of the announcements of a store
     * @param storeID the ID of the store
     * @return the list of the announcements of a store
     */
    public static List<Announcement> getAnnouncementsByStoreID(int storeID) {
        List<Announcement> announcements = Repositories.getInstance().getAnnouncementRepository().getAnnouncementsList();
        List<Announcement> matchingAnnouncements = new ArrayList<>();
        for (Announcement announcement : announcements) {
            if (announcement.getStore().getID() == storeID) {
                matchingAnnouncements.add(announcement);
            }
        }
        return matchingAnnouncements;
    }
}
