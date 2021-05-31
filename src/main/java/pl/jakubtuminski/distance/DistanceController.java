package pl.jakubtuminski.distance;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DistanceController {

    private final GoogleDistanceMatrixDataClient googleDistanceMatrixDataClient;

    public DistanceController(GoogleDistanceMatrixDataClient googleDistanceMatrixDataClient) {
        this.googleDistanceMatrixDataClient = googleDistanceMatrixDataClient;
    }

    @GetMapping("/distance")
    @ResponseBody
    String getDistance(){
        return googleDistanceMatrixDataClient.getMapResponse("Warszawa", "Radom").getRows().get(0).getElements().get(0).getDistance().getValue();
    }
}
