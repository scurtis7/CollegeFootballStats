package com.scurtis.cfs.converter;

import com.scurtis.cfs.dto.PortalPlayerDto;
import com.scurtis.cfs.model.PortalPlayer;
import org.springframework.stereotype.Service;

@Service
public class PortalPlayerConverter {

    public PortalPlayerDto toDto(PortalPlayer portalPlayer) {
        PortalPlayerDto dto = new PortalPlayerDto();
        dto.setSeason(portalPlayer.getSeason());
        dto.setFirstName(portalPlayer.getFirstName());
        dto.setLastName(portalPlayer.getLastName());
        dto.setPosition(portalPlayer.getPosition());
        dto.setOrigin(portalPlayer.getOrigin());
        dto.setDestination(portalPlayer.getDestination());
        dto.setTransferDate(portalPlayer.getTransferDate());
        dto.setRating(portalPlayer.getRating());
        dto.setStars(portalPlayer.getStars());
        dto.setEligibility(portalPlayer.getEligibility());
        return dto;
    }
}
