package pl.jakubtuminski.distance;

import java.util.List;

public class GoogleDistanceMatrixApiResponse {

    List<Rows> rows;
    private List<String> destination_addresses;
    private List<String> origin_addresses;

    public List<String> getDestination_addresses() {
        return destination_addresses;
    }

    public List<String> getOrigin_addresses() {
        return origin_addresses;
    }

    public List<Rows> getRows() {
        return rows;
    }

    public class Rows {
        List<Element> elements;

        public List<Element> getElements() {
            return elements;
        }
    }


    public class Element {

        Distance distance;
        Duration duration;

        public Distance getDistance() {
            return distance;
        }

        public Duration getDuration() {
            return duration;
        }
    }

    public class Distance {
        String text;
        String value;

        public String getText() {
            return text;
        }

        public String getValue() {
            return value;
        }
    }

    class Duration {
        String text;
        String value;

        public String getText() {
            return text;
        }

        public String getValue() {
            return value;
        }
    }

    @Override
    public String toString() {
        return "GoogleDistanceMatrixApiResponse{" +
                "rows=" + rows +
                ", destination_addresses=" + destination_addresses +
                ", origin_addresses=" + origin_addresses +
                '}';
    }
}
