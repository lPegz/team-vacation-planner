package br.pegz.tvp.security.rbac.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIndexHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Set;

@DynamoDBTable(tableName = "useraccount")
@Data
@Builder
public class UserAccount implements UserDetails {
    @Id
    @DynamoDBIndexHashKey
    private final String tenantId;
    private final String teamName;
    @DynamoDBRangeKey
    private final String username;
    private final String password;
    private final byte[] passwordSalt;
    private final String email;
    private final Set<Role> authorities;
    private final boolean accountNonExpired;
    private final boolean accountNonLocked;
    private final boolean credentialsNonExpired;
    private final boolean enabled;
}
