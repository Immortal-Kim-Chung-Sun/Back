package com.project.history.global.check;

import com.project.history.domain.domain.entity.User;
import com.project.history.domain.repository.UserRepo;
import com.project.history.global.sort.PointComparator;

import java.util.List;

public class RankCheck {

    public RankCheck(UserRepo repo) {

        List<User> rankList = repo.findAll();

        User updateUser;

        rankList.sort(new PointComparator().reversed());

        for(int i = 0; i < rankList.size(); i++) {
            updateUser = User.builder()
                    .rank(i)
                    .name(rankList.get(i).getName())
                    .point(rankList.get(i).getPoint())
                    .build();

            repo.save(updateUser);
        }


    }

}
