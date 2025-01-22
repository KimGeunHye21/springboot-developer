package me.kimgeunhye.springbootdeveloper.service;


import lombok.RequiredArgsConstructor;
import me.kimgeunhye.springbootdeveloper.config.jwt.TokenProvider;
import me.kimgeunhye.springbootdeveloper.domain.User;
import me.kimgeunhye.springbootdeveloper.repository.RefreshTokenRepository;
import org.springframework.stereotype.Service;

import java.time.Duration;

@RequiredArgsConstructor
@Service
public class TokenService {

    private final TokenProvider tokenProvider;
    private final RefreshTokenService refreshTokenService;
    private final UserService userService;

    public String createNewAccessToken(String refreshToken) {

        // 토큰 유효성 검사에 실패하면 예외발생
        if (!tokenProvider.validToken(refreshToken)) {
            throw new IllegalArgumentException("Unexpected token");
        }

        Long userId = refreshTokenService.findByRefreshToken(refreshToken).getUserId();
        User user = userService.findById(userId);

        return tokenProvider.generateToken(user, Duration.ofHours(2));
    }


}
