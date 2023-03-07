package africa.soimpaf.api_v1.services;

import africa.soimpaf.api_v1.interfaces.CommentInterface;
import africa.soimpaf.api_v1.models.Comment;
import africa.soimpaf.api_v1.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService implements CommentInterface {
    @Autowired CommentRepository commentRepository;

    @Override
    public List<Comment> getAll() {
        return (List<Comment>) commentRepository.findAll();
    }

    @Override
    public Comment create(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Optional<Comment> getSingle(long id) {
        return  commentRepository.findById(id);
    }

    @Override
    public Comment update(long id, Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public void delete(long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public Optional<Comment> getById(long id) {
        return  commentRepository.findById(id);
    }

}
