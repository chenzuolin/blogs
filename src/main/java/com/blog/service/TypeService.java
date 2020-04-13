package com.blog.service;

import com.blog.domain.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * @author 神州战神
 */
public interface TypeService {

    /**
     * 添加分类
     * @param type
     * @return
     */
    Type saveType(Type type);

    /**
     * 通过id查询分类
     * @param id
     * @return
     */
    Type getType(Long id);

    /**
     * 分类分页查询
     * @param pageable
     * @return
     */
    Page<Type> listType(Pageable pageable);

    /**
     * 通过id进行修改
     * @param id
     * @param type
     * @return
     */
    Type updateType(Long id,Type type);

    /**
     * 通过id进行删除
     * @param id
     */
    void deleteType(Long id);

    /**
     * 通过分类名称查询
     * @param name
     * @return
     */
    Type findByName(String name);
}
