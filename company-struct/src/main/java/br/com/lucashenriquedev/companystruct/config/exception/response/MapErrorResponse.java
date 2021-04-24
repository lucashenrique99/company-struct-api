package br.com.lucashenriquedev.companystruct.config.exception.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MapErrorResponse {

    private Map<String, String> errors;

}
