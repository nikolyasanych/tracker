package ru.collection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderConvert {
    public static Map<String, Order> process(List<Order> orders) {
        Map<String, Order> orderMap = new HashMap<>();
        for (Order order : orders) {
            orderMap.put(order.getNumber(), order);
        }
        return orderMap;
    }
}
