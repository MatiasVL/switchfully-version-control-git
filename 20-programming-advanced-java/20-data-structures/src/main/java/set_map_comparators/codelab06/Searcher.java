package set_map_comparators.codelab06;

import java.util.List;
import java.util.Map;

public interface Searcher {

    User searchUserInList(List<User> userList, User userToSearch);
    User searchUserInMap(Map<Integer, User> userMap, User userToSearch);

}
