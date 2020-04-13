package com.blog.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author 神州战神
 */
@Entity
@Table(name = "t_comment")
public class Comment implements Serializable {

    private static final long serialVersionUID = -405771009120601926L;
    /**
     * 评论主键
     */
    @Id
    @GeneratedValue
    private Long id;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * email
     */
    private String email;
    /**
     * 评论内容
     */
    private String content;
    /**
     * 头像地址
     */
    private String avatar;
    /**
     * 评论时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    @ManyToOne
    private Blog blog;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", nickName='" + nickName + '\'' +
                ", email='" + email + '\'' +
                ", content='" + content + '\'' +
                ", avatar='" + avatar + '\'' +
                ", createTime=" + createTime +
                ", blog=" + blog +
                '}';
    }
}
