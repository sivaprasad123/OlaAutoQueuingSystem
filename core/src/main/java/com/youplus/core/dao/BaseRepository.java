package com.youplus.core.dao;

import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
interface BaseRepository<T, ID extends Serializable> extends CrudRepository<T, ID> {
}
