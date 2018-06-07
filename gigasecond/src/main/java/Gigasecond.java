import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Calendar;
import java.util.Date;

class Gigasecond {

    private final int gigasecond = 1000000000;

    private LocalDateTime localDateTime;

    Gigasecond(LocalDate birthDate) {

        localDateTime = birthDate.atStartOfDay();
    }

    Gigasecond(LocalDateTime birthDateTime) {

        localDateTime = birthDateTime;
    }

    LocalDateTime getDate() {

        return localDateTime.plus(gigasecond, ChronoUnit.SECONDS);
    }

}
