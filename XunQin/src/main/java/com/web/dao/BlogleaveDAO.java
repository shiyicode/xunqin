package com.web.dao;

import com.web.entity.Blogleave;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by shiyi on 16/9/23.
 */

@Repository("BlogleaveDAO")
public interface BlogleaveDAO {
    public Blogleave selectBlogleaveFromId(int id);

    public List<Blogleave> selectBlogleave(Blogleave blogleave, int start, int size);

    public int insertBlogleave(Blogleave blogleave);

    public int deleteBlogleave(int id);

    public int updateBlogleave(Blogleave blogleave);

}
