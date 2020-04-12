package br.pegz.tvp.planner.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.springframework.data.annotation.Id;

import java.util.Set;

@DynamoDBTable(tableName = "member")
@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class Member {
    @Id
    @DynamoDBHashKey
    String uid;
    @DynamoDBRangeKey
    String teamId;
    String name;
    Set<Vacation> vacations;
}
