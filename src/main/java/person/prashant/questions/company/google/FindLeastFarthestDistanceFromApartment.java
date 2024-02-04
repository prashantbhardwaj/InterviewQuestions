package person.prashant.questions.company.google;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class FindLeastFarthestDistanceFromApartment {

    private static Data findTheAnswer(Data[] input){
        Map<Data, Integer> unSortedTree = new HashMap<>();
        Map<Data, Integer> unCalculatedIndex = new ConcurrentHashMap<>();

        int shortestDistanceToGym = Integer.MAX_VALUE;
        int shortestDistanceToSchool = Integer.MAX_VALUE;
        int shortestDistanceToStore = Integer.MAX_VALUE;

        for (int i = 0; i < input.length; i++){

            unCalculatedIndex.put(input[i], i);

            if(input[i].gym) {shortestDistanceToGym = i;}
            if(input[i].school) {shortestDistanceToSchool = i;}
            if(input[i].store) {shortestDistanceToStore = i;}

            if(shortestDistanceToGym != Integer.MAX_VALUE &&
                    shortestDistanceToSchool != Integer.MAX_VALUE &&
                    shortestDistanceToStore != Integer.MAX_VALUE) {

                int finalShortestDistanceToGym = shortestDistanceToGym;
                int finalShortestDistanceToSchool = shortestDistanceToSchool;
                int finalShortestDistanceToStore = shortestDistanceToStore;
                unCalculatedIndex.entrySet().stream().forEach(entry -> {
                    int indexOfKey = entry.getValue();
                    int distanceToGym = Math.abs(finalShortestDistanceToGym - indexOfKey);
                    int distanceToSchool = Math.abs(finalShortestDistanceToSchool - indexOfKey);
                    int distanceToStore = Math.abs(finalShortestDistanceToStore - indexOfKey);

                    int distance = Integer.MAX_VALUE;
                    if(distanceToGym >= distanceToSchool && distanceToGym >= distanceToStore) {
                        distance = distanceToGym;
                    } else if(distanceToSchool >= distanceToStore) {
                        distance = distanceToSchool;
                    } else {
                        distance = distanceToStore;
                    }
                    unSortedTree.put(entry.getKey(), distance);
                    unCalculatedIndex.remove(entry.getKey());
                });
            }
        }
        return unSortedTree.entrySet().stream().sorted(Map.Entry.comparingByValue()).findFirst().get().getKey();
    }

    public static void main(String[] args) {
        Data[] input = {new Data(false, true, false),
        new Data(true, false, false),
        new Data(true, true, false),
        new Data(false, true, false),
        new Data(false, true, true)};
        Data answer = findTheAnswer(input);

        if(answer == input[3]){
            System.out.println("Right answer");
        } else {
            System.out.println("Wrong answer");
        }
    }

    private static class Data{
        final boolean gym;
        final boolean school;
        final boolean store;

        Data(boolean g, boolean sc, boolean st){
            this.gym = g;
            this.school = sc;
            this.store = st;
        }
    }
}


