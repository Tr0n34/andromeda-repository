package org.andromeda.respositories;

import org.andromeda.respositories.dto.UserDto;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;

public interface UserRepository extends CrudRepository<UserDto, Long> {

    public UserDto findByLogin(String login);

    public Iterable<UserDto> findByCreatedOn(LocalDate createdOn);

}
