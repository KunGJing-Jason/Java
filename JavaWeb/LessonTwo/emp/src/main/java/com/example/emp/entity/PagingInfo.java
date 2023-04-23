package com.example.emp.entity;

public class PagingInfo {
    //    当前 1 页, 总 3 页, 共 11 条记录
//    首页 上一页 下一页 尾页
    /**
     * 每页多少行
     */
    long rowPerPage=5;

    long currentPageNum=1;
    long totalPageCount;
    long totalRowSize;
    long prePageNum;
    long nextPageNum;

    /**
     * 设置每页多少行
     */
    public long getRowPerPage() {
        return rowPerPage;
    }
    /**
     * 获取每页多少行
     */
    public void setRowPerPage(long rowPerPage) {
        this.rowPerPage = rowPerPage;
    }

    public long getCurrentPageNum() {
        return currentPageNum;
    }


    public void setCurrentPageNum(long currentPageNum) {
        this.currentPageNum = currentPageNum;
    }

    public long getTotalPageCount() {
        //totalRowSize  5 rowsPerPage
        //  totalRowSize/rowPerPage
        //totalPageCount = totalRowSize/rowPerPage;
        //                     1          5  =>  0    +1
        //                     5          5      1    1
        //                     6          5      1.x  2
        //                     10         5      2    2
        //
        if(totalRowSize%rowPerPage==0) { //能整除
            totalPageCount = totalRowSize/rowPerPage;
        }else{
            totalPageCount = totalRowSize/rowPerPage+1;
        }
        return totalPageCount;
    }

//    public void setTotalPageCount(long totalPageCount) {
//        this.totalPageCount = totalPageCount;
//    }

    public long getTotalRowSize() {
        return totalRowSize;
    }

    public void setTotalRowSize(long totalRowSize) {
        this.totalRowSize = totalRowSize;
        getTotalPageCount(); //总页数
    }

    public long getPrePageNum() {
        return prePageNum;
    }

    public void setPrePageNum(long prePageNum) {
        this.prePageNum = prePageNum;
    }

    public long getNextPageNum() {
        return nextPageNum;
    }

    public void setNextPageNum(long nextPageNum) {
        this.nextPageNum = nextPageNum;
    }

    /**
     * MySQL中用的查询起始行 limit startRow,size
     * @return
     */
    public long getStartRow() {
        //long startRow=0; //getTotalPageCount() 1 rowPerPage 5
        //                              当前第几页currentPageNum
        //page 1: startRow=0           （1-1)*5
        //page 2:  startRow=5          （2-1)*5
        //                 （currentPageNum -1)*rowPerPage
        return (currentPageNum -1)*rowPerPage;  //(第几页-1)*每页多少行
    }

    public void resetProperites() {
//        当前 1 页, 总 3 页, 共 11 条记录
//        首页 上一页 下一页 尾页
        //this.currentPageNum
        //this.totalPageCount
        //this.totalRowSize
        //首页===1
        this.prePageNum = currentPageNum<=1?1:currentPageNum -1;
        this.nextPageNum = currentPageNum>=totalPageCount?totalPageCount:currentPageNum+1;
        //this.lastPageNum = 尾页 totalPageCount;
    }

    public void setProperitesByTotalRowSize(Long totalRowSize) {
        this.totalRowSize = totalRowSize;
        //getTotalPageCount();
        if(totalRowSize%rowPerPage==0) { //能整除
            totalPageCount = totalRowSize/rowPerPage;
        }else{
            totalPageCount = totalRowSize/rowPerPage+1;
        }

        this.prePageNum = currentPageNum<=1?1:currentPageNum -1;
        this.nextPageNum = currentPageNum>=totalPageCount?totalPageCount:currentPageNum+1;
    }
}
