package br.com.lucashenriquedev.companystruct.domains.release_trains.adapter;

import br.com.lucashenriquedev.companystruct.commons.utils.CollectionUtils;
import br.com.lucashenriquedev.companystruct.domains.communities.adapter.CommunityAdapter;
import br.com.lucashenriquedev.companystruct.domains.communities.factory.CommunityFactory;
import br.com.lucashenriquedev.companystruct.domains.release_trains.controller.request.InsertReleaseTrainRequest;
import br.com.lucashenriquedev.companystruct.domains.release_trains.controller.request.UpdateReleaseTrainRequest;
import br.com.lucashenriquedev.companystruct.domains.release_trains.controller.response.*;
import br.com.lucashenriquedev.companystruct.domains.release_trains.factory.ReleaseTrainResponsibleFactory;
import br.com.lucashenriquedev.companystruct.domains.release_trains.model.ReleaseTrain;
import br.com.lucashenriquedev.companystruct.domains.release_trains.model.ReleaseTrainSquad;
import br.com.lucashenriquedev.companystruct.domains.squads.model.SquadMember;
import br.com.lucashenriquedev.companystruct.domains.squads.model.SquadRole;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ReleaseTrainAdapter {

    public static ReleaseTrain from(InsertReleaseTrainRequest request) {
        return ReleaseTrain.builder()
                .name(request.getName())
                .notes(request.getNotes())
                .community(CommunityFactory.create(request.getCommunity()))
                .manager(request.getManager())
                .isActive(Boolean.TRUE)
                .squads(CollectionUtils.newList())
                .responsible(CollectionUtils.newList(
                        ReleaseTrainResponsibleFactory.createLeader(request.getResponsible())))
                .build();
    }

    public static ReleaseTrain from(UpdateReleaseTrainRequest request) {
        return ReleaseTrain.builder()
                .name(request.getName())
                .manager(request.getManager())
                .community(CommunityFactory.create(request.getCommunity()))
                .notes(request.getNotes())
                .build();
    }

    public static ReleaseTrainProjection toProjection(ReleaseTrain releaseTrain) {
        return ReleaseTrainProjection.builder()
                .id(releaseTrain.getId())
                .name(releaseTrain.getName())
                .isActive(releaseTrain.isActive())
                .manager(releaseTrain.getManager())
                .leader(releaseTrain.getLeader()
                        .map(ReleaseTrainResponsibleAdapter::toResponse)
                        .orElse(null))
                .notes(releaseTrain.getNotes())
                .build();
    }

    public static ReleaseTrainResponse toResponse(ReleaseTrain releaseTrain) {
        return ReleaseTrainResponse.builder()
                .id(releaseTrain.getId())
                .name(releaseTrain.getName())
                .isActive(releaseTrain.isActive())
                .manager(releaseTrain.getManager())
                .community(CommunityAdapter.toResponse(releaseTrain.getCommunity()))
                .leader(releaseTrain.getLeader()
                        .map(ReleaseTrainResponsibleAdapter::toResponse)
                        .orElse(null))
                .responsible(releaseTrain.getResponsible()
                        .stream()
                        .map(ReleaseTrainResponsibleAdapter::toResponse)
                        .collect(Collectors.toList()))
                .squads(releaseTrain.getSquads().stream()
                        .map(ReleaseTrainSquadAdapter::toResponse)
                        .collect(Collectors.toList()))
                .notes(releaseTrain.getNotes())
                .build();
    }

    @Transactional
    public static ReleaseTrainHierarchyResponse toHierarchyResponse(ReleaseTrain releaseTrain) {
        return ReleaseTrainHierarchyResponse.builder()
                .id(releaseTrain.getId())
                .name(releaseTrain.getName())
                .leader(releaseTrain.getLeader()
                        .map(l -> ReleaseTrainResponsibleHierarchyResponse.builder()
                                .id(l.getEmployee().getId())
                                .name(l.getEmployee().getName())
                                .role(l.getRole())
                                .build())
                        .orElse(null))
                .responsible(releaseTrain.getResponsible()
                        .stream()
                        .map(r -> ReleaseTrainResponsibleHierarchyResponse.builder()
                                .id(r.getEmployee().getId())
                                .name(r.getEmployee().getName())
                                .role(r.getRole())
                                .squads(releaseTrain.getSquads().stream()
                                        .filter(s -> s.getResponsible().equals(r))
                                        .map(ReleaseTrainAdapter::buildSquad)
                                        .collect(Collectors.toList()))
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }

    private static ReleaseTrainSquadHierarchyResponse buildSquad(ReleaseTrainSquad squad) {
        final var triadRole = Arrays.asList(
                SquadRole.TEAM_LEAD,
                SquadRole.TECH_LEAD,
                SquadRole.PRODUCT_OWNER);

        return ReleaseTrainSquadHierarchyResponse.builder()
                .id(squad.getSquad().getId())
                .name(squad.getSquad().getName())
                .leader(squad.getSquad().getLeader()
                        .map(ReleaseTrainAdapter::buildSquadMember)
                        .orElse(null))
                .triad(squad.getSquad().getMembers()
                        .stream()
                        .filter(m -> triadRole.contains(m.getRole()))
                        .map(ReleaseTrainAdapter::buildSquadMember)
                        .collect(Collectors.toList()))
                .members(squad.getSquad().getMembers()
                        .stream()
                        .filter(m -> !triadRole.contains(m.getRole()))
                        .map(ReleaseTrainAdapter::buildSquadMember)
                        .collect(Collectors.toList()))
                .build();
    }

    private static ReleaseTrainSquadMemberHierarchyResponse buildSquadMember(SquadMember member) {
        return ReleaseTrainSquadMemberHierarchyResponse.builder()
                .id(member.getId())
                .name(member.getMemberName())
                .role(member.getRole())
                .isExternal(member.getIsExternal())
                .build();
    }

}
