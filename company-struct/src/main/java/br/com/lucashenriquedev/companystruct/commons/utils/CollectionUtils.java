package br.com.lucashenriquedev.companystruct.commons.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionUtils {

    /**
     * Util method to create lists with initial elements.
     * Unlike Collections.singletonList, this method returns a mutable list.
     *
     * @param elements Initial elements
     * @param <T>      Any class
     * @return Returns a new mutable list
     */
    @SafeVarargs
    public static <T> List<T> newList(T... elements) {
        return new ArrayList<>(Arrays.asList(elements));
    }

}
