package daoInterfaces;

import java.util.List;

import entity.Topic;

public interface TopicDao {

	public void save(Topic topic);
	public void update(Topic topic);
	public List<Topic> query(String hql, Object... params);
	public void execute(final String hql, final Object...params);
	public List<Topic> query1(final String hql, final int firstRow, final int maxRow,
			final Object... params);
	public List<Topic> query2(final String hql, final int firstRow, final int maxRow);
	
}
