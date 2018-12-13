class QuickSort {

    public void quickSort(Song arr[], int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);
            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private int partition(Song arr[], int begin, int end) {
        int pivot = arr[end].likes;
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j].likes <= pivot) {
                i++;

                Song swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        Song swapTemp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = swapTemp;

        return i + 1;
    }
}