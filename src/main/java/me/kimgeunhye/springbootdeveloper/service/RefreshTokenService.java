package me.kimgeunhye.springbootdeveloper.service;


import lombok.RequiredArgsConstructor;
import me.kimgeunhye.springbootdeveloper.domain.RefreshToken;
import me.kimgeunhye.springbootdeveloper.repository.RefreshTokenRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;

    public RefreshToken findByRefreshToken(String refreshToken) {
        return refreshTokenRepository.findByRefreshToken(refreshToken)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected token"));
    }


}
