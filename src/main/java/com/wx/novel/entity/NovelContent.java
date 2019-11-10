package com.wx.novel.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author lh
 * @since 2019-11-02
 */
public class NovelContent extends Model<NovelContent> {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 标题
     */
    private String title;

    /**
     * publish连载状态，finish完结状态
     */
    private String status;

    /**
     * 作者
     */
    private String author;

    /**
     * 发布时间
     */
    private LocalDateTime displayTime;

    /**
     * 页数
     */
    private Integer section;

    /**
     * 收费还是免费，0免费，1收费
     */
    private String ispay;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public LocalDateTime getDisplayTime() {
        return displayTime;
    }

    public void setDisplayTime(LocalDateTime displayTime) {
        this.displayTime = displayTime;
    }
    public Integer getSection() {
        return section;
    }

    public void setSection(Integer section) {
        this.section = section;
    }
    public String getIspay() {
        return ispay;
    }

    public void setIspay(String ispay) {
        this.ispay = ispay;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "NovelContent{" +
            "id=" + id +
            ", title=" + title +
            ", status=" + status +
            ", author=" + author +
            ", displayTime=" + displayTime +
            ", section=" + section +
            ", ispay=" + ispay +
        "}";
    }
}
