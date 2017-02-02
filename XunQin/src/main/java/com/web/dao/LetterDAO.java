package com.web.dao;

import com.web.entity.Letter;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by shiyi on 16/9/23.
 */

@Repository("LetterDAO")
public interface LetterDAO {
    //@Param("id")
    public Letter selectLetterFromId(int id);

    public int selectCountFromId(int id);

    public List<Letter> selectLetter(Letter letter, int start, int size);

    public int insertLetter(Letter letter);

    public int deleteLetter(int id);

    public int updateLetter(Letter letter);

}
