package com.blog.domain;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 神州战神
 */
@Entity
@Table(name = "t_blog")
public class Blog implements Serializable {

    private static final long serialVersionUID = 2825759898537966613L;
    /**
     * id 博客id
     */
    @Id
    @GeneratedValue
    private Long id;
    /**
     * title 博客标题
     */
    private String title;
    /**
     * 博客内容
     */
    private String content;
    /**
     * 博客首图
     */
    private String firstPicture;
    /**
     * 博客标记
     */
    private String flag;
    /**
     * 浏览次数
     */
    private Integer views;
    /**
     * 是否开启赞赏
     */
    private Boolean appreciation;
    /**
     * 是否开启转载声明
     */
    private Boolean shareStatement;
    /**
     * 是否开启评论
     */
    private Boolean commentabled;
    /**
     * 是否发布
     */
    private Boolean published;
    /**
     * 是否推荐
     */
    private Boolean recommened;
    /**
     * 发布时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    /**
     * 更新时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    /**
     * 博客分类对象
     */
    @ManyToOne
    public Type type;
    /**
     * 博客标签对象
     */
    @ManyToMany(cascade = {CascadeType.PERSIST})
    private List<Tag> tags = new ArrayList<>();
    /**
     * 用户对象
     */
    @ManyToOne
    private User user;
    /**
     * 用户评论对象
     */
    @OneToMany(mappedBy = "blog")
    private List<Comment> comments = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFirstPicture() {
        return firstPicture;
    }

    public void setFirstPicture(String firstPicture) {
        this.firstPicture = firstPicture;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Boolean getAppreciation() {
        return appreciation;
    }

    public void setAppreciation(Boolean appreciation) {
        this.appreciation = appreciation;
    }

    public Boolean getShareStatement() {
        return shareStatement;
    }

    public void setShareStatement(Boolean shareStatement) {
        this.shareStatement = shareStatement;
    }

    public Boolean getCommentabled() {
        return commentabled;
    }

    public void setCommentabled(Boolean commentabled) {
        this.commentabled = commentabled;
    }

    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

    public Boolean getRecommened() {
        return recommened;
    }

    public void setRecommened(Boolean recommened) {
        this.recommened = recommened;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", firstPicture='" + firstPicture + '\'' +
                ", flag='" + flag + '\'' +
                ", views=" + views +
                ", appreciation=" + appreciation +
                ", shareStatement=" + shareStatement +
                ", commentabled=" + commentabled +
                ", published=" + published +
                ", recommened=" + recommened +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
