package com.web.dao;

import com.web.entity.Lostmess;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by shiyi on 16/9/23.
 */

@Repository("LostmessDAO")
public interface LostmessDAO {
    public Lostmess selectLostmessFromId(int id);

    public int selectLostmessCount(Lostmess lostmess);

    public List<Lostmess> selectLostmess(Lostmess lostmess, int start, int size);

    public int insertLostmess(Lostmess lostmess);

    public int deleteLostmess(int id);

    public int updateLostmess(Lostmess lostmess);

}
