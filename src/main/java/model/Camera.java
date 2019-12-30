package model;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Camera {
    private int id;
    private String sourceDataUrl;
    private String tokenDataUrl;
}
