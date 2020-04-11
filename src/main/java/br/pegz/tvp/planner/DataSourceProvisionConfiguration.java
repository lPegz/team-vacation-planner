package br.pegz.tvp.planner;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.CreateTableResult;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceProvisionConfiguration {

    private AmazonDynamoDB dynamoDB;

    public DataSourceProvisionConfiguration() {

    }

    public String createMemberTable() {
        CreateTableRequest tableRequest = new CreateTableRequest();
        tableRequest.setTableName("member");
        CreateTableResult result = dynamoDB.createTable(tableRequest);
        return result.getTableDescription().getTableArn();
    }

}
