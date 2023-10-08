package by.pvt.core.repository.interfaces;

import by.pvt.core.domain.Posts;

import java.util.List;

public interface InterfaceDbPostRepo {
    void addPost(Posts post);

    List<Posts> getListPost();

    Posts findById(Long postID);

    void delPost(long id);
}
