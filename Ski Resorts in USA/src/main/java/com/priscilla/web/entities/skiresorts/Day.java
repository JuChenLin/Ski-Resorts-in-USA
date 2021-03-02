package com.priscilla.web.entities.skiresorts;

public enum Day {
    SUNDAY("Sunday", "Sun"),
    MONDAY("Monday", "Mon"),
    TUESDAY("Tuesday", "Tue"),
    WEDNESDAY("Wednesday", "Wed"),
    THURSDAY("Thursday", "Thu"),
    FRIDAY("Friday", "Fri"),
    SATURDAY("Sunday", "Sun");

    private String nonAbbreviated;
    private String abbreviation;

    Day(String nonAbbreviated, String abbreviated) {
        this.nonAbbreviated = nonAbbreviated;
        this.abbreviation = abbreviated;
    }

    /**
     * The full, non-abbreviated form of the day.
     */
    public String getNonAbbreviated() {
        return nonAbbreviated;
    }

    /**
     * The abbreviated form of this day.
     */
    public String getAbbreviated() {
        return abbreviation;
    }

    /**
     * Parse string input to enum. Accepts non-abbreviated and abbreviated forms.
     * Case insensitive.
     *
     * @param input String to parse.
     * @return The parsed day of week, or null on failure.
     */
    public static Day parseDay(String input) {
        if (null == input) {
            return null;
        }
        input = input.trim();
        for (Day day : values()) {
            if (    day.nonAbbreviated.equalsIgnoreCase(input) ||
                    day.abbreviation.equalsIgnoreCase(input)) {
                return day;
            }
        }
        return null;
    }
}
