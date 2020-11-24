package org.interview.kafein.consumer.service;

import java.util.ArrayList;

import org.interview.kafein.consumer.model.UserFollowers;
import org.interview.kafein.consumer.repo.UserFollowersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

	@Autowired
	UserFollowersRepository userFollowersRepository;

	@KafkaListener(topics = "kafein", groupId = "group_id")
	public void getMessage(String message) {
		UserFollowers userFollowers = new UserFollowers();
		String[] arr = message.split(";");
		userFollowers.setId(Integer.parseInt(arr[0]));
		ArrayList<Integer> followerList = new ArrayList<Integer>();
		for (int i = 1; i < arr.length; i++) {
			followerList.add(Integer.parseInt(arr[i]));
		}
		userFollowers.setFollowerList(followerList);
		userFollowersRepository.insert(userFollowers);

	}
}
