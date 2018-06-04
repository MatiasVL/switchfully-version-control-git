package set_map_comparators.codelab06;

import java.util.List;
import java.util.Map;

public class UserApplication {

    private static final int AMOUNT_OF_USERS_TO_GENERATE = 4988877;

    public static void main(String[] args) {

        System.out.println("Filling up the list and map, this may take up to a few seconds...");
        List<User> userList = UserGenerator.generateUserList(AMOUNT_OF_USERS_TO_GENERATE);
        Map<Integer, User> userMap = UserGenerator.generateUserMap(AMOUNT_OF_USERS_TO_GENERATE);

        System.out.println("Okay, ready. Now, let's search!");

        User userToFind = userList.get(AMOUNT_OF_USERS_TO_GENERATE - 50);

        PerformanceMonitor performanceMonitor = new PerformanceMonitor(new UserSearcher());
        performanceMonitor.searchUserInList(userList, userToFind);
        performanceMonitor.searchUserInMap(userMap, userToFind);

    }

}
