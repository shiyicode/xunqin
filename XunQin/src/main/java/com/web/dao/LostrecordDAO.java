package com.web.dao;

import com.web.entity.Lostrecord;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by shiyi on 16/9/23.
 */

@Repository("LostrecordDAO")
public interface LostrecordDAO {
    public Lostrecord selectLostrecordFromId(int id);

    public int selectCountFromId(int id);

    public List<Lostrecord> selectLostrecord(Lostrecord lostrecord, int start, int size);

    public int insertLostrecord(Lostrecord lostrecord);

    public int deleteLostrecord(int id);

    public int updateLostrecord(Lostrecord lostrecord);

}
