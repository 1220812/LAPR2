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
     * Method that finds the closest partitions of stores with the closest number of announcements
     * @param organizations list of stores
     * @param numberOfStoresInThePartition number of stores to be divided
     */
    public static void findClosestPartitions(List<Store> organizations, int numberOfStoresInThePartition) {
        List<Store> storesList = new ArrayList<>();
        for (int i = 0; i < numberOfStoresInThePartition; i++) {
            storesList.add(organizations.get(i));
        }

        divideStores(storesList);
    }
    /**
     * Method that divides the stores into two subsets with the closest number of ads
     * @param storeList list of stores
     */
    public static void divideStores(List<Store> storeList) {
        int n = storeList.size();

        List<Store> subset1 = new ArrayList<>();
        List<Store> subset2 = new ArrayList<>();
        int totalAdsSubset1 = 0;
        int totalAdsSubset2 = 0;

        long startTime = System.nanoTime(); // Measure start time

        // Generate all possible subsets and find the one with the closest number of ads
        int closestDifference = Integer.MAX_VALUE;
        int subsetSize = (int) Math.pow(2, n);
        for (int i = 0; i < subsetSize; i++) {
            int currentSubsetSum = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    // currentSubsetSum += storeList.get(j).getTotalAdsCount();
                }
            }

            int difference = Math.abs(currentSubsetSum - (getAnnouncements() - currentSubsetSum));
            if (difference < closestDifference) {
                closestDifference = difference;
                subset1.clear();
                subset2.clear();

                for (int j = 0; j < n; j++) {
                    if ((i & (1 << j)) != 0) {
                        subset1.add(storeList.get(j));
                        int storeID = storeList.get(j).getID();

                        totalAdsSubset1 += getAnnouncementsByStoreID(storeID).size();
                    } else {
                        subset2.add(storeList.get(j));
                        int storeID = storeList.get(j).getID();
                        totalAdsSubset2 += getAnnouncementsByStoreID(storeID).size();
                    }
                }
            }
        }

        long endTime = System.nanoTime();

        System.out.println("List: " + storeList);
        System.out.println("Subset1: " + subset1);
        System.out.println("Subset2: " + subset2);
        System.out.println("Difference: " + closestDifference);

        double executionTime = (endTime - startTime) / 1_000_000_000.0;
        System.out.printf("Time: %.15f seconds%n", executionTime);

    }

    /**
     * Method that returns the total number of announcements in the system
     * @return total number of announcements in the system
     */
    private static int getAnnouncements() {
        int totalAnnouncements = 0;
        AnnouncementRepository announcementRepository = Repositories.getInstance().getAnnouncementRepository();
        totalAnnouncements += announcementRepository.getAnnouncementsList().size();
        return totalAnnouncements;
    }
    /**
     * Method that returns the list of announcements by store
     * @param storeID store ID
     * return list of announcements by store
     */
    private static List<Announcement> getAnnouncementsByStoreID(int storeID) {
        List<Announcement> announcements = new ArrayList<>();
        for (Announcement announcement : announcements) {
            if (announcement.getStore().getID() == storeID) {
                announcements.add(announcement);
            }
        }
        return announcements;
    }
}
