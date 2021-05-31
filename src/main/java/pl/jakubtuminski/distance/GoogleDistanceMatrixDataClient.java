package pl.jakubtuminski.distance;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class GoogleDistanceMatrixDataClient {
    private static final String API_KEY = "KEY";

    private final RestTemplate restTemplate;

    public GoogleDistanceMatrixDataClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public GoogleDistanceMatrixApiResponse getMapResponse(String start, String end){
        ResponseEntity<GoogleDistanceMatrixApiResponse> exchange = restTemplate.exchange(
                "https://maps.googleapis.com/maps/api/distancematrix/json?origins="+start+"&destinations="+end+"&key="+ API_KEY,
                HttpMethod.GET,
                HttpEntity.EMPTY,
                GoogleDistanceMatrixApiResponse.class);
        return exchange.getBody();
    }
}
