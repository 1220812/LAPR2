package pt.ipp.isep.dei.esoft.project.domain.SortingMethods;

import pt.ipp.isep.dei.esoft.project.domain.Request;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    int m;
    int l;
    int r;
    int n1 = m - l + 1;
    int n2 = r - m;
    int i = 0, j = 0, k = l;

public List<Request> merge(List<Request> requestList){
    List<Request> tempList = new ArrayList<>(requestList); // Criar uma nova lista temporária
    List<Request> tempList1 = new ArrayList<>(requestList); // Criar uma nova lista temporária


    while(i<n1 &&j<n2){
        if (tempList.get(i).getRequestDate().isBefore(tempList1.get(j).getRequestDate())) {
            requestList.set(k, tempList.get(i));
            i++;
        } else {
            requestList.set(k, tempList1.get(j));
            j++;
        }
        k++;
    }

    while(i<n1)

    {
        requestList.set(k, tempList.get(i));
        i++;
        k++;
    }

    while(j<n2)

    {
        requestList.set(k, tempList1.get(j));
        j++;
        k++;
    }

    return requestList;
}

    public List<Request> mergeSort(List<Request> requestList) {
        if (l < r) {
            int m = l + (r - l) / 2;

            // Sort first and second halves
            mergeSort(requestList);
            mergeSort(requestList);

            merge(requestList);
        }
        return requestList;
    }


}
