package random;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Random{
    public String getRandomBrand() throws IOException {

        List<String> lines = Files.readAllLines(Paths.get("names.txt"), StandardCharsets.UTF_8);

        return lines.get(ThreadLocalRandom.current().nextInt(0, lines.size()));
    }

    public int getRandomYear() {
        return ThreadLocalRandom.current().nextInt(1950,2021);
    }

    public double getRandomPrice() {
        return ThreadLocalRandom.current().nextDouble(1000,1000000);
    }
}

