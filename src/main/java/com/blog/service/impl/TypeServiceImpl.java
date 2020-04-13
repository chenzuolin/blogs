package com.blog.service.impl;

import com.blog.dao.TypeRepository;
import com.blog.domain.Type;
import com.blog.exception.NotFoundException;
import com.blog.service.TypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * @author 神州战神
 */
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    TypeRepository typeRepository;

    /**
     * 添加分类
     * @param type
     * @return
     */
    @Transactional
    @Override
    public Type saveType(Type type) {
        return typeRepository.save(type);
    }

    /**
     * 查询分类
     * @param id
     * @return
     */
    @Transactional
    @Override
    public Type getType(Long id) {
        return typeRepository.findById(id).get();
    }

    /**
     * 分页查询分类
     * @param pageable
     * @return
     */
    @Transactional
    @Override
    public Page<Type> listType(Pageable pageable) {
        return typeRepository.findAll(pageable);
    }

    /**
     * 修改分类
     * @param id
     * @param type
     * @return
     */
    @Transactional
    @Override
    public Type updateType(Long id, Type type) {
        Type t = typeRepository.findById(id).get();
        if(t == null){
            throw  new NotFoundException("类型不存在！！！");
        }
        BeanUtils.copyProperties(type,t);
        return typeRepository.save(t);
    }
    /**
     * 删除分类
     * @param id 分类id
     */
    @Transactional
    @Override
    public void deleteType(Long id) {
        typeRepository.deleteById(id);
    }

    /**
     * 通过分类名称查询
     * @param name
     * @return
     */

    @Override
    public Type findByName(String name) {
        return typeRepository.findByName(name);
    }
}
