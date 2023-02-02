package words.backend;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import words.backend.controller.postController;
import words.backend.model.Post;
import words.backend.repo.postRepo;


import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PostTests {

    @Mock
    private postRepo postsrepo;

    @InjectMocks
    private postController postControllerTest;

    @Test
    public void addPostTest(){
        Post post = new Post("1","Why is Music So Powerful?",
                "music","Music is such a powerful tool. It has been scientifically proven that it has " +
                "the ability to change our moods.","A new neuroscience-based study has identified that if specific " +
                "music evokes personal memories, these songs have the power to elicit stronger positive emotions than " +
                "other stimuli, such as looking at a nostalgic picture.",new Date());
        postsrepo.save(post);
        when(postsrepo.save(post)).thenReturn(post);
        Post result = postControllerTest.addpost(post);
        assertEquals(post, result);
        verify(postsrepo).save(post);

    }

}
