package diploma.service.impl;

import diploma.exception.InsertExcpetion;
import diploma.model.Post;
import diploma.repository.PostRepository;
import diploma.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
public class PostServiceImpl implements PostService {



    private PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;

    }

    @Override
    public Post create(Post post) {
        try {
            return postRepository.save(post);
        } catch (IllegalArgumentException e) {
            throw new NullPointerException("Post can not be empty");

        }

    }

    @Override
    public Post readById(long id) {
        try {
            Optional<Post> optional = postRepository.findById(id);
            return optional.get();
        } catch (NoSuchElementException e) {
            throw new EntityNotFoundException("no post found in DB");

        }

    }

    @Override
    public Post update(Post post) {
        Post oldPost = readById(post.getPostId());
        try {
            return postRepository.save(post);
        }catch(IllegalArgumentException e ){
            throw new NullPointerException("Attempt  to update an empty post ");
        }

    }

    @Override
    public void delete(long id) {
        try {
            Post post = readById(id);
            postRepository.delete(post);
        }catch(NoSuchElementException e){
        throw new EntityNotFoundException("no post found in DB");
        }
    }

    @Override
    public List<Post> getAllByOwnerId(long id) {
            try {
                List<Post> posts = postRepository.getAllByOwnerId(id);
                return posts.isEmpty() ? new ArrayList<>() : posts;
            }catch(NoSuchElementException e ){
                throw new EntityNotFoundException(" no post of owner found");
            }

    }

    @Override
    public List<Post> getPostsByTredId(String id) {
        try{
            if(postRepository==null)
                System.err.println("Соси");
            return postRepository.getAllByTredId(Long.parseLong(id));
        }catch(NoSuchElementException e ){
            throw  new  EntityNotFoundException("no such tred exception go home and forget abo");

        }




    }


}
