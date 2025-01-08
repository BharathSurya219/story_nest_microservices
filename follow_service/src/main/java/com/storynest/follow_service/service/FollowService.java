package com.storynest.follow_service.service;

import com.storynest.follow_service.dto.FollowerResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FollowService {
    ResponseEntity<?> followUser(Long followerId, Long followingId);
    ResponseEntity<?> unFollowUser(Long followerId, Long followingId);
    List<FollowerResponse> getFollowers(Long id);
    List<FollowerResponse> getFollowing(Long id);

}
