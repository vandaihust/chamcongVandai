package com.vandai.mobi.services.impl;

import java.util.List;

import com.vandai.mobi.model.TimeKeeping;

public interface TimeKeepingServiceImpl {
	public TimeKeeping addTimeKeeping(TimeKeeping TimeKeeping);
	public List<TimeKeeping> getAllTimeKeeping();
	public TimeKeeping updateTimeKeeping(TimeKeeping timeKeeping, int id);
	public String deleteTimeKeeping(int id);
	public TimeKeeping getTimeKeepingById(int id);
	public List<TimeKeeping> fakeDataTimeKeeping();
}
