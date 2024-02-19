package leotran.demo.TikTok.service;

import leotran.demo.TikTok.dto.PostDTO;

import java.util.List;

public interface PostService {
    PostDTO getPostById(Long id);

    List<PostDTO> getAllPost();

    PostDTO addPost(PostDTO postDTO);

    PostDTO updatePost(Long id, PostDTO postDTO);

    void deletePost(Long id);

}
