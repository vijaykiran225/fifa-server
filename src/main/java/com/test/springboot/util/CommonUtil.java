package com.test.springboot.util;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.Optional;
import java.util.function.Supplier;

public class CommonUtil {
    public  static  final <T> T processResponse(Response response, Class<T> class1){

        if(response.getStatus()==200){
            T entity = response.readEntity(class1);
            LoggerUtil.logObject(entity);
            return entity;
        }
        else{
            T entity = response.readEntity(class1);
            LoggerUtil.logObject("failure",entity);
            Response errorResponse=Response.status(response.getStatus()).build();
            throw new WebApplicationException(errorResponse);
        }
    }

    public static final <T> Optional<T> wrapOptional(Supplier<T> dataToWrap) {

        try {
            return Optional.ofNullable(dataToWrap.get());
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
