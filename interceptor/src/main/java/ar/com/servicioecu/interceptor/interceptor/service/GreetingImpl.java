package ar.com.servicioecu.interceptor.interceptor.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class GreetingImpl implements Greeting{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String sayHello(String person, String phrase) throws Exception{

        logger.info("Dentro de sayHello");
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> responseData= new HashMap<>();
        responseData.put(person, phrase);
        return (mapper.writeValueAsString(responseData));
    }

}
