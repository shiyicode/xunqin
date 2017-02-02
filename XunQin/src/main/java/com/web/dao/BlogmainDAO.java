package com.web.dao;

import com.web.entity.Blogmain;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by shiyi on 16/9/23.
 */

@Repository("BlogmainDAO")
public interface BlogmainDAO {
    public Blogmain selectBlogmainFromId(int id);

    public List<Blogmain> selectBlogmain(Blogmain blogmain, int start, int size);

    public int insertBlogmain(Blogmain blogmain);

    public int deleteBlogmain(int id);

    public int updateBlogmain(Blogmain blogmain);

}
