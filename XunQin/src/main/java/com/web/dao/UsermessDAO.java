package com.web.dao;

import com.web.entity.Usermess;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2016/12/15 0015.
 */
@Repository("UsermessDAO")
public interface UsermessDAO {
    public Usermess selectUsermessFromId(int id);

    public List<Usermess> selectUsermess(Usermess usermess, int start, int size);

    public int insertUsermess(Usermess usermess);

    public int deleteUsermess(int id);

    public int updateUsermess(Usermess usermess);
}
