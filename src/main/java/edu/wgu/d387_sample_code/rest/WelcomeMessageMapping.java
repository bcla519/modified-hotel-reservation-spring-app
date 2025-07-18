package edu.wgu.d387_sample_code.rest;

import edu.wgu.d387_sample_code.model.WelcomeMessages;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;

import static edu.wgu.d387_sample_code.model.WelcomeMessages.getWelcomeMessages;
import static java.util.concurrent.Executors.newFixedThreadPool;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class WelcomeMessageMapping {
    @RequestMapping(path = "/welcome", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String[] welcome() {
        ExecutorService messageExecutor = newFixedThreadPool(2);

        return getWelcomeMessages(messageExecutor);
    }
}

