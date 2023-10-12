package br.com.luan.repository;

import br.com.luan.model.User;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserRepository extends BaseRepository<User, Long> {

}

