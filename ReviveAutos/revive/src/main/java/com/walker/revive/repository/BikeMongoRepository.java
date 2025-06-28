package com.walker.revive.repository;
import com.walker.revive.entity.TwoWheeler;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BikeMongoRepository extends MongoRepository<TwoWheeler, Long> {

}