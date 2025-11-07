package io.github.tdminhnhat.controller.impl;

import io.github.tdminhnhat.controller.IController;
import io.github.tdminhnhat.enums.GroupMemberStatus;
import io.github.tdminhnhat.model.dto.GroupMemberDTO;
import io.github.tdminhnhat.model.vo.GroupMemberVO;
import io.github.tdminhnhat.service.GroupMemberService;
import io.micronaut.http.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Controller(value = "${api.path.group-member}")
@RequiredArgsConstructor
@Tag(name = "Group Member Controller")
public class GroupMemberController implements IController<GroupMemberDTO, Long> {
    
    private final GroupMemberService groupMemberService;

    @Post
    @Override
    public Mono<GroupMemberVO> add(@Valid @Body GroupMemberDTO request) {
        return groupMemberService.create(request);
    }

    @Override
    public Mono<GroupMemberVO> update(Long id, GroupMemberDTO request) {
        return null;
    }

    @Override
    public Mono<GroupMemberVO> delete(Long id) {
        return null;
    }

    @Get(value = "/{id}")
    @Override
    public Mono<GroupMemberVO> getById(Long id) {
        return groupMemberService.getById(id);
    }

    @Override
    public Flux<GroupMemberVO> getAll() {
        return null;
    }

    @Get(value = "/group/{id}")
    public Flux<GroupMemberVO> getAllMembersByGroupId(@PathVariable("id") Long id) {
        return groupMemberService.getAllMembersByGroupId(id);
    }

    @Put(value = "/status")
    public Mono<GroupMemberVO> changeStatus(
            @QueryValue("groupId") Long groupId,
            @QueryValue("memberId") Long memberId,
            @QueryValue("status") GroupMemberStatus status) {
        return groupMemberService.changeStatus(groupId, memberId, status);
    }

    @Patch(value = "/kick-or-ban")
    public Flux<GroupMemberVO> kickOrBlockMembers(
            @QueryValue("groupId") Long groupId,

            @QueryValue("memberIds")
            @Valid @Size(min = 1, message = "need at least {min} member") List<Long> memberIds,

            @QueryValue("status")
            @Valid @Pattern(regexp = "(KICKED|BLOCKED)", message = "status only KICKED or BLOCKED") GroupMemberStatus status) {
        return groupMemberService.kickOrBlockMembers(groupId, memberIds, status);
    }
}
