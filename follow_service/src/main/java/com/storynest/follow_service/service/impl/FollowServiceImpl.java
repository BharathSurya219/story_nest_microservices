package com.storynest.follow_service.service.impl;

import com.storynest.follow_service.dto.FollowerResponse;
import com.storynest.follow_service.service.FollowService;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class FollowServiceImpl implements FollowService {

    /**
     * @param followerId
     * @param followingId
     * @return
     */
    @Override
    public ResponseEntity<?> followUser(Long followerId, Long followingId) {
        return null;
    }

    /**
     * @param followerId
     * @param followingId
     * @return
     */
    @Override
    public ResponseEntity<?> unFollowUser(Long followerId, Long followingId) {
        return null;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public List<FollowerResponse> getFollowers(Long id) {
        return List.of();
    }

    /**
     * @param id
     * @return
     */
    @Override
    public List<FollowerResponse> getFollowing(Long id) {
        return List.of();
    }
}
