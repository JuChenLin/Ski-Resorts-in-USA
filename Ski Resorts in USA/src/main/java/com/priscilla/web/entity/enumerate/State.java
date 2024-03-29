package com.priscilla.web.entity.enumerate;

import java.util.HashMap;
import java.util.Map;

public enum State {

    AL("Alabama", "US-AL"),
    AK("Alaska", "US-AK"),
    AZ("Arizona", "US-AZ"),
    AR("Arkansas", "US-AR"),
    CA("California", "US-CA"),
    CO("Colorado", "US-CO"),
    CT("Connecticut", "US-CT"),
    DE("Delaware", "US-DE"),
    DC("District of Columbia", "US-DC"),
    FL("Florida", "US-FL"),
    GA("Georgia", "US-GA"),
    HI("Hawaii", "US-HI"),
    ID("Idaho", "US-ID"),
    IL("Illinois", "US-IL"),
    IN("Indiana", "US-IN"),
    IA("Iowa", "US-IA"),
    KS("Kansas", "US-KS"),
    KY("Kentucky", "US-KY"),
    LA("Louisiana", "US-LA"),
    ME("Maine", "US-ME"),
    MD("Maryland", "US-MD"),
    MA("Massachusetts", "US-MA"),
    MI("Michigan", "US-MI"),
    MN("Minnesota", "US-MN"),
    MS("Mississippi", "US-MS"),
    MO("Missouri", "US-MO"),
    MT("Montana", "US-MT"),
    NE("Nebraska", "US-NE"),
    NV("Nevada", "US-NV"),
    NH("New Hampshire", "US-NH"),
    NJ("New Jersey", "US-NJ"),
    NM("New Mexico", "US-NM"),
    NY("New York", "US-NY"),
    NC("North Carolina", "US-NC"),
    ND("North Dakota", "US-ND"),
    OH("Ohio", "US-OH"),
    OK("Oklahoma", "US-OK"),
    OR("Oregon", "US-OR"),
    PA("Pennsylvania", "US-PA"),
    RI("Rhode Island", "US-RI"),
    SC("South Carolina", "US-SC"),
    SD("South Dakota", "US-SD"),
    TN("Tennessee", "US-TN"),
    TX("Texas", "US-TX"),
    UT("Utah", "US-UT"),
    VT("Vermont", "US-VT"),
    VA("Virginia", "US-VA"),
    WA("Washington", "US-WA"),
    WV("West Virginia", "US-WV"),
    WI("Wisconsin", "US-WI"),
    WY("Wyoming", "US-WY"),
    PR("Puerto Rico", "US-PR");

    private final String nonAbbreviated;
    private final String abbreviationISO;
    private static final Map<String, State> STATES_ABBR_MAP = new HashMap<String, State>();

    State(String nonAbbreviated, String abbreviationISO) {
        this.nonAbbreviated = nonAbbreviated;
        this.abbreviationISO = abbreviationISO;
    }

    /**
     * The full, non-abbreviated name of this state.
     */
    public String getNonAbbreviated() {
        return this.nonAbbreviated;
    }

    /**
     * The ISO abbreviated name of this state, e.g. "US-NY", or "US-WY".
     */
    public String getAbbreviationISO() {
        return this.abbreviationISO;
    }

    /**
     * Parse string input to enum. Accepts non-abbreviated and abbreviated forms.
     * Case insensitive.
     *
     * @param input String to parse
     * @return The parsed US state, or null on failure.
     */
    public static State parse(String input) {
        if (input == null) {
            return null;
        }
        input = input.trim();
        for (State state : values()) {
            if (    state.toString().equalsIgnoreCase(input) ||
                    state.nonAbbreviated.equalsIgnoreCase(input) ||
                    state.abbreviationISO.equalsIgnoreCase(input)) {
                return state;
            }
        }
        return null;
    }

    private static State parseState(final String input) {
        final State state = STATES_ABBR_MAP.get(input);
        if (state != null) {
            return state;
        } else {
            return null;
        }
    }
}
