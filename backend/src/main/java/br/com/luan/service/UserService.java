package br.com.luan.service;

import br.com.luan.model.User;
import br.com.luan.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserService extends BaseService<User, Long, UserRepository> {

}
