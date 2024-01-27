package com.gestion.demande.gestiondemande.service.mapper;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MapperService {

    private static final ThreadLocal<ObjectMapper> om = new ThreadLocal<ObjectMapper>() {
        @Override
        protected ObjectMapper initialValue() {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            objectMapper.registerModule(new JavaTimeModule());
            return objectMapper;
        }
    };

    public static ObjectMapper mapper() {
        return om.get();
    }
    public static <T,R> T mapToEntity(R element, Class<T> TClass) {
        return mapper().convertValue(element, TClass);
    }
    public static <T,R> List<T> mapToListEntity(List<R>  listDto, Class<T> TClass) {
        return listDto
                .stream()
                .map(data->mapper().convertValue(data,TClass))
                .toList();

    }

}
