package beans;

import java.util.List;

/**
 * @author lixu
 * @create 2021-12-29-18:11
 */
public class pageBean<T> {
    private int totalCount; //总记录数
    private int pageCount; //总分页数
    private int currentPage; //当前页数
    private int limit =5; // 每页显示的记录数
    private List<T> ulist;

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public List<T> getUlist() {
        return ulist;
    }

    public void setUlist(List<T> ulist) {
        this.ulist = ulist;
    }
}
