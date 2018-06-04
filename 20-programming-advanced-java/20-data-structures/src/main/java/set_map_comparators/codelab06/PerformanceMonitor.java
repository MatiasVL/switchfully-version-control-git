package set_map_comparators.codelab06;

import java.util.List;
import java.util.Map;

public class PerformanceMonitor implements Searcher{

    private UserSearcher userSearcher;

    public PerformanceMonitor(UserSearcher userSearcher) {
        this.userSearcher = userSearcher;
    }

    @Override
    public User searchUserInList(List<User> userList, User userToSearch) {
        long startTime = System.currentTimeMillis();
        User foundUser = userSearcher.searchUserInList(userList, userToSearch);
        System.out.println("Searching the List took " + getElapsedTime(startTime) + " milliseconds");
        return foundUser;
    }

    @Override
    public User searchUserInMap(Map<Integer, User> userMap, User userToSearch) {
        long startTime = System.currentTimeMillis();
        User foundUser = userSearcher.searchUserInMap(userMap, userToSearch);
        System.out.println("Searching the Map took " + getElapsedTime(startTime) + " milliseconds");
        return foundUser;
    }

    private double getElapsedTime(long startTime) {
        long endTime = System.currentTimeMillis();
        return (double) (endTime - startTime);
    }
}
