package leotran.demo.TikTok.repository;

import leotran.demo.TikTok.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
