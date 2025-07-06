package com.anusruta.expensewon.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Pair<K, V> {
    private K key;
    private V value;
}
