package com.project.history.domain.service;

import com.project.history.domain.domain.dto.UserRequestDto;
import com.project.history.domain.domain.entity.User;
import com.project.history.domain.exception.UserAlreadyExistsException;
import com.project.history.domain.repository.UserRepo;
import com.project.history.global.check.RankCheck;
import com.project.history.global.sort.PointComparator;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RankingServiceImpl implements RankingService{

    public static final Logger log = LoggerFactory.getLogger(RankingServiceImpl.class);
    private final UserRepo repo;

    @Override
    public void save(UserRequestDto user) {

        repo.findByName(user.getName()).ifPresent(m -> {
            throw UserAlreadyExistsException.EXCEPTION;
        });

        String userName = user.getName();

        System.out.println(userName.substring(0, userName.length() - 1));

        User saveUser = User.builder()
                .rank(0)
                .name(userName.substring(0, userName.length() - 1))
                .point(user.getPoint())
                .build();

        repo.save(saveUser);

        log.info("Save Success!! ");

        new RankCheck(repo);
    }

    @Override
    public List<User> findAll() {
        List<User> ranking = repo.findAll();

        ranking.sort(new PointComparator().reversed());

        log.info("Find Success!!");

        return ranking;
    }

}
