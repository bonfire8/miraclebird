package com.ssafy.miraclebird.dto;

import com.ssafy.miraclebird.entity.Post;
import com.ssafy.miraclebird.securityOauth.domain.entity.user.Role;
import com.ssafy.miraclebird.util.ModelMapperUtils;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PostDto {

    private long postIdx;

    private String title;

    private String content;

    private int hit;

    private long userIdx;

    private Role role;

    public static PostDto of(Post postEntity) {
        PostDto postDto = ModelMapperUtils.getModelMapper().map(postEntity, PostDto.class);

        return postDto;
    }

}
