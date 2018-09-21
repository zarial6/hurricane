package com.hurricane.mindmap.service;

import com.hurricane.mindmap.converter.UserDtoToEntityConverter;
import com.hurricane.mindmap.dto.UserDto;
import com.hurricane.mindmap.model.User;
import com.hurricane.mindmap.repository.UserRepository;
import com.hurricane.mindmap.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Mono;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

/**
 * @author Oleg Zhymolokhov (oleg.zhimolokhov@dataart.com)
 */
public class UserServiceTest {

    private final UserDtoToEntityConverter converter;

    @Mock
    UserRepository userRepository;

    UserService userService;

    public UserServiceTest() {
        this.converter = new UserDtoToEntityConverter();
    }

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        userService = new UserServiceImpl(userRepository, converter);
    }

    @Test
    public void testCreate() {
        Mono<User> user = Mono.just(User.builder().firstName("Test").build());
        //given
        given(userRepository.insert(any(User.class))).willReturn(user);

        Mono<UserDto> userToSave = Mono.just(UserDto.builder().firstName("Test").build());

        //when
        userService.create(userToSave).block();

        //then
        then(userRepository).should(times(1)).insert(any(User.class));
    }

}
