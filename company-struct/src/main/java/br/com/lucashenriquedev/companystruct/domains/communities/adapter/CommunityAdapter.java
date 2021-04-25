package br.com.lucashenriquedev.companystruct.domains.communities.adapter;

import br.com.lucashenriquedev.companystruct.domains.communities.controller.request.InsertCommunityRequest;
import br.com.lucashenriquedev.companystruct.domains.communities.controller.request.UpdateCommunityRequest;
import br.com.lucashenriquedev.companystruct.domains.communities.controller.response.CommunityHierarchyResponse;
import br.com.lucashenriquedev.companystruct.domains.communities.controller.response.CommunityResponse;
import br.com.lucashenriquedev.companystruct.domains.communities.model.Community;
import br.com.lucashenriquedev.companystruct.domains.employees.adapter.EmployeeAdapter;
import br.com.lucashenriquedev.companystruct.domains.employees.factory.EmployeeFactory;
import br.com.lucashenriquedev.companystruct.domains.release_trains.adapter.ReleaseTrainAdapter;

import javax.transaction.Transactional;
import java.util.stream.Collectors;

public class CommunityAdapter {

    public static Community from(InsertCommunityRequest request) {
        return Community.builder()
                .name(request.getName())
                .leader(EmployeeFactory.create(request.getLeader()))
                .build();
    }

    public static Community from(UpdateCommunityRequest request) {
        return Community.builder()
                .name(request.getName())
                .leader(EmployeeFactory.create(request.getLeader()))
                .build();
    }

    public static CommunityResponse toResponse(Community community) {
        return CommunityResponse.builder()
                .id(community.getId())
                .name(community.getName())
                .leader(EmployeeAdapter.to(community.getLeader()))
                .build();
    }

    @Transactional
    public static CommunityHierarchyResponse toHierarchyResponse(Community community) {
        return CommunityHierarchyResponse.builder()
                .id(community.getId())
                .name(community.getName())
                .leader(EmployeeAdapter.to(community.getLeader()))
                .releaseTrains(community.getReleaseTrains()
                        .stream()
                        .map(ReleaseTrainAdapter::toHierarchyResponse)
                        .collect(Collectors.toList()))
                .build();
    }

}
