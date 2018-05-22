package com.zw.bbs.service;

import com.zw.bbs.model.Content;

public interface ContentService {
    Integer insert(Content content);
    Integer delete(Integer id);
}
