package com.github.abigail830.ContractConsumer1;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@EnableAutoConfiguration
@SpringBootTest (classes=ContractConsumer1ApplicationTests.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureStubRunner(ids=("com.github.abigail830:mock-server:+:stubs:6565"),
        repositoryRoot="http://nexus.saraqian.cn/repository/maven-snapshots/",
        stubsMode = StubRunnerProperties.StubsMode.REMOTE
//        stubsMode = StubRunnerProperties.StubsMode.LOCAL
)
public class ContractConsumer1Test {

    RestTemplate restTemplate = new RestTemplate();

    @Test
    public void testGetServiceNameFromContractProvider(){
        Map<String, String> parameterizedType = new HashMap<>();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<String>(null ,headers);

        ResponseEntity<String> responseEntity = restTemplate
                .exchange("http://127.0.0.1:6565/info/name", HttpMethod.GET, requestEntity, String.class, parameterizedType);

        System.out.println(responseEntity.getBody());
    }
}
