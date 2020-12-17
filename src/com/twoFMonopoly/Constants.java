package com.twoFMonopoly;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Constants {

    public static final Map<String, String> COLORS = Stream.of(new String[][] {
            { "Black", "#000000" },
            { "Red", "#ff0000" },
            { "Orange", "#ffaf00" },
            { "Green", "#26ff00" },
            { "Aquamarine", "#00d390" },
            { "Dark Blue", "#1900ff" },
            { "Pink", "#ff00d9" },
            { "Purple", "#b700ff" },
    }).collect(Collectors.toMap(data -> data[0], data -> data[1]));

    public static final double startingPointMoney = 100;
    public static final int boardsMaxIndex = 27;
    public static final int jailLocation = 14;
    public static final String OPENING_MUSIC = "src/com/twoFMonopoly/UI/assets/opening.mp3";
    public static final String MAIN_MUSIC = "src/com/twoFMonopoly/UI/assets/music.mp3";

}
