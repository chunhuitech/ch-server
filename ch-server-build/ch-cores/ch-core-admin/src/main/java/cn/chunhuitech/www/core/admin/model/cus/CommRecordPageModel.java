package cn.chunhuitech.www.core.admin.model.cus;

import java.util.List;

public class CommRecordPageModel {
    private  Integer id;
    private Integer bookId; //classId

    private Integer page; //sort_num

    private String title;

    private String imageUrl; //relative_path

    private List<CommRecordPageBlockModel> blockList;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<CommRecordPageBlockModel> getBlockList() {
        return blockList;
    }

    public void setBlockList(List<CommRecordPageBlockModel> blockList) {
        this.blockList = blockList;
    }
}