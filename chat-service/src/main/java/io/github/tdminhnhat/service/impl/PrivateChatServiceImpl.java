package io.github.tdminhnhat.service.impl;

import io.github.tdminhnhat.exception.QueryNotFoundException;
import io.github.tdminhnhat.mapper.EmotionMapper;
import io.github.tdminhnhat.mapper.PrivateChatEmotionMapper;
import io.github.tdminhnhat.mapper.PrivateChatMapper;
import io.github.tdminhnhat.model.dto.PrivateChatDTO;
import io.github.tdminhnhat.model.vo.PrivateChatVO;
import io.github.tdminhnhat.repository.EmotionRepository;
import io.github.tdminhnhat.repository.PrivateChatEmotionRepository;
import io.github.tdminhnhat.repository.PrivateChatRepository;
import io.github.tdminhnhat.service.PrivateChatService;
import jakarta.inject.Singleton;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Singleton
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PrivateChatServiceImpl implements PrivateChatService {

    EmotionRepository emotionRepository;
    PrivateChatRepository privateChatRepository;
    PrivateChatEmotionRepository privateChatEmotionRepository;
    EmotionMapper emotionMapper;
    PrivateChatMapper privateChatMapper;
    PrivateChatEmotionMapper privateChatEmotionMapper;

    @Override
    public Mono<PrivateChatVO> create(PrivateChatDTO request) {
        return privateChatRepository.save(privateChatMapper.toEntity(request)).map(privateChatMapper::toVO);
    }

    @Override
    public Mono<PrivateChatVO> update(Long id, PrivateChatDTO request) {
        return null;
    }

    @Override
    public Mono<PrivateChatVO> delete(Long id) {
        return privateChatRepository.findById(id).switchIfEmpty(Mono.error(new QueryNotFoundException("Private Chat Not Found")))
                .flatMap(privateChat -> {
                    privateChat.setIsRecall(true);
                    privateChat.setDeleted(true);
                    return privateChatRepository.update(privateChat).map(privateChatMapper::toVO);
                });
    }

    @Override
    public Mono<PrivateChatVO> getById(Long id) {
        return privateChatRepository.findById(id).switchIfEmpty(Mono.error(new QueryNotFoundException("Private Chat Not Found")))
                .map(privateChat -> {
                    PrivateChatVO privateChatVO = privateChatMapper.toVO(privateChat);
                    privateChatVO.setPrivateChatEmotionVO(privateChatEmotionRepository.findByPrivateChatId(privateChat.getId()).map(privateChatEmotionMapper::toVO));
                    return privateChatVO;
                });
    }

    @Override
    public Flux<PrivateChatVO> getAll() {
        return privateChatRepository.findAll().map(privateChat -> {
            PrivateChatVO privateChatVO = privateChatMapper.toVO(privateChat);
            privateChatVO.setPrivateChatEmotionVO(privateChatEmotionRepository.findByPrivateChatId(privateChat.getId()).map(privateChatEmotionMapper::toVO));
            return privateChatVO;
        });
    }
}
