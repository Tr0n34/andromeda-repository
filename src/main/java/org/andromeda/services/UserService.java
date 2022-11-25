package org.andromeda.services;

import org.andromeda.mappers.UserMapper;
import org.andromeda.models.User;
import org.andromeda.respositories.UserRepository;
import org.andromeda.respositories.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private UserRepository userRepository;
    private EncryptionService encryptionService;

    @Autowired
    public UserService(UserRepository userRepository, EncryptionService encryptionService) {
        this.userRepository = userRepository;
        this.encryptionService = encryptionService;
    }

    public User subscribe(User user) {
        UserDto userToSave = UserMapper.INSTANCE.userToUserDto(user);
        logger.debug("userToSave={}", userToSave.toString());
        return UserMapper.INSTANCE.userDtoToUser(this.userRepository.save(userToSave));
    }

    public User unsubscribe(User user) {
        return null;
    }

    public List<User> findUsers(User user) {
        return null;
    }


}
