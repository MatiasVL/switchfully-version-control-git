package code_example02_all_tests;

import code_example02_all_tests.domain.User;
import code_example02_all_tests.domain.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * A classic example of a UnitTest with Mocking
 * UserService has a dependency on UserRepository, however, since we're unit-testing UserService, we don't want to be
 * dependent on UserRepository. As far as we care, UserRepository can be completely broken or unimplemented.
 * Therefore, we need mocking. We need to mock the behavior of UserRepository. We use the Mockito for this.
 * - Maybe, afterwards, throw away all the implementation code of UserRepository, simply leave its methods. See how
 * - this test will keep working, and how the UserServiceIntegrationTest will start failing!
 */
class UserServiceTest {

    @Test
    void addUser_happyPath() {
        // We provide our UserService instance with a mock instance of UserRepository, not an actual instance.
        UserRepository userRepositoryMock = Mockito.mock(UserRepository.class);
        UserService userService = new UserService(userRepositoryMock);
        User userToAdd = new User("Timmy");

        userService.addUser(userToAdd);

        // We test, assert that our addUser method of UserService, calls the add method of UserRepository.
        // If that's the case, the test will succeed. The verify method of Mockito will actually perform an assert.
        Mockito.verify(userRepositoryMock).add(userToAdd);
    }

    @Test
    void getUser_happyPath() {
        // We provide our UserService instance with a mock instance of UserRepository, not an actual instance.
        UserRepository userRepositoryMock = Mockito.mock(UserRepository.class);
        UserService userService = new UserService(userRepositoryMock);
        UUID userId = UUID.randomUUID();

        // We here say that IF the getForId method on UserRepository is called, it should simply return the given user
        User expectedUser = new User("TestUser12");
        Mockito.when(userRepositoryMock.getForId(userId))
                .thenReturn(expectedUser);

        User actualUser = userService.getUser(UUID.randomUUID());

        // We assert that the getUser method UserService simply returns the user it gets from the UserRepository (getForId)
        Assertions.assertThat(actualUser).isEqualTo(expectedUser);
    }

    @Test
    void getUsersSortedOnNicknameAsc_happyPath() {
        // We provide our UserService instance with a mock instance of UserRepository, not an actual instance.
        UserRepository userRepositoryMock = Mockito.mock(UserRepository.class);
        UserService userService = new UserService(userRepositoryMock);

        User userDizzy = new User("Dizzy");
        User userAnnabel = new User("Annabel");
        User userBoriz = new User("Boriz");
        // We here say that IF the getAll method on UserRepository is called, it should return a list containing the given users
        Mockito.when(userRepositoryMock.getAll())
                .thenReturn(Arrays.asList(userDizzy, userAnnabel, userBoriz));

        List<User> sortedUsers = userService.getUsersSortedOnNicknameAsc();

        // We assert that all the users are returned in ascending order, sorted on nickname
        Assertions.assertThat(sortedUsers)
                .containsExactly(userAnnabel, userBoriz, userDizzy);
    }

}