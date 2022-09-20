package com.ssafy.miraclebird.dao;

import com.ssafy.miraclebird.entity.Post;
import com.ssafy.miraclebird.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostDaoImpl implements PostDao {

    private final PostRepository postRepository;

    @Autowired
    public PostDaoImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post getPost(Long postIdx) throws Exception {
        Post postEntity = postRepository.getById(postIdx);

        if(postEntity == null)
            throw new Exception();

        return postEntity;
    }

    @Override
    public void saveBoard(Post post) throws Exception {
        try {
            postRepository.save(post);
        }
        catch (Exception e) {
            throw new Exception();
        }
    }

    @Override
    public void deletePost(Long postIdx) throws Exception{
        try {
            postRepository.deleteById(postIdx);
        }
        catch (Exception e) {
            throw new Exception();
        }
    }
}
