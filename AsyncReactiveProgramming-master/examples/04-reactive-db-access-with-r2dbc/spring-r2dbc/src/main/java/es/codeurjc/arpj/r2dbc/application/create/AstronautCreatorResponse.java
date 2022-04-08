package es.codeurjc.arpj.r2dbc.application.create;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder(builderClassName = "Builder")
public class AstronautCreatorResponse {

    private final Long id;

    private final String name;

    private final String status;

    private final String birthPlace;

    private final String gender;

    private final int spaceFlights;

    private final int spaceWalks;

    private final String missions;
}
