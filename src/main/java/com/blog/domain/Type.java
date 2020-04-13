package com.blog.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 神州战神
 */
@Entity
@Table(name = "t_type")
public class Type implements Serializable {

    private static final long serialVersionUID = 120750589994412402L;

    /**
     *分类id
     */
    @Id
    @GeneratedValue
    private Long id;
    /**
     * 分类名称
     */
    private String name;
    /**
     * 博客对象
     */
    @OneToMany(mappedBy = "type")
    private List<Blog>  blogs = new ArrayList<>();

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", blogs=" + blogs +
                '}';
    }
}
