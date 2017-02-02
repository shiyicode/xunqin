package com.web.service;

import com.web.entity.Letter;

import java.util.List;

/**
 * Created by Administrator on 2017/1/19 0019.
 */
public interface LetterService {
    public List<Letter> getLetterById(int userid, int start, int size);
    public int getMaxPage(int userid);
    public boolean addLetter(String mess, int fromid);
}
