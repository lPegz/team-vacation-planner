package br.pegz.tvp.security.rbac;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.CreateTableResult;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RbacDataSourceProvisionConfiguration {


    private AmazonDynamoDB dynamoDB;

    public RbacDataSourceProvisionConfiguration() {

    }

    public String createMemberTable() {
        CreateTableRequest tableRequest = new CreateTableRequest();
        tableRequest.setTableName("useraccount");
        CreateTableResult result = dynamoDB.createTable(tableRequest);
        return result.getTableDescription().getTableArn();
    }


}
