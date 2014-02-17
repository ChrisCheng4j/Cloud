package com.mic.dao;

import com.mic.model.Album;

public interface AlbumDao extends BaseDao<Album, Long>{
	
	int getAlbumNum(Long uid, Long albumId);
}
