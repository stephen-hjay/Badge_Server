package com.badge.server.android.Entity.Utils;


import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AndroidRequest {
    public String data;

    @Override
    public String toString() {
        return "AndroidRequest{" +
                "data='" + data + '\'' +
                '}';
    }
}
