package com.twoFMonopoly.UI;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Constants {

    public static final Map<String, String> colors = Stream.of(new String[][] {
            { "Black", "#000000" },
            { "Red", "#ff0000" },
            { "Orange", "#ffaf00" },
            { "Green", "#26ff00" },
            { "Aquamarine", "#00d390" },
            { "Dark Blue", "#1900ff" },
            { "Pink", "#ff00d9" },
            { "Purple", "#b700ff" },
    }).collect(Collectors.toMap(data -> data[0], data -> data[1]));

}
