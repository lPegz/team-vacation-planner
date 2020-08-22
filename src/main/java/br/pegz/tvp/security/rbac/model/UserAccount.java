package br.pegz.tvp.security.rbac.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Set;

@DynamoDBTable(tableName = "useraccount")
@Data
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Builder
public class UserAccount implements UserDetails {
    @Id
    UserAccountId userAccountId;
    String password;
    byte[] passwordSalt;
    String email;
    Set<Role> authorities;
    boolean accountNonExpired;
    boolean accountNonLocked;
    boolean credentialsNonExpired;
    boolean enabled;

    @DynamoDBHashKey(attributeName = "username")
    public String getUsername() {
        return userAccountId != null ? userAccountId.getUsername() : null;
    }
    @DynamoDBRangeKey(attributeName = "teamId")
    public String getTeamId() {
        return userAccountId != null ?  userAccountId.getTeamId() : null;
    }

}
