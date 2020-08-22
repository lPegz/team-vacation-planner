package br.pegz.tvp.planner.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Set;

@DynamoDBTable(tableName = "member")
@Data
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class Member {
    @Id
    MemberId memberId;
    String teamId;
    String name;
    Set<Vacation> vacations;
    @DynamoDBHashKey(attributeName = "teamId")
    public String getUsername() {
        return memberId != null ? memberId.getTeamId() : null;
    }
    @DynamoDBRangeKey(attributeName = "username")
    public String getTeamId() {
        return memberId != null ?  memberId.getUsername() : null;
    }

    public void setUsername(String username) {
        createIdNull();
        memberId.setUsername(username);
    }

    private void createIdNull() {
        if (memberId == null) {
            memberId = new MemberId();
        }
    }

    public void setTeamId(String teamId) {
        createIdNull();
        memberId.setTeamId(teamId);
    }
}
