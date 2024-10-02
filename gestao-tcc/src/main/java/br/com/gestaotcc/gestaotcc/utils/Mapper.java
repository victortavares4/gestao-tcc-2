/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.gestaotcc.gestaotcc.utils;

import br.com.gestaotcc.gestaotcc.resources.service.api.usuario.login.LoginRetornoFrontDto;
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
                .map(function)
                .collect(Collectors.toList()); // Coleta os resultados em uma nova lista
    }
    
    public <R> R comFunction(Function<Object[], R> function, Object[] source) {
        return function.apply(source);
    }
    

}
