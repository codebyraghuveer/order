package com.tech.order.service;

import com.tech.order.entity.Sequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
public class SequenceGenerator {
    @Autowired
    private MongoOperations mongoOperations;

    public int generateNextOrderId() {
        Sequence counter = mongoOperations.findAndModify(

                query(where("_id").is(1)),
                new Update().inc("seq",1),
                FindAndModifyOptions.options().returnNew(true).upsert(true),
                Sequence.class
        );
        return counter.getSeq();
    }
}
