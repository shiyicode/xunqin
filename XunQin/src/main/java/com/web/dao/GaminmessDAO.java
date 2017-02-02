package com.web.dao;

import com.web.entity.Gaminmess;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by shiyi on 16/9/23.
 */

@Repository("GaminmessDAO")
public interface GaminmessDAO {
    public Gaminmess selectGaminmessFromId(int id);

    public int selectGaminmessCount();

    public List<Gaminmess> selectGaminmess(Gaminmess gaminmess, int start, int size);

    public int insertGaminmess(Gaminmess gaminmess);

    public int deleteGaminmess(int id);

    public int updateGaminmess(Gaminmess gaminmess);

}
