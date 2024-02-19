package leotran.demo.TikTok.service;

import leotran.demo.TikTok.dto.PostDTO;
import leotran.demo.TikTok.entity.Post;
import leotran.demo.TikTok.exception.ResourceNotFoundException;
import leotran.demo.TikTok.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PostServiceImplement implements PostService{
    private PostRepository postRepository;

    private ModelMapper modelMapper;
    @Override
    public PostDTO getPostById(Long id) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Could not find post with id: " + id)
        );
        PostDTO foundPost = modelMapper.map(post, PostDTO.class);
        return foundPost;
    }

    @Override
    public List<PostDTO> getAllPost() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map((post) -> modelMapper.map(post, PostDTO.class)).collect(Collectors.toList());
    }

    @Override
    public PostDTO addPost(PostDTO postDTO) {
        Post post = modelMapper.map(postDTO, Post.class);
        postRepository.save(post);
        PostDTO addedPost = modelMapper.map(post, PostDTO.class);
        return addedPost;
    }

    @Override
    public PostDTO updatePost(Long id, PostDTO postDTO) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Could not find post with id: " + id)
        );
        post.setDescription(postDTO.getDescription());
        post.setSource(postDTO.getSource());
        post.setDate(postDTO.getDate());
        postRepository.save(post);
        PostDTO updatedPost = modelMapper.map(post, PostDTO.class);
        return updatedPost;
    }

    @Override
    public void deletePost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Could not find post with id: " + id)
        );
        postRepository.deleteById(id);
    }
}
