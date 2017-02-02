package com.web.dao;

import com.web.entity.Realmess;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by shiyi on 16/9/23.
 */

@Repository("RealmessDAO")
public interface RealmessDAO {
    public Realmess selectRealmessFromId(int id);

    public List<Realmess> selectRealmess(Realmess realmess, int start, int size);

    public int insertRealmess(Realmess realmess);

    public int deleteRealmess(int id);

    public int updateRealmess(Realmess realmess);

}
