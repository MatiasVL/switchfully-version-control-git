package set_map_comparators.codelab06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class UserGenerator {

    private static final String[] LASTNAMES = {"Smith", "Johnson", "Williams", "Brown", "Wilson", "Lopez"};
    private static final String[] FIRSTNAME = {"John", "Ben", "Steve", "Sandra", "Hannah", "Becky"};
    
    static List<User> generateUserList(int amountOfUsers) {
        User.resetCounter();
        List<User> userList = new ArrayList<>();
        for(int index = 0; index < amountOfUsers; index++) {
            userList.add(createNewUser());
        }
        return userList;
    }

    static Map<Integer, User> generateUserMap(int amountOfUsers) {
        User.resetCounter();
        Map<Integer, User> userMap = new HashMap<>();
        for(int index = 0; index < amountOfUsers; index++) {
            User newUser = createNewUser();
            userMap.put(newUser.getId(), newUser);
        }
        return userMap;
    }

    private static User createNewUser() {
        return new User(LASTNAMES[getRandomIndexWithUpperBound(6)],
                FIRSTNAME[getRandomIndexWithUpperBound(6)]);
    }

    private static int getRandomIndexWithUpperBound(int upperBound) {
        return (int)(Math.random() * upperBound);
    }
}
