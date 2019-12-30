package model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TokenData {
    private String value;
    private String ttl;
}
