package leotran.demo.TikTok.controller;

import leotran.demo.TikTok.dto.PostDTO;
import leotran.demo.TikTok.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/newsfeed")
@AllArgsConstructor
public class PostController {
    private PostService postService;

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("{id}")
    public ResponseEntity<PostDTO> getPost(@PathVariable Long id){
        PostDTO foundPost = postService.getPostById(id);
        return new ResponseEntity<>(foundPost, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping
    public ResponseEntity<List<PostDTO>> getAllPost(){
        List<PostDTO> allPosts = postService.getAllPost();
        return new ResponseEntity<>(allPosts, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<PostDTO> addNewPost(@RequestBody PostDTO postDTO){
        PostDTO addedPost = postService.addPost(postDTO);
        return new ResponseEntity<>(addedPost, HttpStatus.CREATED);
    }

    @PreAuthorize(("hasRole('ADMIN')"))
    @PutMapping("{id}")
    public ResponseEntity<PostDTO> updatePost(@PathVariable Long id, @RequestBody PostDTO postDTO){
        PostDTO updatedPost = postService.updatePost(id, postDTO);
        return new ResponseEntity<>(updatedPost, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePost(@PathVariable Long id){
        postService.deletePost(id);
        return new ResponseEntity<>("Delete Successfully!", HttpStatus.OK);
    }

}
