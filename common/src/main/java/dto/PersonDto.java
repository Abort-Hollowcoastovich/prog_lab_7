package dto;


import lombok.Getter;
import lombok.Setter;
import models.Coordinates;
import models.EyesColor;
import models.HairsColor;
import models.Location;

import java.io.Serializable;

@Setter
@Getter
public class PersonDto implements Serializable {
    private static final long serialVersionUID = 8888793084928896959L;
    private String name = null;
    private CoordinatesDto coordinatesDto = null;
    private Long height = null;
    private float weight = 0;
    private EyesColor eyesColor = null;
    private HairsColor hairsColor = null;
    private LocationDto locationDto = null;
    private int ownerId = 0;

    public PersonDto() {
    }

    public PersonDto(String name, CoordinatesDto coordinatesDto, Long height, float weight, EyesColor eyesColor,
                     HairsColor hairsColor, LocationDto locationDto) throws IllegalArgumentException {
        this.name = name;
        this.coordinatesDto = coordinatesDto;
        this.height = height;
        this.weight = weight;
        this.eyesColor = eyesColor;
        this.hairsColor = hairsColor;
        this.locationDto = locationDto;
    }

    @Override
    public String toString() {
        return "PersonDto{" +
                "name='" + name + '\'' +
                ", coordinates=" + coordinatesDto.toString() +
                ", height=" + height +
                ", weight=" + weight +
                ", eyesColor=" + eyesColor +
                ", hairsColor=" + hairsColor +
                ", location=" + locationDto.toString() +
                '}';
    }
}
