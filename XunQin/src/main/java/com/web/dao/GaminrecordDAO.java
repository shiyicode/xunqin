package com.web.dao;

import com.web.entity.Gaminrecord;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by shiyi on 16/9/23.
 */

@Repository("GaminrecordDAO")
public interface GaminrecordDAO {
    public Gaminrecord selectGaminrecordFromId(int id);

    public List<Gaminrecord> selectGaminrecord(Gaminrecord gaminrecord, int start, int size);

    public int insertGaminrecord(Gaminrecord gaminrecord);

    public int deleteGaminrecord(int id);

    public int updateGaminrecord(Gaminrecord gaminrecord);

}
