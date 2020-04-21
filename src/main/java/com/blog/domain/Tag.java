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
@Table(name = "t_tag")
public class Tag implements Serializable {
    private static final long serialVersionUID = -45117944378899320L;
    /**
     * 标签id
     */
    @Id
    @GeneratedValue
    private Long id;
    /**
     * 标签名称
     */
    private String name;
    /**
     * 博客对象
     */
    @ManyToMany(mappedBy = "tags")
    private List<Blog> blog = new ArrayList<>();

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

    public List<Blog> getBlog() {
        return blog;
    }

    public void setBlog(List<Blog> blog) {
        this.blog = blog;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", blog=" + blog +
                '}';
    }
}
