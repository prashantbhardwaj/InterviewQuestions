package person.prashant.common.algo.search.interval;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(searchInSorted(arr, 8, 2));
    }

    static int searchInSorted(int arr[], int N, int K)
    {

        // Your code here
        if(N == 0){
            return -1;
        }
        return searchInSorted(arr, 0,  arr.length - 1, K);

    }

    static int searchInSorted(int arr[], int start, int end, int value) {
        if(start == end ){
            return arr[start] == value ? start : -1;
        }

        if(start < end){

            int half = start + (end - start)/2; // half = (start + end)/2

            if(arr[half] == value){
                return half;
            }

            if(arr[half] > value){
                return searchInSorted(arr, start, half - 1, value);
            }

            if(arr[half] < value){
                return searchInSorted(arr, half + 1, end, value);
            }
        }


        return -1;
    }
}
