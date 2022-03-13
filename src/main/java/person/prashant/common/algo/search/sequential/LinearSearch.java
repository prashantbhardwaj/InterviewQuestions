package person.prashant.common.algo.search.sequential;

public class LinearSearch {
    public static void main(String[] args) {

    }

    private int findIndexOfGivenValue(int[] values, int value){
        if(values == null || values.length == 0){
            return -1;
        }

        for(int i = 0; i < values.length; i++){
            if(values[i] == value){
                return i;
            }
        }
        return -1;
    }
}
