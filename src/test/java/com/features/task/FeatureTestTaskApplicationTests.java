package com.features.task;

import com.features.task.data.FeatureData;
import com.features.task.dto.FeatureDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = FeatureTestTaskApplication.class)
public class FeatureTestTaskApplicationTests {

    private static final TestRestTemplate TEMPLATE = new TestRestTemplate();
    private static final String FEATURES_URL = "http://localhost:%s/api/features";

    @LocalServerPort
    protected int port;

    @Test
    public void getFeature_notFound() {
        ResponseEntity<FeatureDto> response = TEMPLATE.getForEntity(featuresUrl() + "/123232", FeatureDto.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    public void createFeature_noServices_badRequest() {
        ResponseEntity<FeatureDto> response = TEMPLATE.postForEntity(featuresUrl(), FeatureData.withoutServices(), FeatureDto.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    public void createAndDeleteFeature() {
        ResponseEntity<FeatureDto> createResponse = TEMPLATE.postForEntity(featuresUrl(), FeatureData.ok(), FeatureDto.class);
        assertThat(createResponse.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        FeatureDto featureDto = createResponse.getBody();
        assertThat(featureDto).isNotNull();

        int id = featureDto.getId();
        assertThat(id).isNotNull();

        ResponseEntity<FeatureDto> checkExistenceResponse = TEMPLATE.getForEntity(featuresUrl() + '/' + id, FeatureDto.class);
        assertThat(checkExistenceResponse.getStatusCode()).isEqualTo(HttpStatus.OK);

        TEMPLATE.delete(featuresUrl() + '/' + id);

        ResponseEntity<FeatureDto> checkRemovedResponse = TEMPLATE.getForEntity(featuresUrl() + '/' + id, FeatureDto.class);
        assertThat(checkRemovedResponse.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    private String featuresUrl() {
        return String.format(FEATURES_URL, port);
    }

}
