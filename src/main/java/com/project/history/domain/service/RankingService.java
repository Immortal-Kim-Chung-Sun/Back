package com.project.history.domain.service;

import com.project.history.domain.domain.dto.UserRequestDto;
import com.project.history.domain.domain.entity.User;

import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.List;

public interface RankingService {

    void save(UserRequestDto user) throws SocketException, UnknownHostException;
    List<User> findAll();

}
