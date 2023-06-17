package pt.ipp.isep.dei.esoft.project.domain.SortingMethods;

import pt.ipp.isep.dei.esoft.project.domain.Message;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MergeSort implements Serializable {
    int m;
    int l;
    int r;
    int n1 = m - l + 1;
    int n2 = r - m;
    int i = 0, j = 0, k = l;

public List<Message> merge(List<Message> messageList){
    List<Message> tempList = new ArrayList<>(messageList); // Criar uma nova lista temporária
    List<Message> tempList1 = new ArrayList<>(messageList); // Criar uma nova lista temporária


    while(i<n1 &&j<n2){
        if (tempList.get(i).getNewVisitStartTime().isBefore(tempList1.get(j).getNewVisitStartTime())) {
            messageList.set(k, tempList.get(i));
            i++;
        } else {
            messageList.set(k, tempList1.get(j));
            j++;
        }
        k++;
    }

    while(i<n1)

    {
        messageList.set(k, tempList.get(i));
        i++;
        k++;
    }

    while(j<n2)

    {
        messageList.set(k, tempList1.get(j));
        j++;
        k++;
    }

    return messageList;
}

    public List<Message> mergeSort(List<Message> messageList) {
        if (l < r) {
            int m = l + (r - l) / 2;

            // Sort first and second halves
            mergeSort(messageList);
            mergeSort(messageList);

            merge(messageList);
        }
        return messageList;
    }


}
