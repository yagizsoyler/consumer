package org.interview.kafein.consumer.repo;

import org.interview.kafein.consumer.model.UserFollowers;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface UserFollowersRepository extends CassandraRepository<UserFollowers, Integer> {

}
