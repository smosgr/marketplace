import java.math.BigDecimal;
import java.math.RoundingMode;

public class Utils {

    Utils() {
    }

    Double roundTotalToCeiling(Double total) {
        return new BigDecimal(total).setScale(2, RoundingMode.CEILING).doubleValue();
    }

}
