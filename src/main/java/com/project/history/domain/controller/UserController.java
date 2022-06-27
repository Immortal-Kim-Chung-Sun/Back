package com.project.history.domain.controller;

import com.project.history.domain.domain.dto.UserRequestDto;
import com.project.history.domain.domain.entity.User;
import com.project.history.domain.service.RankingServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final RankingServiceImpl rankingService;

    @PostMapping("/user/save")
    public void saveUser(
            @RequestBody Map<String, String> map
    ) {
        UserRequestDto dto = UserRequestDto.builder()
                        .name(map.get("name"))
                        .point(Long.valueOf(map.get("point")))
                        .build();

        rankingService.save(dto);

    }

    @RequestMapping(value = "/all/rank", method = RequestMethod.GET)
    public List<User> userRank() {
        return rankingService.findAll();
    }

}
