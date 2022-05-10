package br.com.home.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.home.utils.Utils;

@RestController()
public class MathController {

    @RequestMapping(value = "/sum/number-one/{numberOne}/number-two/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable("numberOne") String one, @PathVariable("numberTwo") String two) {
        return Utils.sumInputs(one, two);
    }

    @RequestMapping(value = "/sub/number-one/{numberOne}/number-two/{numberTwo}", method = RequestMethod.GET)
    public Double sub(@PathVariable("numberOne") String one, @PathVariable("numberTwo") String two) {
        return Utils.subInputs(one, two);
    }

    @RequestMapping(value = "/multiply/number-one/{numberOne}/number-two/{numberTwo}", method = RequestMethod.GET)
    public Double multi(@PathVariable("numberOne") String one, @PathVariable("numberTwo") String two) {
        return Utils.multiInputs(one, two);
    }

    @RequestMapping(value = "/median", method = POST)
    public ResponseEntity<Double> median(@RequestBody() Long... values) {

        return ResponseEntity.status(HttpStatus.CREATED).body(Arrays
                .asList(values)
                .stream()
                .mapToDouble(v -> (double) v)
                .average()
                .orElseGet(() -> 0d)
        );

        /*Utils.multiInputs(one, two);*/
    }
}
