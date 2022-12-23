/*
package com.app.h_log.domain;

import com.app.h_log.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MemberDTO {

    private int idx;
    private String userid;
    private String password;
    private String username;
    private String role;
    private LocalDate regdate;
    private LocalDate editdate;

    private Member toMemberEntity() {
        return Member.builder()
                .idx(idx)
                .userid(userid)
                .password(password)
                .username(username)
                .role(role)

                .build();
    }
}
*/
