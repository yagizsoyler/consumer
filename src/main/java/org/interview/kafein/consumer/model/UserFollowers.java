package org.interview.kafein.consumer.model;

import java.util.List;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("user_followers")
public class UserFollowers {

	@PrimaryKey
	private int id;
	@Column("followerlist")
	private List<Integer> followerList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Integer> getFollowerList() {
		return followerList;
	}

	public void setFollowerList(List<Integer> followerList) {
		this.followerList = followerList;
	}

}
