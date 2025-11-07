package io.github.tdminhnhat.service.impl;

import io.github.tdminhnhat.entity.GroupMember;
import io.github.tdminhnhat.enums.GroupMemberStatus;
import io.github.tdminhnhat.enums.JoinGroupType;
import io.github.tdminhnhat.exception.BadRequestException;
import io.github.tdminhnhat.exception.QueryNotFoundException;
import io.github.tdminhnhat.mapper.GroupMemberMapper;
import io.github.tdminhnhat.model.dto.GroupMemberDTO;
import io.github.tdminhnhat.model.vo.GroupMemberVO;
import io.github.tdminhnhat.repository.GroupMemberRepository;
import io.github.tdminhnhat.repository.GroupRepository;
import io.github.tdminhnhat.service.GroupMemberService;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.List;

@Singleton
@RequiredArgsConstructor
public class GroupMemberServiceImpl implements GroupMemberService {

    private final GroupRepository groupRepository;
    private final GroupMemberRepository groupMemberRepository;
    private final GroupMemberMapper groupMemberMapper;

    @Override
    public Mono<GroupMemberVO> create(GroupMemberDTO request) {
        return groupRepository.findById(request.groupId()).switchIfEmpty(Mono.error(new QueryNotFoundException("Group Not Found")))
                .flatMap(group -> {
                    GroupMember groupMember = new GroupMember();
                    if(group.getJoinType().equals(JoinGroupType.NEED_APPROVAL)) {
                        if(request.userApproval() == null) {
                            return Mono.error(new BadRequestException("User approval is required for this group"));
                        } else {
                            groupMember.setUserApproval(request.userApproval());
                        }
                    } else if(group.getJoinType().equals(JoinGroupType.PRIVATE)) {
                        return Mono.error(new BadRequestException("Cannot join a private group"));
                    } else {
                        groupMember.setUserApproval(null);
                    }
                    groupMember.setGroup(group);
                    groupMember.setUserId(request.userId());
                    return groupMemberRepository.save(groupMember).map(groupMemberMapper::toVO);
                });
    }

    @Override
    public Mono<GroupMemberVO> update(Long id, GroupMemberDTO request) {
        return null;
    }

    @Override
    public Mono<GroupMemberVO> delete(Long id) {
        return null;
    }

    @Override
    public Mono<GroupMemberVO> getById(Long id) {
        return groupMemberRepository.findById(id).switchIfEmpty(Mono.error(new QueryNotFoundException("Group Member Not Found")))
                .map(groupMemberMapper::toVO);
    }

    @Override
    public Flux<GroupMemberVO> getAll() {
        return null;
    }

    @Override
    public Flux<GroupMemberVO> getAllMembersByGroupId(Long groupId) {
        return groupMemberRepository.findByGroup_Id(groupId).map(groupMemberMapper::toVO);
    }

    @Override
    public Mono<GroupMemberVO> changeStatus(Long groupId, Long memberId, GroupMemberStatus status) {
        return groupMemberRepository.findByGroup_IdAndUserId(groupId, memberId).flatMap(groupMember -> {
            groupMember.setStatus(status);
            return groupMemberRepository.save(groupMember).map(groupMemberMapper::toVO);
        });
    }

    @Override
    public Flux<GroupMemberVO> kickOrBlockMembers(Long groupId, List<Long> memberIds, GroupMemberStatus status) {
        return groupMemberRepository.findByGroup_IdAndUserIdIn(groupId, memberIds.toArray(new Long[0])).flatMap(groupMember -> {
            groupMember.setStatus(status);
            return groupMemberRepository.save(groupMember).map(groupMemberMapper::toVO);
        });
    }
}
