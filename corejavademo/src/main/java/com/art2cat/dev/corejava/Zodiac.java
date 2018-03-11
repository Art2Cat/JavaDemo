package com.art2cat.dev.corejava;

/**
 * com.art2cat.dev.corejava
 *
 * @author Rorschach
 * @date 31/12/2017
 */
public enum Zodiac {
    ARIES {
        @Override
        public String toString() {
            return "I mean action, think later";
        }
    }, TAURUS {
        @Override
        public String toString() {
            return "Pull me up, I'll show what am capable of";
        }
    }, GEMINI {
        @Override
        public String toString() {
            return "I always think about what to think";
        }
    }, CANCER {
        @Override
        public String toString() {
            return "I pile up emotions until they bite";
        }
    }, LEO {
        @Override
        public String toString() {
            return "Look at me and bow";
        }
    }, VIRGO {
        @Override
        public String toString() {
            return "I hate loose talks";
        }
    }, LIBRA {
        @Override
        public String toString() {
            return "Everything gets out of my control";
        }
    }, SCORPIO {
        @Override
        public String toString() {
            return "I dwell in the dark secrets";
        }
    }, SAGITTARIUS {
        @Override
        public String toString() {
            return "I'll act only when I'm sure";
        }
    }, CAPRICORN {
        @Override
        public String toString() {
            return "Life is full of empty dreams";
        }
    }, AQUARIUS {
        @Override
        public String toString() {
            return "World is just a village";
        }
    }, PISCES {
        @Override
        public String toString() {
            return "Catch me, if you can";
        }
    };
    
    @Override
    public abstract String toString();
}
