package com.blog.service.impl;

import com.blog.dao.TagsReponsitory;
import com.blog.domain.Tag;
import com.blog.exception.NotFoundException;
import com.blog.service.TagService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


/**
 * @author chenzuolin
 * @Description
 * @date 2020/4/21 14:57
 */
@Service
public class TagServiceImpl implements TagService {

    @Resource
    TagsReponsitory tagsReponsitory;

    @Transactional
    @Override
    public Tag saveTag(Tag type) {
        return tagsReponsitory.save(type);
    }

    @Transactional
    @Override
    public Tag getTag(Long id) {
        return tagsReponsitory.getOne(id);
    }

    @Override
    public Tag getTagByName(String name) {
        return tagsReponsitory.findByName(name);
    }

    @Transactional
    @Override
    public Page<Tag> listTag(Pageable pageable) {
        return tagsReponsitory.findAll(pageable);
    }

    @Override
    public List<Tag> listTag() {
        return tagsReponsitory.findAll();
    }

    @Transactional
    @Override
    public List<Tag> listTagTop(Integer size) {
        Pageable pageable = PageRequest.of(0, size, Sort.by(Sort.Direction.DESC));
        return tagsReponsitory.findTop(pageable);
    }

    @Override
    public List<Tag> listTag(String ids) {
        return tagsReponsitory.findAllById(convertToList(ids));
    }

    private List<Long> convertToList(String ids) {
        List<Long> list = new ArrayList<>();
        if (!"".equals(ids) && ids != null) {
            String[] idarray = ids.split(",");
            for (int i=0; i < idarray.length;i++) {
                list.add(new Long(idarray[i]));
            }
        }
        return list;
    }

    @Transactional
    @Override
    public Tag updateTag(Long id, Tag tag) {
        Tag t = tagsReponsitory.getOne(id);
        if (t == null) {
            throw new NotFoundException("不存在该标签");
        }
        BeanUtils.copyProperties(tag,t);
        return tagsReponsitory.save(t);
    }

    @Override
    public void deleteTag(Long id) {
        tagsReponsitory.deleteById(id);
    }
}
