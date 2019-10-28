package com.example.demo.bean;

import org.apache.ibatis.session.RowBounds;

/**
 * @author lyc
 * @date 2019/10/23.
 */
public class Page {

    /**
     * count property 记录总数
     */
    private long count = 0;

    /**
     * pageSize property 每页显示记录数
     */
    private int pageSize = 25;

    /**
     * pageCount property 总页数
     */
    private int pageCount = 0;

    /**
     * page property 当前页数
     */
    private int targetPage = 1;

    private int prePage = 0;

    private int nextPage = 0;

    /**
     * 分页实体Page对象名字
     */
    private String pageName = "";

    /** 表单提交目标 */
    private String formTarget;

    /** 表单id */
    private String formId;

    /** 表单action */
    private String formAction;

    //每页记录条数
    private String[] pageSizeAry = { "5", "15", "25", "50"};

    public int getPrePage() {
        if(targetPage>1)
            prePage = targetPage-1;
        else
            prePage=targetPage;
        return prePage;
    }

    public void setPrePage(int prePage) {
        this.prePage = prePage;
    }

    public int getNextPage() {
        if(targetPage<pageCount)
            nextPage = targetPage+1;
        else
            nextPage=pageCount;
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public Page()
    {
    }

    public Page(String pageName)
    {
        this.pageName = pageName + ".";
    }

    public Page(int pageSize)
    {
        this.pageSize = pageSize;
    }

    public long getCount()
    {
        return count;
    }

    public void setPageSizeAry(String[] pageSizeAry)
    {
        this.pageSizeAry = pageSizeAry;
    }

    /**
     * 设总记录条数
     * @param count
     * @author chenshaoqiang
     */
    public void setCount(long count)
    {
        if (pageSize != 0)
        {
            pageCount = (int) count / pageSize;
            if (count % pageSize != 0)
            {
                pageCount++;
            }
        }
        this.count = count;
    }

    /**
     * 显示简单的分页菜单，无每页显示记录数下拉选择列表
     */
    public String getSimplePageMenu()
    {
        pageHandle();
        StringBuffer str = new StringBuffer();
        int prev, next;
        String pageFirst = "首页";
        String pagePrevious = "上一页";
        String pageNext = "下一页";
        String pageLast = "末页";
        String pageTotal = "共";
        String pageRecord = "条记录";
        String pagePageNum = "页数：";

        String targetPageField = pageName + "targetPage";
        String pageSizeField = pageName + "pageSize";

        //不可翻页的情况下，字体为灰色字体颜色
        String fontColorStyle1 = "<font color='#FFFFFF'>";
        String fontColorStyle2 = "</font>";
        prev = this.getTargetPage() - 1;
        next = this.getTargetPage() + 1;
        //页面每一页的记录条数
        str.append("<span class='pageInput'>一页显示</span><SELECT class='pageSelect' onchange='document.all(\"" + pageSizeField + "\").value=this.value;document.forms[0].submit();'>");
        for (String s : pageSizeAry)
        {
            if (this.getPageSize() == Integer.parseInt(s))
            {
                str.append("<OPTION value=" + s + " selected>" + s + "</OPTION>");
            }
            else
            {
                str.append("<OPTION value=" + s + ">" + s + "</OPTION>");
            }
        }
        str.append("</SELECT><span class='pageInput'>条数据</span>&nbsp;&nbsp;");
        if (this.getTargetPage() > 1)
        {
            str.append("<img src='../resources/image/table/jpgl_ico_07.jpg' onclick='document.all(\"" + targetPageField + "\").value=1;document.forms[0].submit();'/>"
                    + "&nbsp;&nbsp;");
            str.append("<img src='../resources/image/table/jpgl_ico_09.jpg' onclick='document.all(\"" + targetPageField + "\").value=" + prev
                    + ";try{doBeforeSubmit();}catch(e){}finally{document.forms[0].submit();}'/>" + "&nbsp;");
        }
        else
        {
            pageFirst = fontColorStyle1 + pageFirst + fontColorStyle2;
            pagePrevious = fontColorStyle1 + pagePrevious + fontColorStyle2;
            str.append("<img src='../resources/image/table/jpgl_ico_07.jpg' />&nbsp;&nbsp;");
            str.append("<img src='../resources/image/table/jpgl_ico_09.jpg' />&nbsp;&nbsp;");
        }


        str.append("<SELECT size=1 name=Pagelist onchange='document.all(\"" + targetPageField
                + "\").value=this.value;try{doBeforeSubmit();}catch(e){}finally{document.forms[0].submit();}'>");
        int coun = this.getPageCount();
        if (coun > 0)
        {
            for (int i = 1; i < this.getPageCount() + 1; i++)
            {
                if (i == this.getTargetPage())
                {
                    str.append("<OPTION value=" + i + " selected>" + i + "</OPTION>");
                }
                else
                {
                    str.append("<OPTION value=" + i + ">" + i + "</OPTION>");
                }
            }
        }
        else
        {
            str.append("<OPTION value=\"1\">1 / 1</OPTION>");
        }
        str.append("</SELECT>"+ " / " + coun + "&nbsp;&nbsp;");
        if (this.getTargetPage() < this.getPageCount())
        {
            str.append("<img src='../resources/image/table/jpgl_ico_11.jpg' onclick='document.all(\"" + targetPageField + "\").value=" + next
                    + ";try{doBeforeSubmit();}catch(e){}finally{document.forms[0].submit();}'/>" + "&nbsp;&nbsp;");
        }
        else
        {
            pageNext = fontColorStyle1 + pageNext + fontColorStyle2;
            str.append("<img src='../resources/image/table/jpgl_ico_11.jpg' />&nbsp;&nbsp;");
        }
        if (this.getPageCount() > 1 && this.getTargetPage() != this.getPageCount())
        {
            str.append("<img src='../resources/image/table/jpgl_ico_13.jpg'  onclick='document.all(\"" + targetPageField + "\").value=" + this.getPageCount()
                    + ";try{doBeforeSubmit();}catch(e){}finally{document.forms[0].submit();}'/>" + "&nbsp;&nbsp;");
        }
        else
        {
            pageLast = fontColorStyle1 + pageLast + fontColorStyle2;
            str.append("<img src='../resources/image/table/jpgl_ico_13.jpg' />");
        }
        str.append("<INPUT type=hidden  value=" + this.getTargetPage() + " name=\"" + targetPageField + "\" > ");
        str.append("<INPUT type=hidden  value=" + this.getPageSize() + " name=\"" + pageSizeField + "\"> ");
        return str.toString();
    }

    /**
     * 用ajax提交表单分页菜单，无每页显示记录数下拉选择列表
     */
    public String getAjaxPageMenu()
    {
        pageHandle();
        StringBuffer str = new StringBuffer();
        int prev, next;
        String pageFirst = "首页";
        String pagePrevious = "上一页";
        String pageNext = "下一页";
        String pageLast = "末页";
        String pageTotal = "共";
        String pageRecord = "条记录";
        String pagePageNum = "页数：";

        String targetPageField = pageName + "targetPage";
        String pageSizeField = pageName + "pageSize";

        //不可翻页的情况下，字体为灰色字体颜色
        String fontColorStyle1 = "<font color='#666666'>";
        String fontColorStyle2 = "</font>";
        prev = this.getTargetPage() - 1;
        next = this.getTargetPage() + 1;
        if (this.getTargetPage() > 1)
        {
            str.append("<img src='../resources/image/table/jpgl_ico_07.jpg' onclick='document.all(\"" + targetPageField + "\").value=1;unitfind();'/>" + pageFirst + "&nbsp;&nbsp;");
            str.append("<img src='../resources/image/table/jpgl_ico_09.jpg' onclick='document.all(\"" + targetPageField + "\").value=" + prev
                    + ";try{}catch(e){}finally{unitfind();}'/>"
                    + pagePrevious + "</a>&nbsp;");
        }
        else
        {
            pageFirst = fontColorStyle1 + pageFirst + fontColorStyle2;
            pagePrevious = fontColorStyle1 + pagePrevious + fontColorStyle2;
            str.append("<img src='../resources/image/table/jpgl_ico_07.jpg' />&nbsp;&nbsp;");
            str.append("<img src='../resources/image/table/jpgl_ico_07.jpg' />&nbsp;&nbsp;");
        }

        if (this.getTargetPage() < this.getPageCount())
        {
            str.append("<img src='../resources/image/table/jpgl_ico_11.jpg' onclick='document.all(\"" + targetPageField + "\").value=" + next
                    + ";try{}catch(e){}finally{unitfind();}'/>"
                    + "&nbsp;&nbsp;");
        }
        else
        {
            pageNext = fontColorStyle1 + pageNext + fontColorStyle2;
            str.append("<img src='../resources/image/table/jpgl_ico_11.jpg' />&nbsp;&nbsp;");
        }

        if (this.getPageCount() > 1 && this.getTargetPage() != this.getPageCount())
        {
            str.append("<img src='../resources/image/table/jpgl_ico_13.jpg'  onclick='document.all(\"" + targetPageField + "\").value=" + this.getPageCount()
                    + ";try{}catch(e){}finally{unitfind();}'/>"
                    + "&nbsp;&nbsp;");
        }
        else
        {
            pageLast = fontColorStyle1 + pageLast + fontColorStyle2;
            str.append("<img src='../resources/image/table/jpgl_ico_07.jpg' />&nbsp;&nbsp;&nbsp;");
        }

        str.append(" " + pageTotal + this.getCount() + " " + pageRecord);

        str.append("&nbsp;&nbsp;&nbsp;&nbsp;" + pagePageNum + " ");
        str.append("<SELECT size=1 name=Pagelist onchange='document.all(\"" + targetPageField
                + "\").value=this.value;try{}catch(e){}finally{unitfind();}'>");
        int coun = this.getPageCount();
        if (coun > 0)
        {
            for (int i = 1; i < this.getPageCount() + 1; i++)
            {
                if (i == this.getTargetPage())
                {
                    str.append("<OPTION value=" + i + " selected>" + i + "</OPTION>");
                }
                else
                {
                    str.append("<OPTION value=" + i + ">" + i + "</OPTION>");
                }
            }
        }
        else
        {
            str.append("<OPTION value=\"1\">1 / 1</OPTION>");
        }
        str.append("</SELECT>"+ " / " + coun + "&nbsp;&nbsp;");

        str.append("<INPUT type=hidden  value=" + this.getTargetPage() + " name=\"" + targetPageField + "\" > ");
        str.append("<INPUT type=hidden  value=" + this.getPageSize() + " name=\"" + pageSizeField + "\"> ");
        return str.toString();
    }

    /**
     * 显示标准的分页菜单
     */
    public String getPageMenu()
    {
        pageHandle();
        StringBuffer str = new StringBuffer();
        int prev, next;
        String pageFirst = "首页";
        String pagePrevious = "上一页";
        String pageNext = "下一页";
        String pageLast = "末页";
        String pageTotal = "共";
        String pageRecord = "条记录";
        String pagePageNum = "页数：";

        String targetPageField = pageName + "targetPage";
        String pageSizeField = pageName + "pageSize";

        //不可翻页的情况下，字体为灰色字体颜色
        String fontColorStyle1 = "<font color='#666666'>";
        String fontColorStyle2 = "</font>";
        prev = this.getTargetPage() - 1;
        next = this.getTargetPage() + 1;
        if (this.getTargetPage() > 1)
        {
            str.append("<a href=javascript:void(0) onclick=javascript:document.getElementById('" + targetPageField + "').value=1;document.forms['form'].submit();>" + pageFirst
                    + "</a>&nbsp;&nbsp;");
            str.append("<a href=javascript:void(0) onclick=javascript:document.getElementById('" + targetPageField + "').value=" + prev
                    + ";document.forms['form'].submit();>" + pagePrevious + "</a>&nbsp;");
        }
        else
        {
            pageFirst = fontColorStyle1 + pageFirst + fontColorStyle2;
            pagePrevious = fontColorStyle1 + pagePrevious + fontColorStyle2;
            str.append("<a>" + pageFirst + "</a>&nbsp;&nbsp;");
            str.append("<a>" + pagePrevious + "</a>&nbsp;&nbsp;");
        }

        if (this.getTargetPage() < this.getPageCount())
        {
            str.append("<a href=javascript:void(0) onclick=javascript:document.getElementById('" + targetPageField + "').value=" + next
                    + ";document.forms['form'].submit();>" + pageNext + "</a>&nbsp;&nbsp;");
        }
        else
        {
            pageNext = fontColorStyle1 + pageNext + fontColorStyle2;
            str.append("<a>" + pageNext + "</a>&nbsp;&nbsp;");
        }

        if (this.getPageCount() > 1 && this.getTargetPage() != this.getPageCount())
        {
            str.append("<a href=javascript:void(0)  onclick=javascript:document.getElementById('" + targetPageField + "').value=" + this.getPageCount()
                    + ";document.forms['form'].submit();>" + pageLast + "</a>&nbsp;&nbsp;");
        }
        else
        {
            pageLast = fontColorStyle1 + pageLast + fontColorStyle2;
            str.append("<a>" + pageLast + "</a>&nbsp;&nbsp;&nbsp;");
        }

        //页面每一页的记录条数
        str.append("<SELECT onchange=javascript:document.getElementById('" + pageSizeField + "').value=this.value;document.forms['form'].submit();>");
        for (String s : pageSizeAry)
        {
            if (this.getPageSize() == Integer.parseInt(s))
            {
                str.append("<OPTION value=" + s + " selected>" + s + "</OPTION>");
            }
            else
            {
                str.append("<OPTION value=" + s + ">" + s + "</OPTION>");
            }
        }
        str.append("</SELECT>");
        str.append(" " + pageTotal + this.getCount() + " " + pageRecord);

        str.append("&nbsp;&nbsp;&nbsp;&nbsp;" + pagePageNum + " ");
        str.append("<SELECT size=1 name=Pagelist onchange=javascript:document.getElementById('" + targetPageField
                + "').value=this.value;document.forms['form'].submit();>");
        int coun = this.getPageCount();
        if (coun > 0)
        {
            for (int i = 1; i < this.getPageCount() + 1; i++)
            {
                if (i == this.getTargetPage())
                {
                    str.append("<OPTION value=" + i + " selected>" + i + " / " + coun + "</OPTION>");
                }
                else
                {
                    str.append("<OPTION value=" + i + ">" + i + " / " + coun + "</OPTION>");
                }
            }
        }
        else
        {
            str.append("<OPTION value=\"1\">1 / 1</OPTION>");
        }

        str.append("</SELECT>");
        str.append("<INPUT type=hidden  value=" + this.getTargetPage() + " name=\"" + targetPageField + "\" id=\"" + targetPageField + "\" > ");
        str.append("<INPUT type=hidden  value=" + this.getPageSize() + " name=\"" + pageSizeField + "\" id=\"" + pageSizeField + "\"> ");
        return str.toString();
    }

    public String getPageMenu2()
    {
        pageHandle();
        StringBuffer str = new StringBuffer();
        int prev, next;
        String pageFirst = "首页";
        String pagePrevious = "上一页";
        String pageNext = "下一页";
        String pageLast = "末页";
        String pageTotal = "共";
        String pageRecord = "条记录";

        String targetPageField = pageName + "targetPage";
        String pageSizeField = pageName + "pageSize";

        //不可翻页的情况下，字体为灰色字体颜色
        String fontColorStyle1 = "<font color='#666666'>";
        String fontColorStyle2 = "</font>";
        prev = this.getTargetPage() - 1;
        next = this.getTargetPage() + 1;
        if (this.getTargetPage() > 1)
        {
            str.append("<a href=javascript:void(0) onclick=javascript:document.getElementById('" + targetPageField + "').value=1;document.forms['form'].submit();>" + pageFirst
                    + "</a>&nbsp;&nbsp;");
            str.append("<a href=javascript:void(0) onclick=javascript:document.getElementById('" + targetPageField + "').value=" + prev
                    + ";document.forms['form'].submit();>" + pagePrevious + "</a>&nbsp;");
        }
        else
        {
            pageFirst = fontColorStyle1 + pageFirst + fontColorStyle2;
            pagePrevious = fontColorStyle1 + pagePrevious + fontColorStyle2;
            str.append("<a>" + pageFirst + "</a>&nbsp;&nbsp;");
            str.append("<a>" + pagePrevious + "</a>&nbsp;&nbsp;");
        }

        if (this.getTargetPage() < this.getPageCount())
        {
            str.append("<a href=javascript:void(0) onclick=javascript:document.getElementById('" + targetPageField + "').value=" + next
                    + ";document.forms['form'].submit();>" + pageNext + "</a>&nbsp;&nbsp;");
        }
        else
        {
            pageNext = fontColorStyle1 + pageNext + fontColorStyle2;
            str.append("<a>" + pageNext + "</a>&nbsp;&nbsp;");
        }

        if (this.getPageCount() > 1 && this.getTargetPage() != this.getPageCount())
        {
            str.append("<a href=javascript:void(0)  onclick=javascript:document.getElementById('" + targetPageField + "').value=" + this.getPageCount()
                    + ";document.forms['form'].submit();>" + pageLast + "</a>&nbsp;&nbsp;");
        }
        else
        {
            pageLast = fontColorStyle1 + pageLast + fontColorStyle2;
            str.append("<a>" + pageLast + "</a>&nbsp;&nbsp;&nbsp;");
        }

        str.append("</SELECT>");
        str.append(" " + pageTotal + this.getCount() + " " + pageRecord);

        str.append("<INPUT type=hidden  value=" + this.getTargetPage() + " name=\"" + targetPageField + "\" id=\"" + targetPageField + "\" > ");
        str.append("<INPUT type=hidden  value=" + this.getPageSize() + " name=\"" + pageSizeField + "\" id=\"" + pageSizeField + "\"> ");
        return str.toString();
    }

    public String getBootstrapPage() {
        pageHandle();
        StringBuffer str = new StringBuffer();
        int prev, next;

        String targetPageField = pageName + "targetPage";
        String pageSizeField = pageName + "pageSize";

        prev = this.getTargetPage() - 1;
        next = this.getTargetPage() + 1;
        // 页面每一页的记录条数
        str.append("<ul class='pagination'>");

        // 上一页状态控制
        if (this.getTargetPage() == 1) {
            str.append("<li class='disabled'><a href='javascript:void(0)'>&laquo;</a></li>");
        } else if (this.getTargetPage() > 1) {
            str.append("<li><a href='javascript:$(\"input[name="+targetPageField+"]\").val(" + prev
                    + ");try{doBeforeSubmit();}catch(e){}finally{$(\"#searchForm\").submit();}'>&laquo;</a></li>");
        }

        // 中间页状态控制
        int pageLimit = 0;
        if (this.getTargetPage() <= 6) {
            pageLimit = 11;
            if (this.getPageCount() < 10) {
                pageLimit = this.getPageCount();
            }
            for (int i = 1; i <= pageLimit; i++) {
                if (i != this.getTargetPage()) {
                    str.append("<li><a href='javascript:$(\"input[name="+targetPageField+"]\").val(" + i
                            + ");try{doBeforeSubmit();}catch(e){}finally{$(\"#searchForm\").submit();}'>" + i
                            + "</a></li>");
                } else {
                    str.append("<li class='active'><a href='javascript:$(\"input[name="+targetPageField+"]\").val(" + i
                            + ");try{doBeforeSubmit();}catch(e){}finally{$(\"#searchForm\").submit();}'>" + i
                            + "</a></li>");
                }
            }
        } else {
            pageLimit = this.getTargetPage() + 4;
            if (this.getPageCount() < this.getTargetPage() + 4) {
                pageLimit = this.getPageCount();
            }
            for (int i = this.getTargetPage() - 5; i <= pageLimit; i++) {
                if (i != this.getTargetPage()) {
                    str.append("<li><a href='javascript:$(\"input[name="+targetPageField+"]\").val(" + i
                            + ");try{doBeforeSubmit();}catch(e){}finally{$(\"#searchForm\").submit();}'>" + i
                            + "</a></li>");
                } else {
                    str.append("<li class='active'><a href='javascript:$(\"input[name="+targetPageField+"]\").val(" + i
                            + ");try{doBeforeSubmit();}catch(e){}finally{$(\"#searchForm\").submit();}'>" + i
                            + "</a></li>");
                }
            }
        }
        // 下一页页状态控制
        if (this.getTargetPage() >= this.getPageCount()) {
            str.append("<li class='disabled'><a href='javascript:script:void(0)'>&raquo;</a></li>");
        } else {
            str.append("<li><a href='javascript:$(\"input[name="+targetPageField+"]\").val(" + next
                    + ");try{doBeforeSubmit();}catch(e){}finally{$(\"#searchForm\").submit();}'>&raquo;</a></li>");
        }

        str.append("</ul>");
        str.append("<input type='hidden'  value=" + this.getTargetPage() + " name=\"" + targetPageField + "\" /> ");
        str.append("<input type='hidden'  value=" + this.getPageSize() + " name=\"" + pageSizeField + "\" /> ");
        return str.toString();
    }

    /**
     * 分页处理
     * @author chenshaoqiang
     */
    private void pageHandle()
    {
        if (count == 0)
        {
            targetPage = 1;
            pageCount = 1;
            return;
        }

        //当前页大于总页数，设置为当前页为总页数

        if (targetPage > pageCount)
        {
            if (targetPage != 2)
                targetPage = pageCount;
        }
    }

    public int getTargetPage()
    {
        return targetPage;
    }

    public void setTargetPage(int targetPage)
    {
        this.targetPage = targetPage;
    }

    public int getPageCount()
    {
        return pageCount;
    }

    public void setPageCount(int pageCount)
    {
        this.pageCount = pageCount;
    }

    public int getPageSize()
    {
        return pageSize;
    }

    public void setPageSize(int pageSize)
    {
        this.pageSize = pageSize;
    }

    public String getFormAction()
    {
        return formAction;
    }

    public void setFormAction(String formAction)
    {
        this.formAction = formAction;
    }

    public String getFormId()
    {
        return formId;
    }

    public void setFormId(String formId)
    {
        this.formId = formId;
    }

    public String getFormTarget()
    {
        return formTarget;
    }

    public void setFormTarget(String formTarget)
    {
        this.formTarget = formTarget;
    }

    public RowBounds getRowBounds() {
        if (this.targetPage > this.pageCount) {
            this.targetPage = this.pageCount;
        }
        RowBounds rowBounds = new RowBounds((this.targetPage - 1) * pageSize, pageSize);
        return rowBounds;
    }

    public int getStartIndex() {
        if (this.pageCount > 0 && this.targetPage > 1) {
            if (this.targetPage > this.pageCount) {
                this.targetPage = this.pageCount;
            }
        }
        return ((this.targetPage - 1) * pageSize);
    }
}