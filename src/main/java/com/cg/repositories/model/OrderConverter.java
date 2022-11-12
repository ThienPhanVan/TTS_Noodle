//package com.cg.repositories.model;
//
//import javax.persistence.AttributeConverter;
//import javax.persistence.Converter;
//import java.util.stream.Stream;
//
//@Converter(autoApply = true)
//public class OrderConverter implements AttributeConverter<OrderStatus, String> {
//
//    @Override
//    public String convertToDatabaseColumn(OrderStatus orderStatus) {
//        if (orderStatus == null) {
//            return null;
//        }
//        return orderStatus.getValue();
//    }
//
//    @Override
//    public OrderStatus convertToEntityAttribute(String dbData) {
//
//        if (dbData == null) {
//            return null;
//        }
//
//        return Stream.of(OrderStatus.values())
//                .filter(c -> c.getValue().equals(dbData))
//                .findFirst()
//                .orElseThrow(IllegalArgumentException::new);
//    }
//}
