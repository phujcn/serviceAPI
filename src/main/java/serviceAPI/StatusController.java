package serviceAPI;

/**
 * Created by phujcn on 22/05/2016.
 */
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class StatusController {
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/status")
    public Status status() {
        SC serviceController = new SC();
        return new Status(counter.incrementAndGet(), serviceController.getStatus());
    }
}

