package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Localization;
import pt.ipp.isep.dei.esoft.project.domain.Store;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Store repository.
 */
public class StoreRepository {
    private static List<String> store=new ArrayList<String>(){{
        add("1. store1");
        add("2. store2");
        add("3. store3");
        add("4. store5");
        add("5. store5");
    }
    };

    /**
     * Get stores.
     */
    public static void getStores(){
        for (String item : store){
            System.out.println(item);
        }
    }
    public class StoreRepository {
        private List<Store> storeList;
        public StoreRepository() {
            storeList = new ArrayList<>();
        }
        public List<Store> getStoreList() {
            return storeList;
        }
        public void registerStore(Store store) {
            if(validateStore(store)) {
                storeList.add(store);
            }else{
                throw new IllegalArgumentException ("Invalid Store");
            }
        }

        public Store createStore(String designation,String location, int ID, String phoneNumber, String emailAddress, Localization localization) {
            Store store = new Store (designation,location,ID,phoneNumber, emailAddress, localization);
            registerStore(store);
            return store;
        }

        public boolean validateStore (Store store) {
            if (this.storeList.contains(store)){
                return false;
            }
            for (Store storeB : this.storeList){
                if(storeB.equals(store)){
                    return false;
                }
            }
            return true;
        }
    }
}