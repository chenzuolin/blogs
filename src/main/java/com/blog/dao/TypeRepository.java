package com.blog.dao;

import com.blog.domain.Type;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 神州战神
 */
public interface TypeRepository extends JpaRepository<Type,Long> {

    /**
     * 通过分类名称查询
     * @param name
     * @return
     */
    Type findByName(String name);
}
