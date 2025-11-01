package io.github.tdminhnhat.service.impl;

import io.github.tdminhnhat.exception.QueryNotFoundException;
import io.github.tdminhnhat.mapper.EmotionMapper;
import io.github.tdminhnhat.mapper.GroupChatEmotionMapper;
import io.github.tdminhnhat.mapper.GroupChatMapper;
import io.github.tdminhnhat.model.dto.GroupChatDTO;
import io.github.tdminhnhat.model.vo.GroupChatEmotionVO;
import io.github.tdminhnhat.model.vo.GroupChatVO;
import io.github.tdminhnhat.repository.EmotionRepository;
import io.github.tdminhnhat.repository.GroupChatEmotionRepository;
import io.github.tdminhnhat.repository.GroupChatRepository;
import io.github.tdminhnhat.service.GroupChatService;
import jakarta.inject.Singleton;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Singleton
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GroupChatServiceImpl implements GroupChatService {

    GroupChatRepository groupChatRepository;
    GroupChatEmotionRepository groupChatEmotionRepository;
    EmotionRepository emotionRepository;
    GroupChatMapper groupChatMapper;
    GroupChatEmotionMapper groupChatEmotionMapper;
    EmotionMapper emotionMapper;

    @Override
    public Mono<GroupChatVO> create(GroupChatDTO request) {
        return groupChatRepository.save(groupChatMapper.toEntity(request)).map(groupChatMapper::toVO);
    }

    @Override
    public Mono<GroupChatVO> update(Long id, GroupChatDTO request) {
        return groupChatRepository.findById(id).switchIfEmpty(Mono.error(new QueryNotFoundException("GroupChat Not Found")))
                .flatMap(groupChat -> {
                    groupChat = groupChatMapper.toEntity(request);
                    return groupChatRepository.update(groupChat).map(groupChatMapper::toVO);
                });
    }

    @Override
    public Mono<GroupChatVO> delete(Long id) {
        return groupChatRepository.findById(id).switchIfEmpty(Mono.error(new QueryNotFoundException("GroupChat Not Found")))
                .flatMap(groupChat -> {
                    groupChat.setDeleted(true);
                    return groupChatRepository.update(groupChat).map(groupChatMapper::toVO);
                });
    }

    @Override
    public Mono<GroupChatVO> getById(Long id) {
        return groupChatRepository.findById(id).switchIfEmpty(Mono.error(new QueryNotFoundException("GroupChat Not Found")))
                .map(groupChat -> {
                    GroupChatVO groupChatVO = groupChatMapper.toVO(groupChat);
                    groupChatVO.setGroupChatEmotionVO(groupChatEmotionRepository.findByGroupId(groupChat.getGroupId())
                            .flatMap(groupChatEmotion -> emotionRepository.findById(groupChatEmotion.getEmotionId()).switchIfEmpty(Mono.error(new QueryNotFoundException("Emotion Not Found")))
                                    .map(emotion -> {
                                        GroupChatEmotionVO groupChatEmotionVO = groupChatEmotionMapper.toVO(groupChatEmotion);
                                        groupChatEmotionVO.setEmotionVO(emotionMapper.toVO(emotion));
                                        return groupChatEmotionVO;
                                    })));
                    return groupChatVO;
                });
    }

    @Override
    public Flux<GroupChatVO> getAll() {
        return groupChatRepository.findAll().map(groupChat -> {
            GroupChatVO groupChatVO = groupChatMapper.toVO(groupChat);
            groupChatVO.setGroupChatEmotionVO(groupChatEmotionRepository.findByGroupId(groupChat.getGroupId())
                    .flatMap(groupChatEmotion -> emotionRepository.findById(groupChatEmotion.getEmotionId()).switchIfEmpty(Mono.error(new QueryNotFoundException("Emotion Not Found")))
                            .map(emotion -> {
                                GroupChatEmotionVO groupChatEmotionVO = groupChatEmotionMapper.toVO(groupChatEmotion);
                                groupChatEmotionVO.setEmotionVO(emotionMapper.toVO(emotion));
                                return groupChatEmotionVO;
                            })));
            return groupChatVO;
        });
    }
}
