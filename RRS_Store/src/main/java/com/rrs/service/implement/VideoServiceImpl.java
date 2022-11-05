package com.rrs.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rrs.Dao.VideoDao;
import com.rrs.entity.Video;
import com.rrs.service.Serviceinterface;
@Service
public class VideoServiceImpl implements Serviceinterface<Video>{
	@Autowired 
	VideoDao videoDao;
	
	@Override
	public void add(Video entity) {
		videoDao.save(entity);
	}

	@Override
	public void update(Long id, Video entity) {
	}

	@Override
	public void delete(Long id) {
		videoDao.deleteById(id);
	}

	@Override
	public List<Video> getAll() {
		return videoDao.findAll();
	}

	@Override
	public Video getById(Long id) {
		return videoDao.findById(id).get();
	}

	@Override
	public Video getBySeri(Long seri) {
		return videoDao.getListBySeri(seri);
	}

}
