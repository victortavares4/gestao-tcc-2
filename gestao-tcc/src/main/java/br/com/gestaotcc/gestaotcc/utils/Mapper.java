/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.gestaotcc.gestaotcc.utils;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
/**
 *
 * @author Nicolas
 */
public class Mapper {
     public <T, R> List<R> comFunction(Function<T, R> function, List<T> sourceList) {
        return sourceList.stream()
                .map(function) // Aplica a função fornecida
                .collect(Collectors.toList()); // Coleta os resultados em uma nova lista
    }
}
