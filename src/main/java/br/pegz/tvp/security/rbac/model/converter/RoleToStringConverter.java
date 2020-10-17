package br.pegz.tvp.security.rbac.model.converter;

import br.pegz.tvp.security.rbac.model.Role;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;

import java.util.Set;
import java.util.stream.Collectors;

public class RoleToStringConverter implements DynamoDBTypeConverter<Set<Role>, Set<String>>{
    @Override
    public Set<Role> convert(Set<String> object) {
        return object.stream().map(Role::valueOf).collect(Collectors.toSet());
    }

    @Override
    public Set<String> unconvert(Set<Role> object) {
        return object.stream().map(Role::getAuthority).collect(Collectors.toSet());
    }
}
