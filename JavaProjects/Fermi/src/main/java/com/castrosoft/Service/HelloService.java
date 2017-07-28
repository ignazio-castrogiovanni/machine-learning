package com.castrosoft.Service;

import org.springframework.stereotype.Component;

/**
 * Created by Ignazio Castrogiovanni on 29/7/17.
 */
@Component
public class HelloService {
    private final String[] hello = {
            "It is no good to try to stop knowledge from going forward. Ignorance is never better than knowledge.",
            "Before I came here I was confused about this subject. Having listened to your lecture I am still confused. But on a higher level.",
            "If I could remember the names of all these particles, I'd be a botanist."
    };

    public String getAwkwardGreeting() {
        int numOfSentences = hello.length;
        int sentenceId = (int) (Math.random() * numOfSentences);

        return hello[sentenceId];
    }
}
