package com.blog.service;

import com.blog.domain.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author chenzuolin
 * @Description
 * @date 2020/4/21 14:55
 */
public interface TagService {
    /**
     * 添加方法
     * @param type
     * @return
     */
    Tag saveTag(Tag type);

    /**
     * 通过id查找
     * @param id
     * @return
     */
    Tag getTag(Long id);

    /**
     * 通过name查找
     * @param name
     * @return
     */
    Tag getTagByName(String name);

    /**
     * 分页查询
     * @param pageable
     * @return
     */
    Page<Tag> listTag(Pageable pageable);

    /**
     * 查询全部
     * @return
     */
    List<Tag> listTag();

    /**
     * 查询大小
     * @param size
     * @return
     */
    List<Tag> listTagTop(Integer size);

    /**
     * 通过id查询
     * @param ids
     * @return
     */
    List<Tag> listTag(String ids);

    /**
     * 更新
     * @param id
     * @param tag
     * @return
     */
    Tag updateTag(Long id, Tag tag);

    /**
     * 删除
     * @param id
     */
    void deleteTag(Long id);
}
