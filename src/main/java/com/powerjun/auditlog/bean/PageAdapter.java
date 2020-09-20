package com.powerjun.auditlog.bean;

import com.baomidou.mybatisplus.core.metadata.IPage;

public class PageAdapter {

    private IPage page;

    public PageAdapter(IPage page) {
        this.page = page;
    }

    public long getTotal() {
        return page.getTotal();
    }

    public Object getRows() {
        return page.getRecords();
    }

}
