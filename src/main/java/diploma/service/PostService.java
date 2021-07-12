package diploma.service;

import diploma.model.Post;

import java.util.List;

public interface PostService {

    Post create(Post post );

    Post readById(long id );

    Post update(Post post);

    void delete(long id );

    List<Post> getAllByOwnerId(long id);

    List<Post> getPostsByTredId(String id) ;


}
